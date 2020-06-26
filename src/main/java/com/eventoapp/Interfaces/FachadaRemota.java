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

    @CrossOrigin(origins = "*") // "http://localhost")
    @GetMapping("/persiste")
    public void saveEvento(@RequestParam String nomeEvento, @RequestParam int qtdPessoas,
            @RequestParam String diaSemana, @RequestParam String descPromocional) {
        Evento evento = new Evento(nomeEvento, qtdPessoas, diaSemana, descPromocional);
        sCalculaValores.saveEvento(evento);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/dadosevento")
    public Evento getDadosEvento(@RequestParam int codigo) {
        Evento evento = sCalculaValores.getEvento(codigo);
        return evento;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/desconto")
    public double getValorDesconto(@RequestParam long codigo) {
        double desconto = sCalculaValores.getDesconto(codigo);
        return desconto;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/valorpordiadasemana")
    public double getValorPorDiaDaSemana(@RequestParam long codigo) {
        double valorPorDiaDaSemana = sCalculaValores.getValoresPorDiasDaSemana(codigo);
        return valorPorDiaDaSemana;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/valorporqtddepessoas")
    public double getValorPorQtdDePessoas(@RequestParam long codigo) {
        double valorPorQtdDePessoas = sCalculaValores.getValorPorQtdDePessoas(codigo);
        return valorPorQtdDePessoas;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/valortotaldoevento")
    public double getValorTotalDoEvento(@RequestParam long codigo) {
        double valorTotalDoEvento = sCalculaValores.getValorTotalEvento();
        return valorTotalDoEvento;
    }
}