package application;

import java.util.Date;

import entities.Department;
import entities.Seller;

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
		
		Department obj = new Department(1,"Books");
		Seller seller = new Seller(21,"Bob","bob@gmail.com",new Date(),3000.0,obj);
		
		System.out.println(obj);
		System.out.println(seller);
		
		
		

	}

}
