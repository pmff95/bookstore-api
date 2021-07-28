package com.teste.springCurso;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.teste.springCurso.domain.Categoria;
import com.teste.springCurso.domain.Livro;
import com.teste.springCurso.repository.CategoriaRepository;
import com.teste.springCurso.repository.LivroRepository;

@SpringBootApplication
public class SpringCursoApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriarepository;
	
	@Autowired
	private LivroRepository livrorepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCursoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria c1 = new Categoria(null, "infomatica", "livro de TI");
		
		Livro l1 = new Livro(null, "Clean Code", "Jose", "LoremIpsum", c1);
		c1.getLivros().addAll(Arrays.asList(l1));
		
		this.categoriarepository.saveAll(Arrays.asList(c1));
		this.livrorepository.saveAll(Arrays.asList(l1));
	}
}
