package com.lgdoiscursomc.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lgdoiscursomc.domain.Categoria;
import com.lgdoiscursomc.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	
	//Uma forma de fazer usando JPQL
	
	/*
	@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias")
	Page<Produto> search(@Param("nome")String nome, @Param("categorias") List<Categoria> categorias, Pageable pageRequest);
	*/
	
	
	//Outra forma de fazer usando padrão de nomes do spring data https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
	
	@Transactional(readOnly=true)
	Page<Produto> findDistinctByNomeContainingAndCategoriasIn(String nome, List<Categoria> categorias, Pageable pageRequest);
}
