package com.eventoapp.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Evento implements Serializable {

    // Necessário para a classe Serializable funcionar:
    private static final long serialVersionUID = 1L;

    // Definindo id para o banco de dados com "@Id":
    @Id
    // Gerando o id automaticamente com "@GeneratedValue":
    // OBS: Para funcionar tempos que implementar a classe "Serializable" ↑.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codigo;

    private String nomeEvento;
    private int qtdPessoas;
    private String diaDaSemana;
    private String descontoPromocional;
    private double desconto;
    private String valoresPorDiaDaSemana;
    private int valoresPorQtdDePessoas;
    private double custoDoEvento;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public int getQtdPessoas() {
        return qtdPessoas;
    }

    public void setQtdPessoas(int qtdPessoas) {
        this.qtdPessoas = qtdPessoas;
    }

    public String getDiaDaSemana() {
        return diaDaSemana;
    }

    public void setDiaDaSemana(String diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public String getDescontoPromocional() {
        return descontoPromocional;
    }

    public void setDescontoPromocional(String descontoPromocional) {
        this.descontoPromocional = descontoPromocional;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public String getValoresPorDiaDaSemana() {
        return valoresPorDiaDaSemana;
    }

    public void setValoresPorDiaDaSemana(String valoresPorDiaDaSemana) {
        this.valoresPorDiaDaSemana = valoresPorDiaDaSemana;
    }

    public int getValoresPorQtdDePessoas() {
        return valoresPorQtdDePessoas;
    }

    public void setValoresPorQtdDePessoas(int valoresPorQtdDePessoas) {
        this.valoresPorQtdDePessoas = valoresPorQtdDePessoas;
    }

    public double getCustoDoEvento() {
        return custoDoEvento;
    }

    public void setCustoDoEvento(double custoDoEvento) {
        this.custoDoEvento = custoDoEvento;
    }

}