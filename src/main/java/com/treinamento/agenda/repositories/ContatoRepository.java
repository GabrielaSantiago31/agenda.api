package com.treinamento.agenda.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.treinamento.agenda.entities.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long>{

	List<Contato> getContatoByTipo(String tipo);

}
