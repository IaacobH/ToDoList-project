package model;

import java.time.LocalDate;

public class Task extends Item {
    private boolean completed;

    public Task(String title, String desc, LocalDate date) {
        super(title, desc, date);
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
                "title='" + super.getTitle() + '\'' +
                ", desc='" + super.getDescription() + '\'' +
                ", date=" + super.getDate() +
                ", completed=" + completed +
                '}';
    }
}
