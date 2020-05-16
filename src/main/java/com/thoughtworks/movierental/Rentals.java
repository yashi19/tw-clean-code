package com.thoughtworks.movierental;

import java.util.ArrayList;

public class Rentals extends ArrayList<Rental> {
     int totalFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental each : this) {
            frequentRenterPoints += each.frequentRenterPoints();
        }
        return frequentRenterPoints;
    }

     double totalAmount() {
        double totalAmount = 0;
        for (Rental each : this) {
            totalAmount += each.amount();
        }
        return totalAmount;
    }
}
