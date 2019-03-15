/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.Scanner;

/**
 *
 * @author Raymond Chu
 */
public class Main {

    public static void main(String args[]) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Type 1 to start budget: ");
        int userInput = reader.nextInt();
        if (userInput == 1) {
           TextUserInterface newInterface= new TextUserInterface();
           newInterface.UserInterface();
        }
        System.out.println("Goodbye!");
    }

}
