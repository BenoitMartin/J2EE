package Services;

import java.util.ArrayList;

import DAO.RetailerDAO;
import Objects.Retailer;

public class RetailerServices {

	private RetailerDAO rDAO;
	
	public ArrayList<Retailer> getAllRetailer(){
		return rDAO.getRetailerList();
	}
	
	
}
