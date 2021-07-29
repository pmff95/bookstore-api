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

	public void instanciaBasedeDados() {
		Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Ficcção Científica", "Ficcção científica");
		Categoria cat3 = new Categoria(null, "Biografias", "Livros de Biografias");
				
		Livro l1 = new Livro(null, "Clean code", "Robert Martin", "Lorem ipsum", cat1);
		Livro l2 = new Livro(null, "Engenharia de Software", "Louis V. Gerstner", "Lorem ipsum", cat1);
		Livro l3 = new Livro(null, "The Time Machine", "H.G. Wells", "Lorem ipsum", cat2);
		Livro l4 = new Livro(null, "The War of the Worlds", "H.G. Wells", "Lorem ipsum", cat2);
		Livro l5 = new Livro(null, "I, Robot", "Isaac Asimov", "Lorem ipsum", cat2);
				
		cat1.getLivros().addAll(Arrays.asList(l1, l2));
		cat2.getLivros().addAll(Arrays.asList(l3, l4, l5));
				
		this.categoriarepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livrorepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
	}

}
