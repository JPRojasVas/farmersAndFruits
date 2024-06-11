package edu.badpals.domain;



import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Entity
@Table(name = "fruit")
public class Fruit extends PanacheEntity {

    @Column( name= "name")
    private String name;

    @Column( name = "description")
    private String description;

    @ManyToOne
    @JoinColumn( name = "farmer_id")
    private Farmer farmer;

    public Fruit(){

    }

    public Fruit(String name, String description, Farmer farmer) {
        this.name = name;
        this.description = description;
        this.farmer = farmer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Farmer getFarmer() {
        return farmer;
    }

    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", farmer=" + farmer +
                '}';
    }
}
