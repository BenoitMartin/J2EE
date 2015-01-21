package Objects;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="Product")
@Table(name="Product")

public class Product {

	@Column(name="barcode",
            table="Product")
	@Id
	private int barcode;
	
	@Column(name="name",
            table="Product")
	
	private String name;
	
	@JoinColumn(name="idRetailer",
            table="Link")
	@OneToMany()
	private ArrayList<Offer> listOffers;

	public Product(int i, String c, ArrayList<Offer> a) {
		this.barcode = i;
		this.name = c;
		this.listOffers = new ArrayList<Offer>();
		this.listOffers = a;

	}
	
	public Product(int i, String c) {
		this.barcode = i;
		this.name = c;
		this.listOffers = new ArrayList<Offer>();

	}

	/**
	 * @return the barcode
	 */
	public int getBarcode() {
		return barcode;
	}

	/**
	 * @param barcode
	 *            the barcode to set
	 */
	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the listOffers
	 */
	public ArrayList<Offer> getListOffers() {
		return listOffers;
	}

	/**
	 * @param listOffers the listOffers to set
	 */
	public void setListOffers(ArrayList<Offer> listOffers) {
		this.listOffers = listOffers;
	}

	public void addOffers(Offer o){
		this.listOffers.add(o);
	}
	
	public String toString(){
		return "Barcode : "+this.getBarcode()+"\n Name : "+this.getName();
	}
	
}
