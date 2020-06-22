package com.eventoapp.UseCases;

import com.eventoapp.Entity.Evento;
import com.eventoapp.Interfaces.EventoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoDeCalculoDosValores {
    private EventoRepository listaEventos;
    private Desconto desconto;
    private ValoresPorDiasDaSemana valoresDiaSemana;
    private ValoresPorQtdPessoas valoresQtdPessoas;
    private Evento evento;

    @Autowired
    public ServicoDeCalculoDosValores(EventoRepository listaEventos, Desconto desconto,
            ValoresPorDiasDaSemana valoresDiaSemana, ValoresPorQtdPessoas valoresQtdPessoas) {
        this.listaEventos = listaEventos;
        this.desconto = desconto;
        this.valoresDiaSemana = valoresDiaSemana;
        this.valoresQtdPessoas = valoresQtdPessoas;
        this.evento = null;
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

    public double getDesconto(long codigo) {
        if (this.evento == null || this.evento.getCodigo() != codigo) {
            this.evento = getEvento(codigo);
        }
        return this.desconto.desconto(this.evento);
    }

    public double getValoresPorDiasDaSemana(long codigo) {
        if (this.evento == null || this.evento.getCodigo() != codigo) {
            this.evento = getEvento(codigo);
        }
        return this.valoresDiaSemana.valor(evento);
    }

    public double getValorPorQtdDePessoas(long codigo) {
        if (this.evento == null || this.evento.getCodigo() != codigo) {
            this.evento = getEvento(codigo);
        }
        return this.valoresQtdPessoas.valor(evento);
    }

    public double getValorTotalEvento() {
        double valorTotalDoEvento = 0;
        if (this.valoresDiaSemana.valor(evento) > 0 && this.valoresQtdPessoas.valor(evento) > 0) {
            valorTotalDoEvento = (this.valoresDiaSemana.valor(this.evento) + this.valoresQtdPessoas.valor(this.evento)
                    - this.desconto.desconto(evento));
        } else {
            return 0;
        }
        return valorTotalDoEvento;
    }
}