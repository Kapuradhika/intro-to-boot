package com.cognizant.introtoboot.user;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final List<UserModel> users = new ArrayList<>();

    UserController(){
        users.add(new UserModel("Fred","fred@gmail.com","0"));
        users.add(new UserModel("Alex","alex@gmail.com","2"));
    }

    @GetMapping("/")
    List<UserModel> list() {
        return users;
    }

    @GetMapping("/{index}")
    UserModel getUser(@PathVariable("index") final int index) {
        return users.get(index);
    }

    @GetMapping(value = {"/me/","/me/{name}"})
    UserModel getMyProperty(@PathVariable("name") final Optional<Integer> index) {
        return users.get(index.orElse(0));
    }


}
