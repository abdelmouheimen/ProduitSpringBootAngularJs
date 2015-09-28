package demo.DAO;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import demo.model.Produit;

public interface ProduitDao extends JpaRepository<Produit, Long>{
	@Query("select p from Produit p where p.description like :x")
	public Page<Produit> ProduitByMC(@Param("x") String mc, Pageable p);
}
	