package user;

import java.util.Scanner;

import com.Product;

public class Driver {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		UserDao userDao=new UserDao();
		System.out.println("1.SaveUser\n2.UpdateUser\n3.FindById\n4.DisplayAll\n5.DeleteById\n6.FindUserByEmailPassword");
		System.out.println("Enter choice");
		int choice=scanner.nextInt();
		switch(choice)
		{
		case 1:{
			System.out.println("Enter user id");
			int id=scanner.nextInt();
			System.out.println("Enter user name");
			String username=scanner.next();
			System.out.println("Enter user password");
			String password=scanner.next();
			System.out.println("Enter user email");
			String email=scanner.next();
			System.out.println("Enter user phno");
			long price=scanner.nextLong();

			User user=new User(id, username, password, email, price);

			userDao.saveProduct(user);
		}
		break;
		case 2:{
			System.out.println("1.update username\n2.update password\n3.update email\n4.update phno");
			System.out.println("Enter choice");
			int choice1 =scanner.nextInt();
			User user = new User();
			switch(choice1) {
			case 1:{
				System.out.println("Enter id");
				int id=scanner.nextInt();
				System.out.println("Enter new username");
				String username=scanner.next();
				user.setId(id);
				user.setUsername(username);
				userDao.updateUser(user);

			}
			break;
			case 2:{
				System.out.println("Enter id");
				int id=scanner.nextInt();
				System.out.println("Enter new password");
				String password=scanner.next();
				user.setId(id);
				user.setPassword(password);
				userDao.updateUser(user);

			}
			break;
			case 3:{
				System.out.println("Enter id");
				int id=scanner.nextInt();
				System.out.println("Enter new email");
				String email=scanner.next();
				user.setId(id);
				user.setEmail(email);
				userDao.updateUser(user);

			}
			break;
			case 4:{
				System.out.println("Enter id");
				int id=scanner.nextInt();
				System.out.println("Enter new phno");
				long phno=scanner.nextLong();
				user.setId(id);
				user.setPhno(phno);
				userDao.updateUser(user);

			}
			break;
			}
		}
		break;
		case 3:{
			System.out.println("Enter id");
			int id=scanner.nextInt();
			if(userDao.findById(id)!=null)
				System.out.println(userDao.findById(id));
		}
		break;
		case 4:
		{
			
			for (User user : userDao.displayAll()) {
				System.out.println(user);
			}
		}
		break;
		case 5:{
			System.out.println("Enter id");
			int id=scanner.nextInt();
			userDao.deleteUser(id);
		}
		break;
		case 6:{
			System.out.println("Enter email");
			String email=scanner.next();
			System.out.println("Enter password");
			String password=scanner.next();
		System.out.println(userDao.findUserByEmailPassword(email, password));
		}


		}

	}

}
