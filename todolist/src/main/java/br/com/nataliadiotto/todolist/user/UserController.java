package br.com.nataliadiotto.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
//https://localhost:8080/users/
public class UserController {

    @Autowired //ask spring to manage
    private UserRepository userRepository;

    @PostMapping("/")
    public UserModel create(@RequestBody UserModel userModel) {
        var userCreated = this.userRepository.save(userModel);
        return userCreated;
    }

}
