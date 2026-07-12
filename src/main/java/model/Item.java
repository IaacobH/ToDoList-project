package model;

import java.time.LocalDate;

public abstract class Item {
    private String title;
    private String description;
    private LocalDate date;

    public Item(String title, String description, LocalDate date) {
        this.title = title;
        this.description=description;
        this.date=date;
    }

    public Item() {
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Item{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }

}

