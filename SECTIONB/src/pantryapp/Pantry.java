/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pantryapp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Pantry {
    
    // This is a dynamic array  to hold our ingredients. It grows as needed.
    private ArrayList<Ingredients> ingredients = new ArrayList<>();

    // This method adds a new ingredient to our array list.
    public void addIngredient(Ingredients ingredient) {
        ingredients.add(ingredient);
    }

    // This method finds an ingredient by its name.
    public Ingredients findIngredientByName(String name) {
        for (Ingredients item : ingredients) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null; // Returns nothing if the ingredient is not found.
    }
    
    // This method updates the quantity of an existing ingredient.
    public boolean updateIngredientQuantity(String name, int newQuantity) {
        Ingredients item = findIngredientByName(name);
        if (item != null) {
            item.setQuantity(newQuantity);
            return true;
        }
        return false;
    }

    // This new method finds fresh produce items that are expiring soon.
    public ArrayList<FreshProduce> getNearExpiryItems() {
        ArrayList<FreshProduce> nearExpiryItems = new ArrayList<>();
        LocalDate today = LocalDate.now();
       
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        // We go through every item in our pantry.
        for (Ingredients item : ingredients) {
            // We use 'instanceof' to check if the item is a FreshProduce object.
            if (item instanceof FreshProduce) {
                // We "cast" the item to a FreshProduce object so we can access its unique methods.
                FreshProduce freshItem = (FreshProduce) item;
                LocalDate expiryDate = LocalDate.parse(freshItem.getBestBeforeDate(), formatter);
                
                // We check if the expiry date is within the next 7 days and is not in the past.
                if (expiryDate.isBefore(today.plusDays(8)) && !expiryDate.isBefore(today)) {
                    nearExpiryItems.add(freshItem);
                }
            }
        }
        return nearExpiryItems;
    }

    // This method creates a formatted report of everything in the pantry.
    public String generatePantryReport() {
        if (ingredients.isEmpty()) {
            return "The pantry is empty.";
        }
        
        StringBuilder report = new StringBuilder("--- Pantry Report ---\n");
        for (int i = 0; i < ingredients.size(); i++) {
            Ingredients item = ingredients.get(i);
            report.append(i + 1).append(". ").append(item.toString())
                  .append(" - (").append(item.getDetails()).append(")\n");
        }
        report.append("--- End of Report ---");
        return report.toString();
    }
    
    // This getter is useful for unit testing to access the private list of ingredients.
    public ArrayList<Ingredients> getIngredients() {
        return ingredients;
    }
}