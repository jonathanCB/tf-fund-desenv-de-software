package com.eventoapp.UseCases;

import com.eventoapp.Entity.Evento;
import com.eventoapp.Interfaces.EventoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoDeCalculoDosValores {
    private EventoRepository listaEventos;
    private Desconto desconto;
    private double valorDesconto;
    private ValoresPorDiasDaSemana valoresDiaSemana;
    private ValoresPorQtdPessoas valoresQtdPessoas;
    private double valorPorDiasDaSemana;
    private double valorPorQtdDePessoas;
    private Evento evento;

    @Autowired
    public ServicoDeCalculoDosValores(EventoRepository listaEventos, Desconto desconto,
            ValoresPorDiasDaSemana valoresDiaSemana, ValoresPorQtdPessoas valoresQtdPessoas) {
        this.listaEventos = listaEventos;
        this.desconto = desconto;
        this.valoresDiaSemana = valoresDiaSemana;
        this.valoresQtdPessoas = valoresQtdPessoas;
        this.evento = null;
        this.valorPorDiasDaSemana = 0;
        this.valorPorQtdDePessoas = 0;
        this.valorDesconto = 0;
    }

    public Evento getEvento(long codigo) {
        Evento newEvento = listaEventos.findByCodigo(codigo);
        if (newEvento == null) {
            throw new IllegalArgumentException("Evento nao encontrado.");
        } else {
            this.evento = newEvento;
            return evento;
        }
    }

    public double desconto(long codigo) {
        if (this.evento == null || this.evento.getCodigo() != codigo) {
            this.evento = getEvento(codigo);
            this.valorDesconto = desconto.desconto(this.evento);
        }
        return this.valorDesconto;
    }

    public double valoresPorDiasDaSemana(long codigo) {
        if (this.evento == null || this.evento.getCodigo() != codigo) {
            this.evento = getEvento(codigo);
            this.valorPorQtdDePessoas = this.valoresDiaSemana.valor(evento);
        }
        return this.valorPorQtdDePessoas;
    }

    public double valorPorQtdDePessoas(long codigo) {
        if (this.evento == null || this.evento.getCodigo() != codigo) {
            this.evento = getEvento(codigo);
            this.valorPorQtdDePessoas = this.valoresQtdPessoas.valor(evento);
        }
        return this.valorPorQtdDePessoas;
    }

    public double getValorTotalEvento() {
        double valorTotalDoEvento = 0;
        if (this.valorPorDiasDaSemana > 0 && this.valorPorQtdDePessoas > 0) {
            valorTotalDoEvento = (this.valorPorDiasDaSemana + this.valorPorQtdDePessoas - this.valorDesconto);
        } else {
            return 0;
        }
        return valorTotalDoEvento;
    }
}