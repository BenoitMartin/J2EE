package Application;

import Services.UserServices;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		RetailerDAO r1 = new RetailerDAO();
//		System.out.println(r1.getRetailerbyID(1).toString());
//		System.out.println("________________________________________");
//		ProductDAO p1 = new ProductDAO();
//		System.out.println(p1.getProductbyID(1).toString());
//		System.out.println("________________________________________");
//		UserDAO u1 = new UserDAO();
//		System.out.println(u1.getUserbyID(1).toString());
//		System.out.println("________________________________________");
//		OfferDAO o1 = new OfferDAO();
//		System.out.println(o1.getOffersbybarcode(1));
		
		UserServices uS = new UserServices();
		try {
			String s = uS.checkUserPassword("bob", "bob").getLogin();
			System.out.println(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
