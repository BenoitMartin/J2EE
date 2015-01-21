package Services;

import java.util.ArrayList;

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
	
	
	public Product getProductbyID(int i){
		ProductDAO u = new ProductDAO();
		
		return u.getProductbyID(i);
		
	}
}
