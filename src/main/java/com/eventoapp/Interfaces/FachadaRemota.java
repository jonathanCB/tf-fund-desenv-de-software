package com.eventoapp.Interfaces;

import com.eventoapp.Entity.Evento;
import com.eventoapp.UseCases.ServicoDeCalculoDosValores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/detalhesevento")
public class FachadaRemota {
    private ServicoDeCalculoDosValores sCalculaValores;

    @Autowired
    public FachadaRemota(ServicoDeCalculoDosValores sCalculaValores) {
        this.sCalculaValores = sCalculaValores;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/persiste")
    public Evento saveEvento(@RequestParam String nomeEvento, @RequestParam int qtdPessoas,
            @RequestParam String diaSemana, @RequestParam String descPromocional) {
        return sCalculaValores.saveEvento(new Evento(nomeEvento, qtdPessoas, diaSemana, descPromocional));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/dadosevento")
    public Evento getDadosEvento(@RequestParam int codigo) {
        return sCalculaValores.getEvento(codigo);
    }

    // TO-DO versão 2.0
    // @CrossOrigin(origins = "*")
    // @GetMapping("/dadoseventoall")
    // public List<Evento> getDadosEvento() {
    // return sCalculaValores.getEvento();
    // }

    @CrossOrigin(origins = "*")
    @GetMapping("/desconto")
    public double getValorDesconto(@RequestParam int codigo) {
        return sCalculaValores.getDesconto(codigo);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/valorpordiadasemana")
    public double getValorPorDiaDaSemana(@RequestParam int codigo) {
        return sCalculaValores.getValoresPorDiasDaSemana(codigo);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/valorporqtddepessoas")
    public double getValorPorQtdDePessoas(@RequestParam int codigo) {
        return sCalculaValores.getValorPorQtdDePessoas(codigo);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/valortotaldoevento")
    public double getValorTotalDoEvento(@RequestParam int codigo) {
        return sCalculaValores.getValorTotalEvento();
    }
}