package model;

import java.time.LocalDate;

public class Birthday extends Item{
    private String birthdayPerson;
    private String phoneNumber;

    public Birthday() {
    }

    public Birthday(String description, LocalDate date, String birthdayPerson, String phoneNumber) {
        super("Cumpleanios de: "+birthdayPerson, description, date);
        this.birthdayPerson = birthdayPerson;
        this.phoneNumber = phoneNumber;
    }

    public void sendGreeting() {
        System.out.println("Feliz cumpleaños " + birthdayPerson);
    }

    public String getBirthdayPerson() {
        return birthdayPerson;
    }

    public void setBirthdayPerson(String birthdayPerson) {
        this.birthdayPerson = birthdayPerson;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Birthday{" +
                "birthdayPerson='" + birthdayPerson + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
