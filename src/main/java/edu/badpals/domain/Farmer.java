package edu.badpals.domain;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "farmer")
public class Farmer extends PanacheEntity {

    @Column(name ="name")
    private String name;

    @Column(name ="location")
    private String location;

    public Farmer(){

    }

    public Farmer(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Farmer{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
