package com.eventoapp.UseCases;

import com.eventoapp.Entity.Evento;

import org.springframework.stereotype.Component;

@Component
// Implementando a classe de ValoresQtdPessoas usando Strategy
public class ValoresPorQtdPessoas implements Valores {
    private final double POUCAS_PESSOAS = 350.00;
    private final double MEDIO_NPESSOAS = 550.00;
    private final double MUITAS_PESSOAS = 800.00;

    @Override
    public double valor(Evento evento) {
        if (evento.getQtdPessoas() < 50) {
            return POUCAS_PESSOAS;
        }
        if (evento.getQtdPessoas() >= 50 && evento.getQtdPessoas() < 300) {
            return MEDIO_NPESSOAS;
        }
        if (evento.getQtdPessoas() >= 150 && evento.getQtdPessoas() <= 600) {
            return MUITAS_PESSOAS;
        } else {
            return 0;
        }
    }
}