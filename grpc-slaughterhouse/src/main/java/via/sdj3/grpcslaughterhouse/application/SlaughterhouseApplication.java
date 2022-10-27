package via.sdj3.grpcslaughterhouse.application;

import org.springframework.stereotype.Service;
import via.sdj3.grpcslaughterhouse.model.Part;
import via.sdj3.grpcslaughterhouse.model.Product;
import via.sdj3.grpcslaughterhouse.model.Tray;
import org.springframework.beans.factory.annotation.Autowired;
import via.sdj3.grpcslaughterhouse.repository.PartRepository;
import via.sdj3.grpcslaughterhouse.repository.ProductRepository;
import via.sdj3.grpcslaughterhouse.repository.TrayRepository;

import java.util.ArrayList;
import java.util.Collections;

@Service
public class SlaughterhouseApplication
{
    @Autowired
    private PartRepository partRepo;
    @Autowired
    private TrayRepository trayRepo;
    @Autowired
    private ProductRepository productRepo;

    public ArrayList<Integer> getAnimalsInProduct(int productId)
    {
        Iterable<Product> allFoundProducts = productRepo.findAllById(Collections.singleton(productId));

        ArrayList<Integer> allFoundTraysIds = new ArrayList<>();
        allFoundProducts.forEach(product ->
        {
            allFoundTraysIds.add(product.getTrayId());
        });

        //Problems may be here
        Iterable<Tray> allFoundTrays =
                trayRepo.findAllById(allFoundTraysIds);

        ArrayList<Integer> allFoundPartsIds = new ArrayList<>();
        allFoundTrays.forEach(tray ->
        {
            allFoundPartsIds.add(tray.getPartId());
        });

        Iterable<Part> allFoundParts =
                partRepo.findAllById(allFoundPartsIds);

        ArrayList<Integer> animalsIds = new ArrayList<>();
        allFoundParts.forEach(part ->
        {
            animalsIds.add(part.getAnimalId());
        });
        return animalsIds;
    }
    public ArrayList<Product> getProductsWithAnimal(int animalId)
    {
        Iterable<Part> allParts = partRepo.findAll();
        ArrayList<Integer> allFoundPartsIds = new ArrayList<>();
        allParts.forEach(part -> {
            if(animalId==part.getAnimalId()) allFoundPartsIds.add(part.getPartId());
        });
        Iterable<Tray> allFoundTrays = trayRepo.findAllById(allFoundPartsIds);
        ArrayList<Integer> allFoundTraysIds = new ArrayList<>();
        allFoundTrays.forEach(tray ->{
            allFoundTraysIds.add(tray.getTrayId());
        });
        Iterable<Product> allFoundProducts = productRepo.findAllById(allFoundTraysIds);
        //Todo problem might be here, if doesn't work use 'for each' on Iterable.
        return (ArrayList<Product>) allFoundProducts;
    }



}
