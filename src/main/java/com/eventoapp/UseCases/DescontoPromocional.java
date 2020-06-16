package com.eventoapp.UseCases;

import com.eventoapp.Entity.Evento;

import org.springframework.stereotype.Component;

@Component
// Implementando a classe de Desconto usando Strategy
public class DescontoPromocional implements Desconto {
    public static final double TX_DESCONTO = 0.10;

    @Override
    public double desconto(Evento evento) {
        if (evento.getDescontoPromocional().equalsIgnoreCase("sim")) {
            return evento.getCustoDoEvento() * TX_DESCONTO;
        } else {
            return 0;
        }
    }
}