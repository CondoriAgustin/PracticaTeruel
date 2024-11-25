package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {

    private List<String> messages = new ArrayList<>();

    // Página principal de login
    @GetMapping("/")
    public String loginPage(Model model) {
        model.addAttribute("messages", messages); // Pasamos los mensajes al template
        return "login"; // Renderiza el archivo login.html
    }

    // Procesa el formulario de login
    @PostMapping("/login")
    public String login(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            Model model) {
        String message;
        if ("123ABC".equals(password)) {
            message = email + " se conectó CORRECTAMENTE";
        } else {
            message = email + " se conectó INCORRECTAMENTE";
        }
        messages.add(message); // Guarda el mensaje en la lista
        model.addAttribute("messages", messages); // Actualiza la lista de mensajes en el template
        return "login"; // Renderiza nuevamente la página login.html
    }
}