package com.viniciusdegelo.chamados_api.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="chamados")
public class Chamado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idChamado;

    private LocalDateTime dataAbertura;
    private LocalDateTime dataSolucao;

    @ManyToOne
    @JoinColumn(name = "id_tipo_chamado")
    private TipoChamado tipoChamado;

    @ManyToOne
    @JoinColumn(name = "id_status")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "id_tecnico")
    private Tecnico tecnico;


    public Chamado(){

    }


    public Integer getIdChamado() {
        return idChamado;
    }


    public void setIdChamado(Integer idChamado) {
        this.idChamado = idChamado;
    }


    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }


    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }


    public LocalDateTime getDataSolucao() {
        return dataSolucao;
    }


    public void setDataSolucao(LocalDateTime dataSolucao) {
        this.dataSolucao = dataSolucao;
    }


    public TipoChamado getTipoChamado() {
        return tipoChamado;
    }


    public void setTipoChamado(TipoChamado tipoChamado) {
        this.tipoChamado = tipoChamado;
    }


    public Status getStatus() {
        return status;
    }


    public void setStatus(Status status) {
        this.status = status;
    }


    public Tecnico getTecnico() {
        return tecnico;
    }


    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    
}
