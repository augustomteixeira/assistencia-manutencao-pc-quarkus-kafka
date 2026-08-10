package org.marceloteixeira.entity;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Cliente extends PanacheEntity {

    public String nome;
    public String email;
    public String telefone;

}
