package com.teste.springCurso.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.springCurso.domain.Categoria;
import com.teste.springCurso.domain.Livro;
import com.teste.springCurso.repository.CategoriaRepository;
import com.teste.springCurso.repository.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriarepository;

	@Autowired
	private LivroRepository livrorepository;

	public void instanciaBase() {
		
		Categoria c1 = new Categoria(null, "INF", "LIVRO DE INFORMATICA");
		Categoria c2 = new Categoria(null, "QUI", "LIVRO DE QUIMICA");
		Categoria c3 = new Categoria(null, "BIO", "LIVRO DE BIOLOGIA");

		Livro l1 = new Livro(null, "Clean Code", "JOSE", "LoremIpsum", c1);
		Livro l2 = new Livro(null, "ABC", "FRANCISCO", "BLoremIpsum", c1);
		Livro l3 = new Livro(null, "SITIO DO PICA PAU", "ZÉ", "ALoremIpsum", c2);
		Livro l4 = new Livro(null, "BIBLIA", "ANA", "ASDASDASD", c2);
		Livro l5 = new Livro(null, "HISTORIA", "MARIA", "KDASKASD", c2);

		c1.getLivros().addAll(Arrays.asList(l1, l2));
		c2.getLivros().addAll(Arrays.asList(l3, l4, l5));

		categoriarepository.saveAll(Arrays.asList(c1, c2, c3));
		livrorepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
	}

}
