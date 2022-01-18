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
public class CustomerTest {
    
    public CustomerTest() {
    }

    Customer instance;
    Movie movie;
    MovieRental movRental;
    Ps3Game psGame ;
    VideoGameRental gameRental ;
    
    @BeforeClass
    public static void setUpClass() {
       
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    @Before
    public void setUp() {
        instance = new Customer("Morty Smith");
        movie = new Movie("Alien Invasion Tomato Monster Mexican "
                + "Armada Brothers Who Are Just Regular Brothers "
                + "Running In A Van From An Asteroid And All Sorts"
                + " Of Things The Movie",Movie.REGULAR);
        movRental = new MovieRental(movie, 7);
        psGame = new Ps3Game("Resident Evil Village");
        gameRental = new VideoGameRental(psGame, 7, false);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addMovieRental method, of class Customer.
     */
    

    @org.junit.Test
    public void testAddMovieRental() {
        System.out.println("addMovieRental");
        instance.addMovieRental(movRental);
        
        String verify = instance.statement();
        assertTrue("Pelicula agg en lista",verify.contains(movie._title));
    }
    /**
     * Test of addVideoGameRental method, of class Customer.
     */
    @org.junit.Test
    public void testAddVideoGameRental() {
        System.out.println("addVideoGameRental");
        instance.addVideoGameRental(gameRental);
        String verify = instance.statement();
        Ps3Game psg = (Ps3Game)gameRental.getVideoGame();
        assertTrue("Videojuego agg en lista",verify.contains(psg.get_gameName()));
    }

    /**
     * Test of statement method, of class Customer.
     */
    @org.junit.Test
    public void testStatement() {
        float total=0; // total amount
        int freq = 0; //total FrequentRenterPoints
        //agg juego y pelicula
        instance.addVideoGameRental(gameRental);
        instance.addMovieRental(movRental);

        System.out.println("statement");
        
        String expresult = "Rental Record for " + instance._name + "\n";
        expresult += "\t" + movRental.getMovie()._title+ "\t"
                    + String.valueOf(9.5) + "\n";
        total += 9.5;
        freq++;
        expresult += "\t" + gameRental.getVideoGame() + "\t"
            		+ String.valueOf(gameRental.getCharge()) + "\n";
            total += gameRental.getCharge();
        expresult += "Amount owed is " + String.valueOf(total) + "\n";
        expresult += "You earned " + String.valueOf(freq+gameRental.getFrequentRenterPoints())
                + " frequent renter points";
            
        
        String result = instance.statement();
        assertEquals(expresult, result);
        
    }
    
}
