package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("| Teste 1 - FindById |");	
		Seller seller = sellerDao.findById(3);	
		System.out.println(seller);
		
		System.out.println("| Teste 2 - FindByDepartment |");
		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(dep);	
		for (Seller sel : list) System.out.println(sel);	
		
		System.out.println("| Teste 3 - FindAll |");
		list = sellerDao.findAll();	
		for (Seller sel : list) System.out.println(sel);	
		
		System.out.println("| Teste 4 - Insert |");
		Seller newSeller = new Seller(null, "Eduardo", "teste@gmail.com", new Date(), 4000.0, dep);
		sellerDao.insert(newSeller);
		
		System.out.println("Novo ID: " + newSeller.getId());
		

	}

}
