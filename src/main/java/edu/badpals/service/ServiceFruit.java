package edu.badpals.service;



import edu.badpals.domain.Fruit;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ServiceFruit {

    public List<Fruit> list(){

        List<Fruit> fruitList = Fruit.listAll();
        return fruitList;
    }

}
