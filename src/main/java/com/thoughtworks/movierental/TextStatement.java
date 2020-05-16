package com.thoughtworks.movierental;

public class TextStatement {
    private String name;
    private Rentals rentals;

    public TextStatement(String name, Rentals rentals) {
        this.name = name;
        this.rentals = rentals;
    }

    public String statement() {
        return textHeader() + textBody() + textFooter();
    }

    private String textBody() {
        String statement = "";
        for (Rental each : rentals) {
            statement += "\t" + each.getMovie().getTitle() + "\t" + each.amount() + "\n";
        }
        return statement;
    }

    private String textFooter() {
        String footer = "Amount owed is " + rentals.totalAmount() + "\n";
        footer += "You earned " + rentals.totalFrequentRenterPoints() + " frequent renter points";
        return footer;
    }

    private String textHeader() {
        return "Rental Record for " + name + "\n";
    }
}