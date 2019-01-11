package applicationenumcomp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.EnumComp.OrderStatus;
import entitiesEnumComp.Client;
import entitiesEnumComp.Order;
import entitiesEnumComp.OrderItem;
import entitiesEnumComp.Product;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.printf("Enter the data of the Client: %n");
		System.out.print("Name:");
		String name = sc.nextLine();
		System.out.print("Email:");
		String email = sc.nextLine();
		System.out.print("Birth Date (DD/MM/YYYY:");
		Date birthDate = sdf.parse(sc.next());			
		
		Client client = new Client(name, email, birthDate);
		
		System.out.print("Status:");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		Date date = new Date();
		Order order = new Order(date, status, client );		
		
		System.out.print("How many items to this order: ");
		int quantiItems = sc.nextInt();
		
		for (int i = 0; i < quantiItems; i++) {
			System.out.print("Enter the name of products:");
			String nameProduct = sc.nextLine();
			System.out.print("\nEnter the price of products:");
			sc.nextLine();
			Double price = sc.nextDouble();
		
			Product product = new Product(nameProduct, price);
			
			System.out.print("Quantity of products:");
			int quantity = sc.nextInt();
		
			OrderItem oi = new OrderItem(quantity, price, product);
			
			order.addItem(oi);
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		
		sc.close();
	}
}
