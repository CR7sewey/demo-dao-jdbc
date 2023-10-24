package model.dao;

import db.DB;
import model.impl.SellerDaoJDBC;

public class DaoFactory {
	
	// instanciar os meus DAOs
	
	public static SellerDao createSellerDao() { // expoem um metodo que retorna a interface
		return new SellerDaoJDBC(DB.getConnection()); // instancia implementacao
	}

}
