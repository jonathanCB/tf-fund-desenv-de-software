package com.eventoapp.models;

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

    private String nome;
    private String local;
    private String data;
    private String horario;
    private int qtdPessoas;
    private String diaDaSemana;
    // private double custoDoEvento;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
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

    /*public double getCustoDoEvento() {
        return custoDoEvento;
    }

    public void setCustoDoEvento() {
        if (this.qtdPessoas < 50) {
            this.custoDoEvento += 250;
        }
        if (this.qtdPessoas >= 50 && this.qtdPessoas < 150) {
            this.custoDoEvento += 450;
        }
        if (this.qtdPessoas >= 150 && this.qtdPessoas <= 300) {
            this.custoDoEvento += 750;
        }
        if (this.diaDaSemana.equalsIgnoreCase("Segunda") || this.diaDaSemana.equalsIgnoreCase("Quarta")
                || this.diaDaSemana.equalsIgnoreCase("Terça") || this.diaDaSemana.equalsIgnoreCase("Quinta")) {
            this.custoDoEvento += 250;
        }
        if (this.diaDaSemana.equalsIgnoreCase("Sexta") || this.diaDaSemana.equalsIgnoreCase("Sabado")
                || this.diaDaSemana.equalsIgnoreCase("Domingo")) {
            this.custoDoEvento += 600;
        }
    }*/

}