package com.eventoapp.Interfaces;

import com.eventoapp.Entity.Evento;
import org.springframework.data.repository.CrudRepository;

public interface EventoRepository extends CrudRepository<Evento, String> {
    Evento findByCodigo(int codigo);

    // TO-DO versão 2.0
    // Evento findAll();
}
