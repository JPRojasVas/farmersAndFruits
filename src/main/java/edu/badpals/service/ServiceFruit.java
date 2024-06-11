package edu.badpals.service;



import edu.badpals.domain.Farmer;
import edu.badpals.domain.Fruit;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ServiceFruit {

    public List<Fruit> list(){

        List<Fruit> fruitList = Fruit.listAll();
        return fruitList;
    }

    public void add(Fruit fruit){

        Optional<Farmer> farmer = Farmer.find("name = ?1", fruit.getFarmer().getName()).firstResultOptional();

        Fruit fruta = new Fruit(fruit.getName(), fruit.getDescription(), farmer.get());

        fruta.persist();

    }


}
