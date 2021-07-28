package com.teste.springCurso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teste.springCurso.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>{

}
