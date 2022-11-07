package fr.em.sdbm_web.metier;

import java.io.Serializable;
import java.math.BigDecimal;

public class Article implements Serializable {

	private Integer id;
	private String libelle;
	private Integer volume;
	private Double titrage;
	private BigDecimal prixAchat;
	private Marque marque;
	private Couleur couleur;
	private TypeBiere typeBiere;
	private int stock;

	public Article()
	{
		couleur = new Couleur();
		typeBiere = new TypeBiere();
		marque = new Marque();
	}

	public Article(int id, String libelle)
	{
		this.id = id;
		this.libelle = libelle;
		this.volume = volume;
		this.titrage = titrage;
		this.prixAchat = prixAchat;
		couleur = new Couleur();
		typeBiere = new TypeBiere();
		marque = new Marque();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Integer getVolume()
	{
		return volume;
	}

	public void setVolume(Integer volume)
	{
		this.volume = volume;
	}

	public Double getTitrage()
	{
		return titrage;
	}

	public void setTitrage(Double titrage)
	{
		this.titrage = titrage;
	}

	public Couleur getCouleur()
	{
		return couleur;
	}

	public void setCouleur(Couleur couleur)
	{
		this.couleur = couleur;
	}

	public Marque getMarque()
	{
		return marque;
	}

	public void setMarque(Marque marque)
	{
		this.marque = marque;
	}

	public TypeBiere getTypeBiere()
	{
		return typeBiere;
	}

	public void setTypeBiere(TypeBiere typeBiere)
	{
		this.typeBiere = typeBiere;
	}

	public BigDecimal getPrixAchat()
	{
		return prixAchat;
	}

	public void setPrixAchat(BigDecimal prixAchat)
	{
		this.prixAchat = prixAchat;
	}

	public int getStock() { return stock;}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void setAll(String libelle, BigDecimal prixDAchat, int volume, double titrage,
					   Marque marque, Couleur couleur, TypeBiere typeBiere, int stock) {
		setLibelle(libelle);
		setPrixAchat(prixDAchat);
		setVolume(volume);
		setTitrage(titrage);
		setMarque(marque);
		setCouleur(couleur);
		setTypeBiere(typeBiere);
		setStock(stock);
	}
}


