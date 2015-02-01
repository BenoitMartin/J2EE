package Services;

import java.util.ArrayList;

import DAO.OfferDAO;
import DAO.RetailerDAO;
import Objects.Retailer;

public class RetailerServices {

	private RetailerDAO rDAO;
	
	public ArrayList<Retailer> getAllRetailer(){
		rDAO = new RetailerDAO();
		return rDAO.getRetailerList();
	}
	
	
	public void DeleteRetailer(int tab[]){
		RetailerDAO p = new RetailerDAO();
		OfferDAO o = new OfferDAO();
		
		for (int i : tab){
			o.DeleteOfferByRetailerID(i);
			
		
		}
		for (int id : tab){
			p.DeleteRetailer(id);
			
		
		}
		
	}
	
	public void AddRetailer(int id, String nameR, float rDistance){
		RetailerDAO p = new RetailerDAO();
		p.AddRetailer(id, nameR, rDistance);
		
	}
	
}
