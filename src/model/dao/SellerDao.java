package model.dao;

import java.util.List;

import entities.Department;
import entities.Seller;

public interface SellerDao {


	void insert(Seller dep);
	void update(Seller dep);
	void deleteById(Integer id);
	Seller findById(Integer id);
	List<Seller> findAll();
	List<Seller> findByDepartment(Department department);
	
}
