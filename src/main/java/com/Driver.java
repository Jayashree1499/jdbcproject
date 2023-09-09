package com;

import java.util.List;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		ProductDao productDao = new ProductDao();
		System.out.println("1.SaveProduct\n2.UpdateProduct\n3.FindById\n4.DisplayAll\n5.DeleteById");
		System.out.println("Enter choice");
		int choice = scanner.nextInt();

		switch (choice) {
		case 1: {
			System.out.println("Enter product id");
			int id = scanner.nextInt();
			System.out.println("Enter product name");
			String name = scanner.next();
			System.out.println("Enter product type");
			String type = scanner.next();
			System.out.println("Enter product price");
			double price = scanner.nextDouble();

			Product product = new Product(id, name, type, price);
			productDao.saveProduct(product);
		}
			break;

//		case 2:
//		{
//			Product product = new Product();
//			System.out.println("Enter id");
//			int id=scanner.nextInt();
//			System.out.println("Enter new name");
//			String name=scanner.next();
//			product.setId(id);
//			product.setName(name);
//			productDao.updateProduct(product);
//		}
//			break;

		case 2:{
			System.out.println("1.update name\n2.update type\n3.update cost");
			System.out.println("Enter choice");
			int choice1 =scanner.nextInt();
			Product product = new Product();
			switch(choice1) {
			case 1:{
				//Product product = new Product();
				System.out.println("Enter id");
				int id=scanner.nextInt();
				System.out.println("Enter new name");
				String name=scanner.next();
				product.setId(id);
				product.setName(name);
				productDao.updateProduct(product);
			}
			break;
			case 2:{
				//Product product = new Product();
				System.out.println("Enter id");
				int id=scanner.nextInt();
				System.out.println("Enter new type");
				String type=scanner.next();
				product.setId(id);
				product.setType(type);
				productDao.updateProduct(product);
			}
			break;
			case 3:{
			//	Product product = new Product();
				System.out.println("Enter id");
				int id=scanner.nextInt();
				System.out.println("Enter new cost");
				double cost=scanner.nextDouble();
				product.setId(id);
				product.setCost(cost);
				productDao.updateProduct(product);
			}
				
				
			}
		}
			break;
		case 3: {
			System.out.println("Enter product id");
			int id = scanner.nextInt();
			if(productDao.findById(id)!=null)
			System.out.println(productDao.findById(id));
		}
		break;
		case 4:

			for (Product l : productDao.displayAll()) {
				System.out.println(l);
			}

		case 5: {
			System.out.println("Enter product id");
			int id = scanner.nextInt();
			productDao.deleteByID(id);
		}

		}

	}

}
