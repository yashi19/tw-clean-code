package com.thoughtworks.movierental;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    @Test
    public void test(){
        Customer customer = new Customer("Roy");
        customer.addRental(new Rental(new Movie("Interstellar",Movie.CHILDRENS),1));
        customer.addRental(new Rental(new Movie("Another movie",Movie.NEW_RELEASE),1));
        customer.addRental(new Rental(new Movie("Avengers",Movie.REGULAR),1));
        customer.addRental(new Rental(new Movie("Avengers2",Movie.REGULAR),3));
        customer.addRental(new Rental(new Movie("Movie",Movie.CHILDRENS),4));


        assertEquals("Rental Record for Roy\n" +
                "\tInterstellar\t1.5\n" +
                "\tAnother movie\t3.0\n" +
                "\tAvengers\t2.0\n" +
                "\tAvengers2\t3.5\n" +
                "\tMovie\t3.0\n" +
                "Amount owed is 13.0\n" +
                "You earned 5 frequent renter points",customer.statement());
    }
}