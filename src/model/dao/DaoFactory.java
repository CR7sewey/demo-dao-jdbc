package model.dao;

import model.impl.SellerDaoJDBC;

public class DaoFactory {
	
	// instanciar os meus DAOs
	
	public static SellerDao createSellerDao() { // expoem um metodo que retorna a interface
		return new SellerDaoJDBC(); // instancia implementacao
	}

}
