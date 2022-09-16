package chapter4javaspringboot.ch4jvs.controller;

import chapter4javaspringboot.ch4jvs.db.DBUtil;
import chapter4javaspringboot.ch4jvs.db.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String indexPage(Model model) {
        ArrayList<Task> tasks = DBUtil.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "index";
    }

    @GetMapping(value = "/details")
    public String detailsPage(@RequestParam(name = "id") Long id, Model model) {
        Task task = DBUtil.getTask(id);
        model.addAttribute("tasks", task);
        return "details";
    }

    @PostMapping(value = "/addtasks")
    public String addingTask(@RequestParam(name = "task_name") String name,
                             @RequestParam(name = "task_description") String description,
                             @RequestParam(name = "task_deadlineDate") String deadlineDate) {

        Task task = new Task();
        task.setName(name);
        task.setDescription(description);
//      task.setCompleted(false);
        task.setDeadlineDate(deadlineDate);
        DBUtil.addTask(task);
        return "redirect:/";
    }

//    @PostMapping(value = "/")
//    public String updateTask() {
//
//    }

}
