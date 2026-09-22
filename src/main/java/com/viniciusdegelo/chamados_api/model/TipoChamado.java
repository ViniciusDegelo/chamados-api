package com.viniciusdegelo.chamados_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tipo_chamado")
public class TipoChamado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoChamado;

    private String descricaoTipo;

    public TipoChamado(){

    }

    public Integer getIdTipoChamado() {
        return idTipoChamado;
    }

    public void setIdTipoChamado(Integer idTipoChamado) {
        this.idTipoChamado = idTipoChamado;
    }

    public String getDescricaoTipo() {
        return descricaoTipo;
    }

    public void setDescricaoTipo(String descricaoTipo) {
        this.descricaoTipo = descricaoTipo;
    }

    
}
