package com.thoughtworks.movierental;

import java.util.List;

public class HtmlStatement {
    private String name;
    private List<Rental> rentals;
    private double totalAmount;
    private int totalFrequentRenterPoints;

    public HtmlStatement(String name, List<Rental> rentals, double totalAmount, int totalFrequentRenterPoints) {
        this.name = name;
        this.rentals = rentals;
        this.totalAmount = totalAmount;
        this.totalFrequentRenterPoints = totalFrequentRenterPoints;
    }

    public String statement() {
        return htmlHeader() + htmlBody() + htmlFooter();
    }

    private String htmlBody() {
        String statement = "";
        for (Rental each : rentals) {
            statement += each.getMovie().getTitle() + " " + each.amount() + "<br/>";
        }
        return statement;
    }

    private String htmlFooter() {
        String footer = "Amount owed is <b>" + totalAmount + "</b><br/>";
        footer += "You earned <b>" + totalFrequentRenterPoints + "</b> frequent renter points";
        return footer;
    }

    private String htmlHeader() {
        return "<h1>Rental Record for <b>" + name + "</b></h1><br/>";
    }
}