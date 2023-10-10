package br.com.nataliadiotto.todolist.user;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
//https://localhost:8080/users/
public class UserController {

    @PostMapping("/")
    public void create(@RequestBody UserModel userModel) {
        System.out.println(userModel.getUsername());
        System.out.println(userModel.getUsername());
    }

}
