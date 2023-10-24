package application;

import java.util.Date;
import java.util.List;

import entities.Department;
import entities.Seller;
import model.dao.DaoFactory;
import model.dao.SellerDao;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Referências:
		 * https://www.devmedia.com.br/dao-pattern-persistencia-de-dados-utilizando-o-
		 * padrao-dao/30999
		 * https://www.oracle.com/technetwork/java/dataaccessobject-138824.html Ideia
		 * geral do padrão DAO:  Para cada entidade, haverá um objeto responsável por
		 * fazer acesso a dados relacionado a esta entidade. Por exemplo: o Cliente:
		 * ClienteDao o Produto: ProdutoDao o Pedido: PedidoDao  Cada DAO será definido
		 * por uma interface.  A injeção de dependência pode ser feita por meio do
		 * padrão de projeto Factory
		 * 
		 * ~
		 * ClienteDao é o objeto reponsavel por fazer o acesso de dados a clientes
		 * etc
		 * 
		 * Cada Dao é representado por uma interface, visto que o acesso a dados pode mudar
		 * Hoje SQl e amanha outro banco de dados oracle, hoje DAO ou jdbc ou jpa e amanha migrar para outra tech (tipo orn)
		 * 
		 */
		
		
		SellerDao sellerDao = DaoFactory.createSellerDao(); // assim programa nao conece a implementacao, so a interface!, injecao de dependencia sem explicitar implementacao 
		System.out.println(" === TEST 1: seller findById ===");
		Seller seller = sellerDao.findById(3);

		System.out.println(seller);
		System.out.println("\n === TEST 2: seller findByDepartment ===");
		List<Seller> sellers = sellerDao.findByDepartment(new Department(2,null));
		
		sellers.forEach(System.out::println);
		
		
		System.out.println("\n === TEST 3: seller findAll ===");
		List<Seller> sellers2 = sellerDao.findAll();
		
		sellers2.forEach(System.out::println);
		
		System.out.println("\n === TEST 4: seller insert ===");
		Seller newSeller = new Seller(null,"Greg","grwg@gmail.com",new Date(),4000.0,new Department(2,null));
		sellerDao.insert(newSeller);
		
		System.out.println("Inserted New id = " + newSeller.getId());		
		
		
		System.out.println("\n === TEST 5: seller update ===");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update Completed");
		

	}

}
