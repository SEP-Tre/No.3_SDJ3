package via.sdj3.grpcslaughterhouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import via.sdj3.grpcslaughterhouse.model.Animal;
import via.sdj3.grpcslaughterhouse.model.Part;
import via.sdj3.grpcslaughterhouse.model.Product;
import via.sdj3.grpcslaughterhouse.model.Tray;
import via.sdj3.grpcslaughterhouse.protobuf.*;
import via.sdj3.grpcslaughterhouse.repository.AnimalRepository;
import via.sdj3.grpcslaughterhouse.repository.PartRepository;
import via.sdj3.grpcslaughterhouse.repository.ProductRepository;
import via.sdj3.grpcslaughterhouse.repository.TrayRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class SlaughterAssistant
{
    private final AnimalRepository animalRepository;
    private final PartRepository partRepository;
    private final TrayRepository trayRepository;
    private final ProductRepository productRepository;

    public SlaughterAssistant(AnimalRepository animalRepository, PartRepository partRepository, TrayRepository trayRepository, ProductRepository productRepository)
    {
        this.animalRepository = animalRepository;
        this.partRepository = partRepository;
        this.trayRepository = trayRepository;
        this.productRepository = productRepository;
    }


    public Animal getAnimal(AnimalMsg request)
    {
        Animal animalToSave = new Animal();
        animalToSave.setWeight(request.getWeight());
        animalToSave.setAnimal_type(request.getType());
        animalToSave.setAnimal_id(request.getId());
        animalToSave.setConverted(request.getIsConverted());
        return animalToSave;
    }

    public ProductList getProductList(List<Product> products)
    {
        ArrayList<ProductMsg> productMsgs = new ArrayList<>();
        for (Product product :
                products)
        {
            productMsgs.add(getProductMsg(product));
        }
        return ProductList.newBuilder()
                .addAllProducts(productMsgs)
                .build();
    }

    public ProductMsg getProductMsg(Product product)
    {
        return ProductMsg.newBuilder()
                .setProductId(product.getProductId())
                .setProductType(product.getProductType())
                .setTrays(getTrayList(product.getTrays()))
                .build();
    }

    public TrayList getTrayList(List<Tray> trays)
    {
        ArrayList<TrayMsg> trayMsgs = new ArrayList<>();
        for (Tray tray :
                trays)
        {
            trayMsgs.add(getTrayMsg(tray));
        }
        return TrayList.newBuilder().addAllTrays(trayMsgs).build();
    }

   public AnimalList getAnimalList(List<Animal> animals)
   {
       ArrayList<AnimalMsg> animalMsgs = new ArrayList<>();
       animals.forEach(animal ->
       {
           AnimalMsg animalMsg = getAnimalMsg(animal);
           animalMsgs.add(animalMsg);
       });
       return AnimalList.newBuilder().addAllAnimals(animalMsgs).build();
   }
    public TrayMsg getTrayMsg(Tray tray)
    {
        return TrayMsg.newBuilder()
                .setTrayId(tray.getTrayId())
                .setWeightCapacity(tray.getWeightCapacity())
                .setPartName(tray.getPartName())
                .setParts(getPartList(tray.getParts()))
                .build();
    }

    public PartList getPartList(List<Part> parts)
    {
        ArrayList<PartMsg> partMsgs = new ArrayList<>();
        for (Part part :
                parts)
        {
            partMsgs.add(getPartMsg(part));
        }
        return PartList.newBuilder()
                .addAllParts(partMsgs)
                .build();
    }

    public PartMsg getPartMsg(Part part)
    {
        return PartMsg.newBuilder()
                .setPartId(part.getPartId())
                .setAnimal(getAnimalMsg(part.getAnimal()))
                .setPartName(part.getPartName())
                .setWeight(part.getWeight())
                .setIsInProduct(part.isInProduct())
                .setIsInTray(part.isInTray())
                .build();
    }

    public AnimalMsg getAnimalMsg(Animal animal)
    {
        return AnimalMsg.newBuilder()
                .setWeight(animal.getWeight())
                .setType(animal.getAnimal_type())
                .setId(animal.getAnimal_id())
                .setIsConverted(animal.isConverted())
                .build();
    }

    public PartList convertAnimalIntoParts(Animal animal)
    {
        String type = animal.getAnimal_type().toLowerCase();
        ArrayList<Part> parts = new ArrayList<>();
        switch (type)
        {
            case "duck":

            case "chicken":
            {
                parts.add(new Part(animal, "wing", animal.getWeight() / 8));
                parts.add(new Part(animal, "wing", animal.getWeight() / 8));
                parts.add(new Part(animal, "breast", animal.getWeight() / 8));
                parts.add(new Part(animal, "breast", animal.getWeight() / 8));
                parts.add(new Part(animal, "bones", animal.getWeight() / 4));
                parts.add(new Part(animal, "leg", animal.getWeight() / 8));
                parts.add(new Part(animal, "leg", animal.getWeight() / 8));
                break;
            }
            default://Default is cow
            {
                //4 legs, ribs, head, tenderloin, chuck
                parts.add(new Part(animal, "leg", animal.getWeight() / 8));
                parts.add(new Part(animal, "leg", animal.getWeight() / 8));
                parts.add(new Part(animal, "leg", animal.getWeight() / 8));
                parts.add(new Part(animal, "leg", animal.getWeight() / 8));
                parts.add(new Part(animal, "chuck", animal.getWeight() / 16));
                parts.add(new Part(animal, "chuck", animal.getWeight() / 16));
                parts.add(new Part(animal, "ribs", animal.getWeight() / 16));
                parts.add(new Part(animal, "ribs", animal.getWeight() / 16));
                parts.add(new Part(animal, "head", animal.getWeight() / 8));
                parts.add(new Part(animal, "tenderloin", animal.getWeight() / 32));
                parts.add(new Part(animal, "tenderloin", animal.getWeight() / 32));
            }

        }
        // Update the animal's converted boolean
        Animal convertedAnimal = animalRepository.findById(animal.getAnimal_id()).get();
        convertedAnimal.setConverted(true);
        animalRepository.save(convertedAnimal);

        // Set all parts to not be in a tray or product
        // Set all parts to have converted animals
        parts.forEach(part ->
        {
            part.setInTray(false);
            part.setInProduct(false);
            Animal animal1 = part.getAnimal();
            animal1.setConverted(true);
            part.setAnimal(animal1);
        });

        // Save the parts to the repository
        ArrayList<Part> savedParts = (ArrayList<Part>) partRepository.saveAll(parts);

        return getPartList(savedParts);
    }

    // Used to get the parts needed for a half animal product based on the type
    public ArrayList<Tray> getPartsFromTrays(String animalType)
    {
        ArrayList<Tray> animalTrays = findAnimalTrays(animalType);
        ArrayList<Tray> productTrays = new ArrayList<>();
        // TODO set isInProduct
        switch (animalType.toLowerCase())
        {
            case "cow":
            {
                // get 2 legs
                boolean legsFound = false;
                for (Tray tray : animalTrays)
                {
                    // Break out of the search for legs if 2 are found
                    if (legsFound)
                    {
                        break;
                    }
                    if (tray.getPartName().contains("leg"))
                    {

                        // For trays that have legs, find 2 legs and put them in the product
                        // Otherwise, go to the next tray and leave the other tray alone
                        ArrayList<Part> chosenLegs = new ArrayList<>();
                        for (Part part :
                                tray.getParts())
                        {
                            if (!part.isInProduct())
                            {
                                chosenLegs.add(part);
                            }
                            if (chosenLegs.size() == 2)
                            {
                                chosenLegs.forEach(part1 ->
                                {
                                    // Set the part as being in a product
                                    part1.setInProduct(true);
                                    // Save to the repository to update it
                                    partRepository.save(part1);
                                });
                                productTrays.add(tray);
                                legsFound = true;
                                break;
                            }
                        }
                    }
                }
                // ribs
                boolean ribsFound = false;
                for (Tray tray : animalTrays)
                {
                    if (ribsFound)
                    {
                        break;
                    }
                    if (tray.getPartName().contains("ribs"))
                    {
                        for (Part part :
                                tray.getParts())
                        {
                            if (!part.isInProduct())
                            {
                                part.setInProduct(true);
                                partRepository.save(part);
                                productTrays.add(tray);
                                ribsFound = true;
                                break;
                            }
                        }
                    }
                }
                // chuck
                boolean chuckFound = false;
                for (Tray tray : animalTrays)
                {
                    if (chuckFound)
                    {
                        break;
                    }
                    if (tray.getPartName().contains("chuck"))
                    {
                        for (Part part :
                                tray.getParts())
                        {
                            if (!part.isInProduct())
                            {
                                part.setInProduct(true);
                                partRepository.save(part);
                                productTrays.add(tray);
                                chuckFound = true;
                                break;
                            }
                        }
                    }
                }
                // tenderloin
                boolean tenderloinFound = false;
                for (Tray tray : animalTrays)
                {
                    if (tenderloinFound)
                    {
                        break;
                    }
                    if (tray.getPartName().contains("tenderloin"))
                    {
                        for (Part part :
                                tray.getParts())
                        {
                            if (!part.isInProduct())
                            {
                                part.setInProduct(true);
                                partRepository.save(part);
                                productTrays.add(tray);
                                tenderloinFound = true;
                                break;
                            }
                        }
                    }
                }
            }
            break;
            case "chicken":
            {
                // wing
                boolean wingFound = false;
                for (Tray tray : animalTrays)
                {
                    if (wingFound)
                    {
                        break;
                    }
                    if (tray.getPartName().contains("wing"))
                    {
                        for (Part part :
                                tray.getParts())
                        {
                            if (!part.isInProduct())
                            {
                                part.setInProduct(true);
                                partRepository.save(part);
                                productTrays.add(tray);
                                wingFound = true;
                                break;
                            }
                        }
                    }
                }
                // breast
                boolean breastFound = false;
                for (Tray tray : animalTrays)
                {
                    if (breastFound)
                    {
                        break;
                    }
                    if (tray.getPartName().contains("breast"))
                    {
                        for (Part part :
                                tray.getParts())
                        {
                            if (!part.isInProduct())
                            {
                                part.setInProduct(true);
                                partRepository.save(part);
                                productTrays.add(tray);
                                breastFound = true;
                                break;
                            }
                        }
                    }
                }
                // leg
                boolean legFound = false;
                for (Tray tray : animalTrays)
                {
                    if (legFound)
                    {
                        break;
                    }
                    if (tray.getPartName().contains("leg"))
                    {
                        for (Part part :
                                tray.getParts())
                        {
                            if (!part.isInProduct())
                            {
                                part.setInProduct(true);
                                partRepository.save(part);
                                productTrays.add(tray);
                                legFound = true;
                                break;
                            }
                        }
                    }
                }
            }
            break;
            default:
                throw new IllegalArgumentException("Sorry you can't make a half animal from that");
        }
        return productTrays;
    }

    // Gets all the trays from a specified animal
    public ArrayList<Tray> findAnimalTrays(String animalType)
    {
        ArrayList<Tray> allTrays = (ArrayList<Tray>) trayRepository.findAll();
        ArrayList<Tray> animalTrays = new ArrayList<>();
        for (Tray tray : allTrays)
        {
            // Can we shorten this method?
            if (tray.getParts().get(0).getAnimal().getAnimal_type().equals(animalType))
            {
                animalTrays.add(tray);
                System.out.println("I added a tray: " + tray);
            }
        }
        return animalTrays;
    }

    //Converting Traylist into an ArrayList of Trays.
    public ArrayList<Tray> convertList(TrayList trayList) {

        ArrayList<Tray> traysArrayList = new ArrayList<>();
        int trayID = 0;

        for (int i = 0; i < trayList.getTraysList().size(); i++) {
            trayID = trayList.getTrays(i).getTrayId();
            traysArrayList.add(trayRepository.findById(trayID).get());
        }
        return traysArrayList;
    }

    public ArrayList<Tray> getAllTrays() {
        return (ArrayList<Tray>) trayRepository.findAll();
    }

    public ArrayList<Product> getAllProducts() {
        return  (ArrayList<Product>)productRepository.findAll();
    }


    public List<Part> findPartsOfSickAnimal(int id)
    {
        Animal animal=animalRepository.findById(id).get();

        System.out.println("findPartsOfSickAnimal got the animal with this id"+animal.getAnimal_id());
        System.out.println("findPartsOfSickAnimal got this many parts from the sick animal using the partRepository"+partRepository.findAllByAnimal(animal).size());
        return partRepository.findAllByAnimal(animal);

    }
}
