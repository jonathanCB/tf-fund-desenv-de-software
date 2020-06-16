package com.eventoapp.Interfaces;

import com.eventoapp.Entity.Evento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
        // Buscando a toda lista de eventos com findAll():
        Iterable<Evento> eventos = er.findAll();
        // O mesmo nome que colocamos na view, no index.html, deveremos colocar aqui:
        mv.addObject("eventos", eventos);
        return mv;
    }

    // Este método servirá para receber o código do evento e buscar no banco de
    // dados.
    @RequestMapping("/{codigo}")
    public ModelAndView detalhesEvento(@PathVariable("codigo") long codigo) {
        // Aqui estamos buscando o evento que corresponde ao código e guarda na variável
        // evento.
        Evento evento = er.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("evento/detalhesEvento");
        mv.addObject("evento", evento);
        return mv;
    }
}