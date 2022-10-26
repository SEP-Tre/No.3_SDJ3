package application;

import model.Part;
import model.Product;
import model.Tray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PartRepository;
import repository.ProductRepository;
import repository.TrayRepository;

import java.util.ArrayList;
import java.util.Collections;

public class SlaughterhouseApplication
{
    @Autowired
    private PartRepository partRepo;
    @Autowired
    private TrayRepository trayRepo;
    @Autowired
    private ProductRepository productRepo;

    private ArrayList<Integer> getAnimalsInProduct(int productId)
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
    private ArrayList<Product> getProductsWithAnimal(int animalId)
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
