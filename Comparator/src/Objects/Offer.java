package Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="Offer")
@Table(name="Link")


public class Offer {

	@Column(name="idRetailer",
            table="Link")
	@Id
	@ManyToOne()
	private Retailer retailer;

	@Column(name="price",
            table="Link")
	private float price;
	
	@Column(name="Product",
            table="Link")
	@ManyToOne
	private Product produit;
	
	public Offer(Retailer i, float p){
		this.retailer=i;
		this.price=p;
	}

	
	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	
	public String toString(){
		return "idRetailer : "+this.retailer+"\n price : "+this.price;
	}


	/**
	 * @return the retailer
	 */
	public Retailer getRetailer() {
		return retailer;
	}


	/**
	 * @param retailer the retailer to set
	 */
	public void setRetailer(Retailer retailer) {
		this.retailer = retailer;
	}


	/**
	 * @return the produit
	 */
	public Product getProduit() {
		return produit;
	}


	/**
	 * @param produit the produit to set
	 */
	public void setProduit(Product produit) {
		this.produit = produit;
	}
	
}
