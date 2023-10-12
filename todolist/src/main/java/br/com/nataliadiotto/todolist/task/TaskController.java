package br.com.nataliadiotto.todolist.task;


import br.com.nataliadiotto.todolist.task.TaskRepository;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/tasks")
//https://localhost:8080/tasks/
public class TaskController {

    @Autowired //ask spring to manage
    private TaskRepository taskRepository;

    @PostMapping("/")
    public TaskModel create(@RequestBody TaskModel taskModel, HttpServletRequest request) {
        System.out.println("It has arrived at controller");
        var userId = request.getAttribute("userId");
        taskModel.setUserId((UUID) userId);
                var task = this.taskRepository.save(taskModel);
        return task;
    }

}
