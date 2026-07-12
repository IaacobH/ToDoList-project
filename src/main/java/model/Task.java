package model;

import java.time.LocalDate;

public class Task extends Item {
    private boolean completed;

    public Task(String title, String description, LocalDate date) {
        super(title, description, date);
        this.completed = false;
    }

    public Task() {
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + getTitle() + '\'' +
                ", desc='" + getDescription() + '\'' +
                ", date=" + getDate() +
                ", completed=" + completed +
                '}';
    }
}
