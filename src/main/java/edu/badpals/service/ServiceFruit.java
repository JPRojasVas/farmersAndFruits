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

        if (farmer.isPresent()){
            Fruit fruta = new Fruit(fruit.getName(), fruit.getDescription(), farmer.get());

            fruta.persist();

        } else {
            Farmer newFarmer = new Farmer(fruit.getFarmer().getName(), fruit.getFarmer().getLocation());
            newFarmer.persist();

            Fruit fruta = new Fruit(fruit.getName(), fruit.getDescription(), newFarmer);

            fruta.persist();
        }

    }

    public void remove(String nombre){

        Optional<Fruit> fruta = Fruit.find("name = ?1", nombre).firstResultOptional();

        if (fruta.isPresent()){

            Fruit.delete("name = ?1", nombre);

        }

    }

    public Optional<Fruit> getFruit(String name){

        Optional<Fruit> fruta = Fruit.find("name = ?1", name).firstResultOptional();

        if (fruta.isPresent()){

            return fruta;

        }

        return Optional.empty();

    }

}
