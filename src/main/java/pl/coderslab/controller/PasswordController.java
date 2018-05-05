package pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.converter.UserConverter;
import pl.coderslab.model.Password;
import pl.coderslab.model.User;
import pl.coderslab.repositories.PasswordRepository;
import pl.coderslab.repositories.UserRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PasswordController {

    @Autowired
    PasswordRepository passwordRepository;

    @Autowired
    UserRepository userRepository;
    @GetMapping("/pass")
    String passForm(Model model) {
        model.addAttribute("password", new Password());

        return "form/pass";
    }

    @PostMapping("/pass")
    String pass(@Valid Password password, BindingResult result) {

        if (result.hasErrors()) {
            return "form/pass";
        } else {
            passwordRepository.save(password);

            return "redirect:/";
        }
    }

    @ModelAttribute("users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Autowired
    UserConverter userConverter;

    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(userConverter);
    }

}
