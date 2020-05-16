package com.thoughtworks.movierental;

public class Customer {
    private String name;
    private Rentals rentals = new Rentals();

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
        TextStatement textStatement = new TextStatement(name, rentals);
        return textStatement.statement();
    }

    public String htmlStatement() {
        HtmlStatement htmlStatement = new HtmlStatement(name, rentals);
        return htmlStatement.statement();
    }

}

