package demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Produit implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long reference;
	private String nom;
	private String description;
	private long   prix;
	
	public Long getReference() {
		return reference;
	}
	public void setReference(Long reference) {
		this.reference = reference;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public long getPrix() {
		return prix;
	}
	public void setPrix(long prix) {
		this.prix = prix;
	}
	public Produit(String nom, String description,long prix) {
		super();
		this.nom = nom;
		this.description = description;
		this.prix=prix;
	}
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
