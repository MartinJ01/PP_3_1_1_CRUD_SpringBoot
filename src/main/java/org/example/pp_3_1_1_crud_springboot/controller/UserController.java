package org.example.pp_3_1_1_crud_springboot.controller;

import org.example.pp_3_1_1_crud_springboot.model.User;
import org.example.pp_3_1_1_crud_springboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showUsers(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/{id}")
    public String showUserById(@PathVariable("id") long id, ModelMap model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user";
    }

    @GetMapping("/create")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "create";
    }

    @GetMapping("/{id}/update")
    public String updateUser(@PathVariable("id") @RequestParam long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "update";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/users";
    }

    @PostMapping("/{id}/delete")
    public String removeUserById(@PathVariable("id") long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }

    @PostMapping("/{id}/update")
    public String updateUser(@PathVariable("id") long id, @ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }



}
