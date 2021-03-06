package com.dobre.models;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface PropriedadeRepository extends PagingAndSortingRepository<Propriedade, String> {

	@Query("SELECT c FROM Propriedade c WHERE c.nome LIKE %:filtro% ORDER BY categoria,subcategoria,nome")
	public List<Propriedade> findByFiltro(@Param("filtro") String filtro);	
	
}
