package org.sid.entities;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BOOK")
public class Produit_Book {
	/**
	 * 
	 */
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="nom")
	private String nom;
	@Column(name="author")
	private String author;
	@Column(name="quantity")
    private int quantity;
	@Column(name="release_date")
    private Date release_date;
	@Column(name="unitprice")
	private double unitprice;
	
	//get Id
	public Long getId() {
		return id;
	}
	//set Id
	public void setId(Long id) {
		this.id = id;
	}
	//get Quantity
	public int getQuantity() {
		return quantity;
	}
	//set Quantity
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	//get unitprice
	public double getUnitprice() {
		return unitprice;
	}
	//constructor with parameters
	public Produit_Book(Long id,String nom,String author,Date release_date,int quantity, double unitprice) {
		super();
		
		this.id = id;
		this.author=author;
		this.nom=nom;
		this.release_date=release_date;
		this.quantity = quantity;
		this.unitprice = unitprice;
	}
	//set unitprice
	public void setUnitprice(double unitprice) {
		this.unitprice = unitprice;
	}
	//constructor without parameters
	
	public Produit_Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	//get Author
	public String getAuthor() {
		return author;
	}
	//set author
	public void setAuthor(String author) {
		this.author = author;
	}
	//get nom
	public String getNom() {
		return nom;
	}
	//set nom
	public void setNom(String nom) {
		this.nom = nom;
	}
	//get release_date
	public Date getRelease_date() {
		return release_date;
	}
	//set release_date
	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}
	
	
	
	

}
