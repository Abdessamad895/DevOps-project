package edu.cours.springboot.coursspringboot.module;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CoursModel {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    private String nom;
    private String description;
    
    
    public CoursModel() {}
    
    public CoursModel(int id, String nom, String description) {this.id = id;this.nom = nom;this.description = description;}

    public int getId(){return this.id;}

    public void setId(int id){this.id = id;}

    public String getNom(){return this.nom;}

    public void setNom(String nom){ this.nom = nom;}

    public String getDescription(){return this.description;}

    public void setDescription(String description){this.description = description;}

}
