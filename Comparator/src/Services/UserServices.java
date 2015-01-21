package Services;

import DAO.UserDAO;
import Objects.User;


public class UserServices {

	private UserDAO uDAO;
	
	 public User checkUserPassword(String login, String password) throws Exception{
		 uDAO = new UserDAO();
         User u = uDAO.getUserbyName(login);
         // Si le login correspond à un User, on vérifie le mot de passe associé
         if (u != null)
               if (u.getPassword().equals(password))
                     return u;
               else
                     throw new Exception("Mot de passe erroné");
         else
               throw new Exception("Utilisateur inconnu");
   }

	
}
