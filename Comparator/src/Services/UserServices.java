package Services;

import DAO.UserDAO;
import Objects.User;


public class UserServices {

	private UserDAO uDAO;
	
	 public User checkUserPassword(String login, String password) throws Exception{
		 uDAO = new UserDAO();
         User u = uDAO.getUserbyName(login);
         // Si le login correspond � un User, on v�rifie le mot de passe associ�
         if (u != null)
               if (u.getPassword().equals(password))
                     return u;
               else
                     throw new Exception("Mot de passe erron�");
         else
               throw new Exception("Utilisateur inconnu");
   }

	
}
