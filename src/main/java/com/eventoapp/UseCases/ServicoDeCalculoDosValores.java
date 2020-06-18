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
    public ServicoDeCalculoDosValores(Desconto desconto, ValoresPorDiasDaSemana valoresDiaSemana,
            ValoresPorQtdPessoas valoresQtdPessoas, Evento evento) {
        this.listaEventos = null;
        this.desconto = desconto;
        this.valoresDiaSemana = valoresDiaSemana;
        this.valoresQtdPessoas = valoresQtdPessoas;
        this.evento = evento;
    }

    public Evento getEvento(long codigo) {
        evento = listaEventos.findByCodigo(codigo);
        return evento;
    }

    public double desconto(long codigo) {
        if (evento == null || evento.getCodigo() != codigo) {
            evento = getEvento(codigo);
        }
        return desconto.desconto(evento);
    }

    public double valoresPorDiasDaSemana(long codigo) {
        if (evento == null || evento.getCodigo() != codigo) {
            evento = getEvento(codigo);
        }
        return valoresDiaSemana.valor(evento);
    }

    public double valorPorQtdDePessoas(long codigo) {
        if (evento == null || evento.getCodigo() != codigo) {
            evento = getEvento(codigo);
        }
        return valoresQtdPessoas.valor(evento);
    }
}