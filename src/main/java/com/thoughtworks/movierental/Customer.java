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
        String footer = "Amount owed is " + totalAmount() + "\n";
        footer += "You earned " + totalFrequentRenterPoints() + " frequent renter points";
        return footer;
    }

    private String textHeader() {
        return "Rental Record for " + name + "\n";
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

}

