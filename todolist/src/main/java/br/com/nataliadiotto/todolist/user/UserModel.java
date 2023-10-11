package br.com.nataliadiotto.todolist.user;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class UserModel {

    private String username;
    private String name;
    private String password;


}
