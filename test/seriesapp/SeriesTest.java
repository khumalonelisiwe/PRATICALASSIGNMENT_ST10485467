/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package seriesapp;



import org.junit.Assert;
import org.junit.Test;
import  org.junit.jupiter.api.BeforeEach;

public class SeriesTest {

    public Series series;

    @Test
    public void TestSearchSeries() {
        Series series = new Series(); //  initialize
        series.addSeries(1, "Blindspot", 10, 45); // Add data before searching

        Series result = series.searchSeries(1);
        Assert.assertNotNull(result);
        Assert.assertEquals("Blindspot", result.getName());
    }

    @Test
    public void TestSearchSeries_SeriesNotFound() {
        Series series = new Series(); //  initialize

        Series result = series.searchSeries(99);
        Assert.assertNull(result);
    }

    @Test
    public void TestUpdateSeries() {
        Series series = new Series(); //  initialize
        series.addSeries(1, "Blindspot", 10, 45); // Add data before updating

        boolean updated = series.updateSeries(1, "Blindspot", 16, 50);
        Assert.assertTrue(updated);

        Series result = series.searchSeries(1);
        Assert.assertNotNull(result);
        Assert.assertEquals("Blindspot", result.getName());
    }

    @Test
    public void TestDeleteSeries() {
        Series series = new Series(); // initialize
        series.addSeries(1, "Blindspot", 16, 50);

        boolean deleted = series.deleteSeries(1);
        Assert.assertTrue(deleted);
    }

    @Test
    public void TestDeleteSeries_SeriesNotFound() {
        Series series = new Series(); //  initialize

        boolean deleted = series.deleteSeries(99);
        Assert.assertFalse(deleted);
    }

    @Test
    public void TestSeriesAgeRestriction_AgeValid() {
        Series series = new Series(); // initialize

        Assert.assertTrue(series.isAgeRestrictionValid(12));//these are the correct ages for the age restriction
        Assert.assertTrue(series.isAgeRestrictionValid(18));
        Assert.assertTrue(series.isAgeRestrictionValid(2));
    }

    @Test
    public void TestSeriesAgeRestriction_SeriesAgeInValid() {
        Series series = new Series(); //  initialize

        Assert.assertFalse(series.isAgeRestrictionValid(1));//these are the incorrect ages to check if the method works
        Assert.assertFalse(series.isAgeRestrictionValid(25));
    }
}