/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * This class takes in a simple date consisting of a month, day, and year. The
 * class can advance the date by one day or by one week. It can also print out
 * the date as well. The class also checks to see if the date is valid.
 *
 * @author Rasha Abuhantash
 * @version 02/03/2018
 */
public class CustomDate {

    private int day;
    private int month;
    private int year;
    private int lastDayOfTheMonth; //new
    private int oldDay;
    private int oldMonth;
    private int oldYear;

    /**
     * Constructs a default custom date of January 1, 2000.
     */
    public CustomDate() {
        this.day = 1;
        this.month = 1;
        this.year = 2000;
       // this.lastDayOfTheMonth = 31;

    }

    /**
     * Constructs a CustomDate.
     *
     * @param day the day in the CustomDate
     * @param month the month in the CustomDate
     * @param year the year in the CustomDate
     */
    public CustomDate(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
        this.lastDayOfTheMonth = 31;
        isValidDate();
    }

    /**
     * Sets the day of the CustomDate.
     *
     * @param day the day in the CustomDate
     */
    public void setDay(int day) {
        this.oldDay = this.day;
        this.day = day;
        isValidDate();

    }

    /**
     * Sets the month of the CustomDate.
     *
     * @param month the month in the CustomDate
     */
    public void setMonth(int month) {
        this.oldMonth = this.month;
        this.month = month;
        isValidDate();

    }

    /**
     * Sets the year of the CustomDate.
     *
     * @param year the year in the CustomDate
     */
    public void setYear(int year) {
        this.oldYear = this.year;
        this.year = year;
        isValidDate();

    }

    /**
     * Returns the current day of the CustomDate provided by the private member.
     *
     * @return the day of the CustomDate
     */
    public int getDay() {
        return this.day;
    }

    /**
     * Returns the current month of the CustomDate provided by the private
     * member
     *
     * @return the month of the CustomDate
     */
    public int getMonth() {
        return this.month;
    }

    /**
     * Returns the current year of the CustomDate provided by the private
     * member.
     *
     * @return the year of the CustomDate
     */
    public int getYear() {
        return this.year;
    }

    /**
     * Returns a boolean and checks to see if the CustomDate is a valid date.
     *
     * @return false if the date is not valid
     * @throws IllegalArgumentException if user enters an invalid day, month, or
     * year
     */
    private boolean isValidDate() throws IllegalArgumentException {

        if (this.month == 9 || this.month == 4
                || this.month == 6 || this.month == 11) {
            this.lastDayOfTheMonth = 30;
            if (this.day < 1 || this.day > 30) {
                this.day = this.oldDay;
                throw new IllegalArgumentException("Invalid day: Must be between "
                        + "1 and 30 inclusive");
            }

        } else if (this.month == 2) { //month is february
            this.lastDayOfTheMonth = 28;
            if (isLeapYear()) {
                this.lastDayOfTheMonth = 29;

                if (this.day < 1 || this.day > 29) { //month is a leap year
                    this.day = this.oldDay;
                    throw new IllegalArgumentException("Invalid day: Must be between "
                            + "1 and 29 inclusive");
                }

            } else if (this.day < 1 || this.day > 28) {
                this.day = this.oldDay;
                throw new IllegalArgumentException("Invalid day: Must be between "
                        + "1 and 28 inclusive");
            }

        } else if (this.month < 1 || this.month > 12) {
            this.month = this.oldMonth;
            throw new IllegalArgumentException("Invalid month: Must be between "
                    + "1 and 12 inclusive");
        }

        if (this.day < 1 || this.day > 31) {
            this.day = this.oldDay;
            throw new IllegalArgumentException("Invalid day: Must be between "
                    + "1 and 31 inclusive");
        }

        if (this.year < 0 || this.year > 9999) {
            this.year = this.oldYear;
            throw new IllegalArgumentException("Invalid year: Must be at least "
                    + "0 and less than 9999");
        }
        return true;
    }

    /**
     * This method returns a boolean and checks to see if the current year is a
     * leap year.
     *
     * @return true if the year is a leap year
     */
    public boolean isLeapYear() {
        return ((this.year % 4 == 0 && this.year % 100 != 0)
                || (this.year % 400 == 0 && this.year % 100 == 0));
    }

    /**
     * Advances the current date by one day and makes sure the date is still
     * valid.
     */
    public void advanceOneDay() {
        this.day++;

        //checks to see if adding a day is greater than last day of the month
        if (this.day > this.lastDayOfTheMonth) {
            this.day = 1;
            if (this.month + 1 == 13) {
                this.month = 1;
                this.year++;
            } else {
                this.month++;
            }
        }

    }

    /**
     * Advances the current date by one week and makes sure the date is still
     * valid.
     */
    public void advanceOneWeek() {
        this.day += 7;

        //checks to see if adding 7 days is greater than last day of the month
        if (this.day > this.lastDayOfTheMonth) {
            this.day -= this.lastDayOfTheMonth; //how to handle this
            if (this.month + 1 == 13) {
                this.month = 1;
                this.year++;
            } else {
                this.month++;
            }
        }
    }

    /**
     * Returns the date in a string form. This method also notifies the user if
     * the date is not valid. Ex: January 1, 2000
     *
     * @return the date in a string form.
     */
    public String toString() {

        String monthString = "" + this.month;
        if (this.month < 10) {
            monthString = "0" + this.month;
        }

        String dayString = "" + (this.day);
        if (this.day < 10) {
            dayString = "0" + this.day;
        }

        String yearString = "" + (this.year);
        if (this.year < 10) {
            yearString = "000" + this.year;
        } else if (this.year < 100) {
            yearString = "00" + this.year;
        } else if (this.year < 1000) {
            yearString = "0" + this.year;
        }

        return monthString + "/" + dayString + "/" + yearString;
    }

    /**
     * Returns true if the two dates are the same.
     *
     * @param obj the CustomDate object that is passed in the argument
     * @return a boolean that determine if the two dates are the same
     */
    @Override
    public boolean equals(Object obj) {

        //checks to see if the two dates have the same toStrings
        return (obj instanceof CustomDate
                && obj.toString().equals(this.toString()));
    }

    /**
     * Compares to see if this.date if before during or after the that date that
     * is passed in the parameter
     *
     * @param obj the object date passed into the method's parameter
     * @return -1 0 or 1 if the this.date comes before during or after the
     * object CustomDate
     * @throws IllegalArgumentException if the object is null or not an
     * instance of custom date 
     */
    public int compareTo(Object obj) throws IllegalArgumentException {

        if (obj instanceof CustomDate) {
            if (this.equals(obj)) {
                return 0;
            }
            if (this.year > ((CustomDate) obj).year) {
                return 1;
            }
            if (this.month > ((CustomDate) obj).month) {
                return 1;
            }
            if (this.day > ((CustomDate) obj).day) {
                return 1;
            }
            return -1;
        }
        
        throw new IllegalArgumentException("Only two CustomDate "
                + "objects can be compared");
    }
}
