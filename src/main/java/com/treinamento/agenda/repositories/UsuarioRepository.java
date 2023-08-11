package com.treinamento.agenda.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.treinamento.agenda.entities.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	List<Usuario> findAllByEmail(String email);
}
