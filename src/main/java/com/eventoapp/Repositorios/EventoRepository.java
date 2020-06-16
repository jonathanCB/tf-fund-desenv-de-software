package com.eventoapp.Repositorios;

import com.eventoapp.Entidade.Evento;

import org.springframework.data.repository.CrudRepository;

public interface EventoRepository extends CrudRepository<Evento, String> {
    Evento findByCodigo(long codigo);
}