package com.thoughtworks.movierental;

public class Rental {

  private int daysRented;
  private Movie movie;
  private final int  DEFAULT_RENTAL_POINTS = 1;
  private final int  BONUS_RENTAL_POINTS = 2;

  public Rental(Movie movie, int daysRented){
    this.movie = movie;
    this.daysRented = daysRented;
  }

  public int getDaysRented() {
    return daysRented;
  }

  public Movie getMovie() {
    return movie;
  }

  double amount() {
    double thisAmount = 0;
    //determine amounts for each line
    switch (movie.getPriceCode()) {
      case Movie.REGULAR:
        thisAmount += 2;
        if (daysRented > 2)
          thisAmount += (daysRented - 2) * 1.5;
        break;
      case Movie.NEW_RELEASE:
        thisAmount += daysRented * 3;
        break;
      case Movie.CHILDREN:
        thisAmount += 1.5;
        if (daysRented > 3)
          thisAmount += (daysRented - 3) * 1.5;
        break;
    }
    return thisAmount;
  }

  int frequentRenterPoints() {
    if (isBonusApplicable()) {
      return BONUS_RENTAL_POINTS;
    }
    return DEFAULT_RENTAL_POINTS;
  }

  private boolean isBonusApplicable() {
    return movie.isNewRelease()
        &&
        daysRented > 1;
  }

}