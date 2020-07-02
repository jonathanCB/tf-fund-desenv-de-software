package com.eventoapp.eventoapp;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.eventoapp.Entity.Evento;
import com.eventoapp.Interfaces.EventoRepository;
import com.eventoapp.UseCases.Desconto;
import com.eventoapp.UseCases.ValoresPorDiasDaSemanaImplements;
import com.eventoapp.UseCases.ValoresPorQtdPessoasImplements;


public class ServicoDeCalculoDosValoresTest {
	
    @Autowired
	private EventoRepository listaEventos;
    
    @Autowired
    private Desconto desconto;
    
    @Autowired
    private ValoresPorDiasDaSemanaImplements valoresDiaSemana;
    
    @Autowired
    private ValoresPorQtdPessoasImplements valoresQtdPessoas;
    
    @Autowired
    private Evento evento;
    
    private String nomeEvento = "Teste";
    private String descontoPromocional = "nao";
    private String diaDaSemana = "Segunda";
    private int qtdPessoas = 0;
    
    @Before
    public void setup() {
    	evento.setNomeEvento(nomeEvento);
    	evento.setDescontoPromocional(descontoPromocional);
    	evento.setDiaDaSemana(diaDaSemana);
    	evento.setQtdPessoas(qtdPessoas);    	
    }
    
    @Test
    public void testeSeSalvaEvento() {
    	listaEventos.save(evento);
    	
    	assertEquals(nomeEvento, evento.getNomeEvento());
    	assertEquals(descontoPromocional, evento.getDescontoPromocional());
    	assertEquals(diaDaSemana, evento.getDiaDaSemana());
    	assertEquals(qtdPessoas, evento.getQtdPessoas());
    }
}
