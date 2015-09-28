package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.DAO.ProduitDao;
import demo.model.Produit;

@RestController
public class ProduitController {
	
	@Autowired
	private ProduitDao 	Produitdao;
	
	@RequestMapping("/test")
	public String test(){
		
		return "test";
	}
	
	@RequestMapping("/save")
	public Produit saveProduit(Produit p){
		
		Produitdao.save(p);
		return p;
	}
	
	@RequestMapping("/all")
	public List<Produit> getAll(){
		return Produitdao.findAll();
	}
	
	
	@RequestMapping("/produits")
	public Page<Produit> getAll(int page){
		return Produitdao.findAll(new PageRequest(page, 5));
	}
	
@RequestMapping("/produitparmc")
	public Page<Produit> getProduitParMC(String mc,int page){
		return Produitdao.ProduitByMC("%"+mc+"%", new PageRequest(page, 5));
	}
	@RequestMapping("/updateproduit")
	public Produit updateProduit(Produit p){
		Produitdao.saveAndFlush(p);
		return p;
		
	}
	
}
