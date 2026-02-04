package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {
	public static void main(String[] args) {

		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("| Teste 1 - FindAll |");
		List<Department> list = depDao.findAll();	
		for (Department dep : list) System.out.println(dep);
		
		System.out.println("| Teste 2 - FindById |");	
		Department dep = depDao.findById(3);	
		System.out.println(dep);
		
		System.out.println("| Teste 3 - Insert |");
		Department newDep = new Department(null, "Foods");
		depDao.insert(newDep);
		
		System.out.println("Novo ID: " + newDep.getId());
		
		System.out.println("| Teste 4 - Update |");
		dep = depDao.findById(1);
		dep.setName("New Computers");
		
		depDao.update(dep);
		System.out.println("Update realizado!");
		
		System.out.println("| Teste 4 - Delete |");
		System.out.print("Entre com o ID: ");
		int id = sc.nextInt();
		
		depDao.deleteById(id);
		System.out.println("Delete realizado!");
		

		sc.close();
	}

}
