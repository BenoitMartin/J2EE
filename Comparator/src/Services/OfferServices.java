package Services;

import java.util.ArrayList;

import DAO.OfferDAO;
import Objects.Offer;
import Objects.Retailer;

public class OfferServices {

	private OfferDAO oDAO;

	public ArrayList<Retailer> getListRetailer(int idProduct) {
		ArrayList<Offer> offerList = oDAO.getOffersbybarcode(idProduct);
		ArrayList<Retailer> retailerList = new ArrayList<Retailer>();

		for (Offer o : offerList) {
			retailerList.add(o.getRetailer());
		}

		return retailerList;
	}

}
