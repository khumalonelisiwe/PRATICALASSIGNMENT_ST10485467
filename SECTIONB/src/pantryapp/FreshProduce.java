/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pantryapp;

// FreshProduce inherits from Ingredient, so it gets all of Ingredient's features.
public class FreshProduce extends Ingredients {
    
    // This is the  variable for fresh produce.
    private String bestBeforeDate;

    // The constructor calls super() to pass information to the parent class, then sets its own variable.
    public FreshProduce(String name, int quantity, String unit, String storageLocation, String bestBeforeDate) {
        super(name, quantity, unit, storageLocation); 
        this.bestBeforeDate = bestBeforeDate;
    }

    // A getter to read the private variable.
    public String getBestBeforeDate() {
        return bestBeforeDate;
    }

    // A setter to change the private variable.
    public void setBestBeforeDate(String newDate) {
        this.bestBeforeDate = newDate;
    }

    // This method is required by the parent class.
    @Override
    public String getDetails() {
        return "Best before: " + bestBeforeDate;
    }
}