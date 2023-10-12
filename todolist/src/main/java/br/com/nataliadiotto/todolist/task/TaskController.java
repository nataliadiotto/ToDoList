package br.com.nataliadiotto.todolist.task;


import br.com.nataliadiotto.todolist.task.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
//https://localhost:8080/tasks/
public class TaskController {

    @Autowired //ask spring to manage
    private TaskRepository taskRepository;

    @PostMapping("/")
    public TaskModel create(@RequestBody TaskModel taskModel) {
        var task = this.taskRepository.save(taskModel);
        return task;
    }

}
