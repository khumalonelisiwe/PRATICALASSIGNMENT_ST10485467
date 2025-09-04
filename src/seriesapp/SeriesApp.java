/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package seriesapp;

import java.util.Scanner;

public class SeriesApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Series series = new Series(); // object to manage series

        boolean exitProgram = false; 

        while (!exitProgram) {
            System.out.println("LATEST SERIES - 2025");
            System.out.println("*************************");
            System.out.print("Enter (1) to launch menu or any other key to exit: ");

            if (input.hasNextInt() && input.nextInt() == 1) {
                boolean runningMenu = true; // the menu loop

                // Menu keeps looping after every action until user exits the program
                while (runningMenu) {
                    System.out.println("\nPlease select one of the following menu items:");
                    System.out.println("(1) Capture a new series.");
                    System.out.println("(2) Search for a series.");
                    System.out.println("(3) Update series age restriction.");
                    System.out.println("(4) Delete a series.");
                    System.out.println("(5) Print series report - 2025.");
                    System.out.println("(6) Exit Application.");
                    
                    System.out.print("Enter (1) to launch menu or any other key to exit: ");

                    if (input.hasNextInt()) {
                        int choice = input.nextInt();

                        if (choice == 1) {
                            series.captureSeries();
                        } else if (choice == 2) {
                            series.searchSeries();
                        } else if (choice == 3) {
                            series.updateSeries();
                        } else if (choice == 4) {
                            series.deleteSeries();
                        } else if (choice == 5) {
                            series.printReport();
                        } else if (choice == 6) {
                            System.out.println("Exiting menu...");
                            runningMenu = false; // exit the menu loop only
                        } else {
                            System.out.println("Invalid choice. Please try again.");
                        }

                    } else {
                        System.out.println("Invalid input. Please enter a number.");
                        input.next(); // discard invalid input
                    }
                }

            } else {
                System.out.println("Goodbye!");
                exitProgram = true; // exit the program completely
            }
        }

        input.close();
    }
}