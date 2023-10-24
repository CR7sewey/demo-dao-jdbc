package model.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import db.DB;
import db.DbException;
import db.DbIntegrityException;
import entities.Department;
import entities.Seller;
import model.dao.SellerDao;

// metdos da interface

public class SellerDaoJDBC implements SellerDao {

	private Connection conn;
	
	// forçar injacao de dependencia
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Seller dep) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Seller dep) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Seller findById(Integer id) {
		// TODO Auto-generated method stub

		
		PreparedStatement st = null;
		ResultSet rs = null; // objeto contendo os resultados da nossa consulta numa tablea!!

		try {
			
			String query = "SELECT seller.*,department.Name as DepName FROM seller"
					+ " INNER JOIN department ON seller.DepartmentId = department.Id " + "WHERE seller.Id = ?";
			st = conn.prepareStatement(query);
			st.setInt(1, id); 
			rs = st.executeQuery();
			if (rs.next()) { // pq primeira linha ~´e a do id e assim
				Department dep = new Department();
				dep.setId(rs.getInt("DepartmentId"));	
				dep.setName(rs.getString("DepName"));
				// podia fazer como para o dep
				/*
				 * Seller obj = new Seller();
				 * obj.setId(rs.getInt("Id");
				 */
				return new Seller(rs.getInt("Id"),rs.getString("Name"),rs.getString("Email"),
						rs.getDate("BirthDate"),rs.getDouble("BaseSalary"),dep);
				
			}
		 
			return null;

		
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			
		}

		
	}

	@Override
	public List<Seller> findAll() {

		return null;
	}

}
