package org.sid.bourseservice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Societe implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String nomSociete;


    public Societe() {
    }

    public Societe(String nomSociete) {
        this.nomSociete = nomSociete;
    }

    public Long getId() {
        return id;
    }
    public String getNomSociete() {
        return nomSociete;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNomSociete(String nomSociete) {
        this.nomSociete = nomSociete;
    }
}
