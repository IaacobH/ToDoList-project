package model;

public class Task {
    private String title;
    private String desc;
    private boolean completed;

    public Task(String title, String desc) {
        this.title = title;
        this.desc = desc;
        this.completed = false;
    }

    public Task() {
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public void setCompleted() {
        this.completed = !completed;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", completed=" + completed +
                '}';
    }
}
