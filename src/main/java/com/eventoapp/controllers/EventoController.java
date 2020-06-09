package com.eventoapp.controllers;

import com.eventoapp.models.Evento;
import com.eventoapp.repository.EventoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventoController {

    /*
     * Toda vez que a gente precisar utilizar a interface EventoRepository, será
     * criado uma nova instância automaticamente.
     */
    @Autowired
    private EventoRepository er;

    // Retornando requisição da camada de apresentação
    @RequestMapping(value = "/cadastrarEvento", method = RequestMethod.GET)
    public String form() {
        return "evento/formEvento";
    }

    @RequestMapping(value = "/cadastrarEvento", method = RequestMethod.POST)
    public String form(Evento evento) {
        // Persistindo dados no banco de dados:
        er.save(evento);
        return "redirect:/cadastrarEvento";
    }

    // Método para retornar a lista de eventos.
    @RequestMapping("/eventos")
    public ModelAndView listaEventos() {
        // Criando a view para a lista de eventos:
        ModelAndView mv = new ModelAndView("index");
        // Buscando a lista de eventos:
        Iterable<Evento> eventos = er.findAll();
        // O mesmo nome que colocamos na view, no index.html, deveremos colocar aqui:
        mv.addObject("eventos", eventos);
        return mv;
    }
}