/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espol.rentalsystemtest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gene
 */
public class VideoGameRentalTest {

    public VideoGameRentalTest() {
    }
    VideoGameRental vdg;
    WiiGame videoGame;
    int daysRented;
    boolean consoleRented;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        videoGame = new WiiGame("Mario Galaxy");
        daysRented = 1;
        consoleRented = true;
        vdg = new VideoGameRental(videoGame, daysRented, consoleRented);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getDaysRented method, of class VideoGameRental.
     */
    @Test
    public void testGetDaysRented() {
        System.out.println("getDaysRented");
        int expResult = daysRented;
        int result = vdg.getDaysRented();
        assertEquals(expResult, result);
    }

    /**
     * Test of getVideoGame method, of class VideoGameRental.
     */
    @Test
    public void testGetVideoGame() {
        System.out.println("getVideoGame");
        Object expResult = videoGame;
        Object result = vdg.getVideoGame();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCharge method, of class VideoGameRental.
     */
    @Test
    public void testGetCharge() {
        System.out.println("getCharge");
        double expResult = videoGame.getCharge(daysRented, consoleRented);
        double result = vdg.getCharge();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getFrequentRenterPoints method, of class VideoGameRental.
     */
    @Test
    public void testGetFrequentRenterPoints() {
        System.out.println("getFrequentRenterPoints");
        int expResult = videoGame.getFrequentRenterPoints(daysRented, consoleRented);
        int result = vdg.getFrequentRenterPoints();
        assertEquals(expResult, result);
    }

}
