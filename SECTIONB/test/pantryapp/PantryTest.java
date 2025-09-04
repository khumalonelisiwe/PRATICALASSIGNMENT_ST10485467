/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

package pantryapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PantryTest {

    
    @Test
    public void testAddIngredient() {
        // Create a new Pantry
        Pantry pantry = new Pantry();

        // Create ingredients
        FreshProduce apple = new FreshProduce("Apple", 5, "pieces", "Fridge", "10/30/2025");
        DryGoods flour = new DryGoods("Flour", 1, "kg", "Pantry", "pantry");
        FreshProduce banana = new FreshProduce("Banana", 3, "pieces", "Fridge", "09/05/2025");

        // Add them to pantry
        pantry.addIngredient(apple);
        pantry.addIngredient(flour);
        pantry.addIngredient(banana);

        // Verify pantry has 3 ingredients
        assertEquals(3, pantry.getIngredients().size(), "Pantry should contain 3 ingredients.");
    }

    @Test
    public void testFindIngredientByName_Found() {
        Pantry pantry = new Pantry();

        // Add one item
        FreshProduce apple = new FreshProduce("Apple", 5, "pieces", "Fridge", "10/30/2025");
        pantry.addIngredient(apple);

        // Search for it by name
        Ingredients found = pantry.findIngredientByName("Apple");

        // Verify search worked
        assertNotNull(found, "Ingredient should be found by name.");
        assertEquals("Apple", found.getName());
        assertEquals(5, found.getQuantity());
    }

    @Test
    public void testFindIngredientByName_NotFound() {
        Pantry pantry = new Pantry();

        // Try to find an item that doesn't exist
        Ingredients notFound = pantry.findIngredientByName("Milk");

        // Should return null
        assertNull(notFound, "Ingredient should not be found.");
    }

    @Test
    public void testUpdateIngredientQuantity_Success() {
        Pantry pantry = new Pantry();

        // Add Apple with quantity 5
        FreshProduce apple = new FreshProduce("Apple", 5, "pieces", "Fridge", "10/30/2025");
        pantry.addIngredient(apple);

        // Update quantity to 2
        boolean updated = pantry.updateIngredientQuantity("Apple", 2);

        // Verify update succeeded
        assertTrue(updated, "Updating existing ingredient should return true.");

        // Verify new quantity is reflected
        Ingredients updatedItem = pantry.findIngredientByName("Apple");
        assertNotNull(updatedItem);
        assertEquals(2, updatedItem.getQuantity(), "Quantity should be updated to 2.");
    }

    @Test
    public void testUpdateIngredientQuantity_Failure() {
        Pantry pantry = new Pantry();

        // Try updating a non-existing ingredient
        boolean updated = pantry.updateIngredientQuantity("Milk", 5);

        // Should fail
        assertFalse(updated, "Updating non-existing ingredient should return false.");
    }

    @Test
    public void testGetNearExpiryItems_OnlyBanana() {
        Pantry pantry = new Pantry();

        // Add Banana with near expiry date
        FreshProduce banana = new FreshProduce("Banana", 3, "pieces", "Fridge", "09/05/2025");
        pantry.addIngredient(banana);

        // Get items near expiry
        ArrayList<FreshProduce> nearExpiryItems = pantry.getNearExpiryItems();

        // Verify only Banana is included
        assertEquals(1, nearExpiryItems.size(), "Only Banana should be nearing expiry.");
        assertEquals("Banana", nearExpiryItems.get(0).getName(), "Banana should be in the near expiry list.");
    }

    @Test
    public void testGetNearExpiryItems_EmptyIfAllFarExpiry() {
        Pantry pantry = new Pantry();

        // Add Mango with a far expiry date
        FreshProduce distantDateItem = new FreshProduce("Mango", 2, "pieces", "Fridge", "12/31/2025");
        pantry.addIngredient(distantDateItem);

        // Get near expiry items
        ArrayList<FreshProduce> result = pantry.getNearExpiryItems();

        // Verify none are returned
        assertTrue(result.isEmpty(), "No items should be near expiry.");
    }

    @Test
    public void testGeneratePantryReport_NotEmpty() {
        Pantry pantry = new Pantry();

        // Add some items
        FreshProduce apple = new FreshProduce("Apple", 5, "pieces", "Fridge", "10/30/2025");
        DryGoods flour = new DryGoods("Flour", 1, "kg", "Pantry", "pantry");
        FreshProduce banana = new FreshProduce("Banana", 3, "pieces", "Fridge", "09/05/2025");
        pantry.addIngredient(apple);
        pantry.addIngredient(flour);
        pantry.addIngredient(banana);

        // Generate report
        String report = pantry.generatePantryReport();

        // Verify report contents
        assertTrue(report.contains("Apple"), "Report should contain Apple.");
        assertTrue(report.contains("Flour"), "Report should contain Flour.");
        assertTrue(report.contains("Banana"), "Report should contain Banana.");
        assertTrue(report.startsWith("--- Pantry Report ---"), "Report should start with title.");
        assertTrue(report.endsWith("--- End of Report ---"), "Report should end with footer.");
    }

    @Test
    public void testGeneratePantryReport_Empty() {
        Pantry pantry = new Pantry();

        // Generate report for empty pantry
        String report = pantry.generatePantryReport();

        // Verify correct empty message
        assertEquals("The pantry is empty.", report, "Report should state pantry is empty.");
    }
}
