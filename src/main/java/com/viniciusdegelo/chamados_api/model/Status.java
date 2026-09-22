package com.viniciusdegelo.chamados_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "status")
public class Status {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idStatus;

    private String descricaoStatus;

    public Status(){

    }


    public Integer getIdStatus(){
        return idStatus;
    }

    public void setIdStatus(Integer idStatus){
        this.idStatus = idStatus;
    }

    public String getDescricaoStatus(){
        return descricaoStatus;
    }

    public void setDescricaoStatus(String descricaoStatus){
        this.descricaoStatus = descricaoStatus;
    }
}
