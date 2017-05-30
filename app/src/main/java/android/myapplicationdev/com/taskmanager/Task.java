package android.myapplicationdev.com.taskmanager;

import java.io.Serializable;

/**
 * Created by 15039836 on 30/5/2017.
 */

public class Task implements Serializable{
    private int id;
    private String task;
    private String description;
    private int time;

    public Task(int id, String task, String description, int time) {
        this.id = id;
        this.task = task;
        this.description = description;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public String getDescription() {
        return description;
    }

    public int getTime() {
        return time;
    }
}
