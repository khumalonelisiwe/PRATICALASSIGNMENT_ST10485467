/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pantryapp;

import java.util.ArrayList;
import java.util.Scanner;

public class PantryApp {
    public static void main(String[] args) {
        Pantry myPantry = new Pantry();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n--- Digital Pantry Manager ---");
            System.out.println("1. Add a new ingredient");
            System.out.println("2. Find an ingredient by name");
            System.out.println("3. Update ingredient quantity");
            System.out.println("4. Check for expiring items");
            System.out.println("5. Generate pantry report");
            System.out.println("6. Exit");
            System.out.print("Please select an option: ");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.print("Is it Fresh Produce (F) or Dry Goods (D)? ");
                String type = scanner.nextLine().toUpperCase();
                System.out.print("Enter ingredient name: ");
                String name = scanner.nextLine();
                System.out.print("Enter storage location (Pantry/Fridge): ");
                String location = scanner.nextLine();
                System.out.print("Enter quantity: ");

                // Input validation to prevent incorrect input from the user
                if (scanner.hasNextInt()) {
                    int quantity = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter unit (e.g., kg, pieces): ");
                    String unit = scanner.nextLine();

                    if (type.equals("F")) {
                        System.out.print("Enter 'best before' date (MM/dd/yyyy): ");
                        String date = scanner.nextLine();
                        myPantry.addIngredient(new FreshProduce(name, quantity, unit, location, date));
                    } else if (type.equals("D")) {
                        System.out.print("Enter storage type (e.g., pantry, cupboard): ");
                        String storage = scanner.nextLine();
                        myPantry.addIngredient(new DryGoods(name, quantity, unit, location, storage));
                    } else {
                        System.out.println("Invalid ingredient type.");
                    }
                    System.out.println("Ingredient added successfully!");
                } else {
                    System.out.println("Error: The quantity must be a whole number. Please try again.");
                    scanner.nextLine();
                }

            } else if (choice.equals("2")) {
                System.out.print("Enter the name to find: ");
                String searchName = scanner.nextLine();
                Ingredients foundItem = myPantry.findIngredientByName(searchName);
                if (foundItem != null) {
                    System.out.println("Item found: " + foundItem + " - (" + foundItem.getDetails() + ")");
                } else {
                    System.out.println("Ingredient '" + searchName + "' was not found.");
                }

            } else if (choice.equals("3")) {
                System.out.print("Enter ingredient name to update: ");
                String updateName = scanner.nextLine();
                System.out.print("Enter new quantity: ");

                // Input validation also
                if (scanner.hasNextInt()) {
                    int newQuantity = scanner.nextInt();
                    scanner.nextLine();
                    if (myPantry.updateIngredientQuantity(updateName, newQuantity)) {
                        System.out.println("Quantity updated successfully!");
                    } else {
                        System.out.println("Ingredient not found.");
                    }
                } else {
                    System.out.println("Error: The quantity must be a whole number. Please try again.");
                    scanner.nextLine();
                }

            } else if (choice.equals("4")) {
                ArrayList<FreshProduce> expiringItems = myPantry.getNearExpiryItems();
                if (expiringItems.isEmpty()) {
                    System.out.println("No fresh produce is expiring in the next 7 days. You're all good!");
                } else {
                    System.out.println("\n--- Items to Use/Stock Soon ---");
                    for (FreshProduce item : expiringItems) {
                        System.out.println(item.getName() + " (" + item.getBestBeforeDate() + ") - " + item.getQuantity() + " " + item.getUnit());
                    }
                    System.out.println("--- End of List ---");
                }

            } else if (choice.equals("5")) {
                System.out.println(myPantry.generatePantryReport());

            } else if (choice.equals("6")) {
                isRunning = false;
                System.out.println("Exiting application. Goodbye!");

            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}