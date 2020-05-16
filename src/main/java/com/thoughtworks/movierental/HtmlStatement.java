package com.thoughtworks.movierental;

public class HtmlStatement {
    private String name;
    private Rentals rentals;

    public HtmlStatement(String name, Rentals rentals) {
        this.name = name;
        this.rentals = rentals;
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
        String footer = "Amount owed is <b>" + rentals.totalAmount() + "</b><br/>";
        footer += "You earned <b>" + rentals.totalFrequentRenterPoints() + "</b> frequent renter points";
        return footer;
    }

    private String htmlHeader() {
        return "<h1>Rental Record for <b>" + name + "</b></h1><br/>";
    }
}