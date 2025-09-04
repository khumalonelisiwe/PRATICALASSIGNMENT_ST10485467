/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seriesapp;

import java.util.ArrayList;
import java.util.Scanner;

// Series class stores series data and also contains all operations
public class Series {
    private int id;
    private String name;
    private int ageRestriction;
    private int episodes;

    // List to store all series objects
    private ArrayList<Series> seriesList = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    // Constructor
    public Series(int id, String name, int ageRestriction, int episodes) {
        this.id = id;
        this.name = name;
        this.ageRestriction = ageRestriction;
        this.episodes = episodes;
    }

    // Empty constructor (used for accessing methods only)
    public Series() {}

    //  Getter methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAgeRestriction() {
        return ageRestriction;
    }

    public int getEpisodes() {
        return episodes;
    }

    //  Setters methods
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAgeRestriction(int ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    //helper methods for unit testing
    // Add a series directly
    public void addSeries(int id, String name, int ageRestriction, int episodes) {
        seriesList.add(new Series(id, name, ageRestriction, episodes));
    }

    // Search for a series by id (returns object instead of printing)
    public Series searchSeries(int id) {
        for (Series s : seriesList) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    // Update a series by id
    public boolean updateSeries(int id, String newName, int newAgeRestriction, int newEpisodes) {
        for (Series s : seriesList) {
            if (s.getId() == id) {
                s.setName(newName);
                s.setAgeRestriction(newAgeRestriction);
                s.setEpisodes(newEpisodes);
                return true;
            }
        }
        return false;
    }

    // Delete a series by id
    public boolean deleteSeries(int id) {
        return seriesList.removeIf(s -> s.getId() == id);
    }

    // Validate age restriction
    public boolean isAgeRestrictionValid(int ageRestriction) {
        return ageRestriction >= 2 && ageRestriction <= 18;
    }

    // Thease are methods for our main application

    //  Capture a new series method
    public void captureSeries() {
        System.out.println("CAPTURE A NEW SERIES");
        System.out.println("*************************");

        System.out.print("Enter the series id: ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("Enter the series name: ");
        String name = input.nextLine();

        // Validate age restriction
        int ageRestriction;
        while (true) {
            System.out.print("Enter the series age restriction: ");
            if (input.hasNextInt()) {
                ageRestriction = input.nextInt();
                if (ageRestriction >= 2 && ageRestriction <= 18) {
                    break;
                } else {
                    System.out.println("You have entered an incorrect series age!!!");
                }
            } else {
                System.out.println("You have entered an incorrect series age!!!");
                input.next(); // clear invalid input
            }
        }

        System.out.print("Enter the number of episodes for " + name + ": ");
        int episodes = input.nextInt();

        seriesList.add(new Series(id, name, ageRestriction, episodes));
        System.out.println("Series processed successfully!!!");
    }

    //  Search for a series 
    public void searchSeries() {
        System.out.print("Enter the series id to search: ");
        int id = input.nextInt();

        for (Series s : seriesList) {
            if (s.getId() == id) {
                System.out.println("=========================");
                System.out.println("SERIES ID: " + s.getId());
                System.out.println("SERIES NAME: " + s.getName());
                System.out.println("SERIES AGE RESTRICTION: " + s.getAgeRestriction());
                System.out.println("SERIES NUMBER OF EPISODES: " + s.getEpisodes());
                System.out.println("=========================");
                return;
            }
        }
        System.out.println("Series with Series Id: " + id + " was not found!");
    }

    //  Update a series 
    public void updateSeries() {
        System.out.print("Enter the series id to update: ");
        int id = input.nextInt();
        input.nextLine();

        for (Series s : seriesList) {
            if (s.getId() == id) {
                System.out.print("Enter the series name: ");
                s.setName(input.nextLine());

                System.out.print("Enter the age restriction: ");
                s.setAgeRestriction(input.nextInt());

                System.out.print("Enter the number of episodes: ");
                s.setEpisodes(input.nextInt());

                System.out.println("Series updated successfully!");
                return;
            }
        }
        System.out.println("Series with Series Id: " + id + " was not found!");
    }

    //  Delete a series 
    public void deleteSeries() {
        System.out.print("Enter the series id to delete: ");
        int id = input.nextInt();

        for (Series s : seriesList) {
            if (s.getId() == id) {
                System.out.print("Are you sure you want to delete series " + id + "? (y to confirm): ");
                char confirm = input.next().toLowerCase().charAt(0);
                if (confirm == 'y') {
                    seriesList.remove(s);
                    System.out.println("Series with Series Id: " + id + " WAS deleted!");
                } else {
                    System.out.println("Delete cancelled.");
                }
                return;
            }
        }
        System.out.println("Series with Series Id: " + id + " was not found!");
    }

    //  Print report
    public void printReport() {
        if (seriesList.isEmpty()) {
            System.out.println("No series found!");
            return;
        }

        int count = 1;
        for (Series s : seriesList) {
            System.out.println("Series " + count);
            System.out.println("----------------------------");
            System.out.println("SERIES ID: " + s.getId());
            System.out.println("SERIES NAME: " + s.getName());
            System.out.println("SERIES AGE RESTRICTION: " + s.getAgeRestriction());
            System.out.println("NUMBER OF EPISODES: " + s.getEpisodes());
            System.out.println("----------------------------");
            count++;
        }
    }
}
