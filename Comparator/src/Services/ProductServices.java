package Services;

import java.util.ArrayList;

import DAO.OfferDAO;
import DAO.ProductDAO;
import Objects.Offer;
import Objects.Product;
import Objects.Retailer;

public class ProductServices {

	private ProductDAO pDAO;

	public ArrayList<Retailer> getListRetailer(int barcode) {
		Product p = pDAO.getProductbyID(barcode);

		ArrayList<Offer> offerList = p.getListOffers();
		ArrayList<Retailer> retailerList = new ArrayList<Retailer>();

		for (Offer o : offerList) {
			retailerList.add(o.getRetailer());
		}

		return retailerList;

	}
	
	public ArrayList<Offer> getListOffer(int barcode) {
		Product p = pDAO.getProductbyID(barcode);

		ArrayList<Offer> offerList = p.getListOffers();

		return offerList;

	}
	
	public ArrayList<Product> getAllProduct(){
		ProductDAO u = new ProductDAO();
		
		return u.getAllProducts();
		
	}
	
	
	public Product getProductbyID(int i){
		ProductDAO u = new ProductDAO();
		
		return u.getProductbyID(i);
		
	}
	
	public void DeleteProducts(int tab[]){
		ProductDAO p = new ProductDAO();
		OfferDAO o = new OfferDAO();
		
		for (int i : tab){
			o.DeleteOfferByBarcode(i);
			
		
		}
		for (int i : tab){
			p.DeleteProduct(i);
			
		
		}
		
	}
	
	public void DeleteProduct(int id){
		ProductDAO p = new ProductDAO();
		OfferDAO o = new OfferDAO();
		
		o.DeleteOfferByBarcode(id);
			p.DeleteProduct(id);
		
		
	}
}
