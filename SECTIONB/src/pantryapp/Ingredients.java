/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pantryapp;

public abstract class Ingredients {
    
    // These are our variables,they are private to protect them so they are not easily accasible.
    private String name;
    private int quantity;
    private String unit;
    private String storageLocation;

    // This is the constructor. It's a  method that runs when we create a new Ingredient.
    public Ingredients(String name, int quantity, String unit, String storageLocation) {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
        this.storageLocation = storageLocation;
    }

    
    // Getters: These methods "get" or "read" the private data.
    // They are public so other parts of the program can access the data safely.
    
    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }
    
    public String getStorageLocation() {
        return storageLocation;
    }

   
    // Setters: These methods "set" or "change" the private data.
    // They are also public and provide a controlled way to update the data.
    
    public void setName(String newName) {
        // We use "this.name" to refer to the class's variable.
        this.name = newName;
    }

    public void setQuantity(int newQuantity) {
        // We can add rules here to make sure the data is valid.
        // For example, an ingredient's quantity should not be negative.
        if (newQuantity >= 0) {
            this.quantity = newQuantity;
        }
    }

    public void setUnit(String newUnit) {
        this.unit = newUnit;
    }
    
    public void setStorageLocation(String newLocation) {
        this.storageLocation = newLocation;
    }

    // This is an abstract method. Any class that inherits from this one MUST create this method.
    public abstract String getDetails();

    // The toString() method helps us print a clear description of the object.
    @Override
    public String toString() {
        return name + " - " + quantity + " " + unit + " (" + storageLocation + ")";
    }
}