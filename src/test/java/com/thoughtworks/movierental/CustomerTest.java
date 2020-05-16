package com.thoughtworks.movierental;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    @Test
    public void shouldTestTextStatement(){
        Customer customer = customer();
        assertEquals("Rental Record for Roy\n" +
                "\tInterstellar\t1.5\n" +
                "\tAnother movie\t3.0\n" +
                "\tAvengers\t2.0\n" +
                "\tAvengers2\t3.5\n" +
                "\tMovie\t3.0\n" +
                "Amount owed is 13.0\n" +
                "You earned 5 frequent renter points",customer.statement());
    }

    @Test
    public void shouldTestHtmlStatement(){
        Customer customer = customer();
        String expectedHtmlStatement = "<h1>Rental Record for <b>Roy</b></h1><br/>" +
                "Interstellar 1.5<br/>" +
                "Another movie 3.0<br/>" +
                "Avengers 2.0<br/>" +
                "Avengers2 3.5<br/>" +
                "Movie 3.0<br/>" +
                "Amount owed is <b>13.0</b><br/>" +
                "You earned <b>5</b> frequent renter points";
        assertEquals(expectedHtmlStatement,customer.htmlStatement());
    }

    private Customer customer() {
        Customer customer = new Customer("Roy");
        customer.addRental(new Rental(new Movie("Interstellar",Movie.CHILDREN),1));
        customer.addRental(new Rental(new Movie("Another movie",Movie.NEW_RELEASE),1));
        customer.addRental(new Rental(new Movie("Avengers",Movie.REGULAR),1));
        customer.addRental(new Rental(new Movie("Avengers2",Movie.REGULAR),3));
        customer.addRental(new Rental(new Movie("Movie",Movie.CHILDREN),4));

        return customer;
    }
}