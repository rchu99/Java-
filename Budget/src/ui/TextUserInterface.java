/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import budget.Budget;
import budget.Product;

import java.util.Scanner;

/**
 *
 * @author Raymond Chu
 */
public class TextUserInterface {

    public void UserInterface() {
        Scanner reader = new Scanner(System.in);
        System.out.println("-----------------------------------");
        System.out.println("Hello I am your budget tracker!");
        System.out.println("-----------------------------------");

        boolean userInterfaceOn = true;
        Budget budget = new Budget();
        while (userInterfaceOn) {
            System.out.println("Enter 1: Add a new purchase");
            System.out.println("Enter 2: Get price of product");
            System.out.println("Enter 3: Delete a purchase");
            System.out.println("Enter 4: Reduce a purchase");
            System.out.println("Enter 5: Get the total price");
            System.out.println("Enter ANY KEY TO EXIT");
            System.out.print("What would you like?: ");
            int userInput = reader.nextInt();
            if (userInput == 1) {
                System.out.println("What product did you buy: ");
                reader.nextLine();
                String name = reader.nextLine();
                System.out.println("Enter 1 if this item is a LUXURY: ");
                System.out.println("Enter 2 if this item is a NECESSITY: ");
                System.out.println("Enter 3 if this item is a COMFORT: ");
                System.out.println("Enter 0 to EXIT: ");
                int productType = reader.nextInt();
                int type = typeCheck(productType);
                if (type == 0) {
                    break;
                }
                Product newProduct = new Product(name, type);
                System.out.print("Price: ");
                double price = reader.nextDouble();
                budget.addProduct(newProduct, price);
                continue;
            } else if (userInput == 2) {
                System.out.print("What product would you like to get:" );
                String product = reader.nextLine();
                double price = budget.getPrice(product);
                if (price == 0) {
                    System.out.println("Product not found!");
                    continue;
                }
                System.out.println("The price is: " + price);
                continue;
            } else if (userInput == 3) {
                break;
            } else if (userInput == 4) {
                break;
            } else if (userInput == 5) {
                break;
            } else {
                userInterfaceOn = false;
            }
        }
    }

    public int typeCheck(int type) {

        while (type > 3 || type < 1) {
            System.out.println("Number is out of range!");
            System.out.println("-------------------------------------------");
            System.out.println("Enter 1 if this item is a LUXURY: ");
            System.out.println("Enter 2 if this item is a NECESSITY: ");
            System.out.println("Enter 3 if this item is a COMFORT: ");
            System.out.println("Enter 0 to EXIT;: ");
            if (type == 0) {
                return 0;
            }
        }
        return type;
    }
}
