package com.thoughtworks.movierental;

import java.util.List;

public class TextStatement {
    private String name;
    private List<Rental> rentals;
    private double totalAmount;
    private int totalFrequentRenterPoints;

    public TextStatement(String name, List<Rental> rentals, double totalAmount, int totalFrequentRenterPoints) {
        this.name = name;
        this.rentals = rentals;
        this.totalAmount = totalAmount;
        this.totalFrequentRenterPoints = totalFrequentRenterPoints;
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
        String footer = "Amount owed is " + totalAmount + "\n";
        footer += "You earned " + totalFrequentRenterPoints + " frequent renter points";
        return footer;
    }

    private String textHeader() {
        return "Rental Record for " + name + "\n";
    }
}