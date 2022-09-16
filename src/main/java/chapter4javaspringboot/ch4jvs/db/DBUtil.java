package chapter4javaspringboot.ch4jvs.db;

import java.util.ArrayList;

public class DBUtil {

    public static ArrayList<Task> tasks = new ArrayList<>();
    public static Long id = 6L;

    static {
        tasks.add(new Task(1L, "Complete Task 7 from Spring Boot till the end of lesson", "23.10.2022", "",  true));
        tasks.add(new Task(2L, "Clear home and buy foods", "25.10.2020", "", true));
        tasks.add(new Task(3L, "Complete all home tasks at the weekend", "28.10.2020", "",  false));
        tasks.add(new Task(4L, "Develop simple project in Spring Boot for the final", "12.12.2020", "",  false));
        tasks.add(new Task(5L, "Learn Italian Language", "01.05.2021", "",  false));
    }

    public static ArrayList<Task> getAllTasks() {
        return tasks;
    }

    public static Task getTask(Long id) {
        return tasks.stream().filter(task -> task.getId().equals(id)).findFirst().orElseThrow();
    }

    public static void addTask(Task task) {
        task.setId(id);
        tasks.add(task);
        id++;
    }

}
