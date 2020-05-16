package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        TextStatement textStatement = new TextStatement(name, rentals, totalAmount(), totalFrequentRenterPoints());
        return textStatement.statement();
    }

    private int totalFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental each : rentals) {
            frequentRenterPoints += each.frequentRenterPoints();
        }
        return frequentRenterPoints;
    }

    private double totalAmount() {
        double totalAmount = 0;
        for (Rental each : rentals) {
            totalAmount += each.amount();
        }
        return totalAmount;
    }

    public String htmlStatement() {
        HtmlStatement htmlStatement = new HtmlStatement(name, rentals, totalAmount(), totalFrequentRenterPoints());
        return htmlStatement.statement();
    }

}

