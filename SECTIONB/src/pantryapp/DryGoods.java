/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pantryapp;

// DryGoods  inherits from Ingredient.
public class DryGoods extends Ingredients {
    
    // This is the  variable for dry goods.
    private String storageType;

    // The constructor calls the parent's constructor, then sets its unique variable.
    public DryGoods(String name, int quantity, String unit, String storageLocation, String storageType) {
        super(name, quantity, unit, storageLocation);
        this.storageType = storageType;
    }

    // A getter for the  variable.
    public String getStorageType() {
        return storageType;
    }

    // A setter for the  variable.
    public void setStorageType(String newStorage) {
        this.storageType = newStorage;
    }

    // This method is required by the parent class this basically overides a method in the parent class.
    @Override
    public String getDetails() {
        return "Storage: " + storageType;
    }
}