package com.eventoapp.UseCases;

import com.eventoapp.Entity.Evento;
import com.eventoapp.Interfaces.EventoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoDeCalculoDosValores {
    private EventoRepository listaEventos;
    private Desconto desconto;
    private ValoresPorDiasDaSemanaImplements valoresDiaSemana;
    private ValoresPorQtdPessoasImplements valoresQtdPessoas;
    private Evento evento;

    @Autowired
    public ServicoDeCalculoDosValores(EventoRepository listaEventos, Desconto desconto,
            ValoresPorDiasDaSemanaImplements valoresDiaSemana, ValoresPorQtdPessoasImplements valoresQtdPessoas) {
        this.listaEventos = listaEventos;
        this.desconto = desconto;
        this.valoresDiaSemana = valoresDiaSemana;
        this.valoresQtdPessoas = valoresQtdPessoas;
        this.evento = null;
    }

    public void saveEvento(Evento evento) {
        // Salvando o evento no banco de dados:
        listaEventos.save(evento);

        /*
         * Setando o valor do evento de acordo com o dia da semana escolhido: OBS: para
         * fazermos isso, estamos chamando o método setValoresPorDiasDaSemana() passando
         * outro método, o getValoresPorDiasDaSemana() passando o código do evento para
         * chamar OUTRO método, o método valor(), agora da classe
         * ValoresPorDiasDaSemana.
         */
        evento.setValoresPorDiaDaSemana(getValoresPorDiasDaSemana(evento.getCodigo()));

        /*
         * Setando o valor do evento de acordo com a quantidade de pessoas: OBS: para
         * fazermos isso, estamos chamando o método setValoresPorQtdDePessoas() passando
         * outro método, o getValorPorQtdDePessoas() passando o código do evento para
         * chamar OUTRO método, o método valor(), agora da classe ValoresPorQtdPessoas.
         */
        evento.setValoresPorQtdDePessoas(getValorPorQtdDePessoas(evento.getCodigo()));

        /*
         * Setando o custo total do evento (sem aplicar o desconto): OBS: para fazermos
         * isso, estamos chamando o método getValorTotalEvento().
         */
        evento.setCustoDoEvento(getValorTotalEvento());

        /*
         * Setando o valor do desconto (se houver). OBS: para fazermos isso, estamos
         * chamando o método setDesconto() passando o método getDesconto() e passando o
         * código do evento.
         */
        evento.setDesconto(getDesconto(evento.getCodigo()));

        /*
         * Aqui estamos atualizando o custo total do evento com o desconto já aplicado.
         */
        evento.setCustoDoEvento(getValorTotalEvento());

        /*
         * Por fim, estamos atualizando todos os custos do evento com os descontos já
         * aplicados.
         */
        listaEventos.save(evento);
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