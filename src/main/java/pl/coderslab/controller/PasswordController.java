package pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.converter.UserConverter;
import pl.coderslab.model.Messages;
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

    @GetMapping("/pass/{id}")
    String passForm(@PathVariable long id, Model model) {
        model.addAttribute("password", new Password());

        return "form/pass";
    }




    @PostMapping("/pass/{id}")
    String pass(@PathVariable long id, Model model, @Valid Password password, BindingResult result) {

        if (result.hasErrors()) {
            return "form/pass";
        } else {

            password.setId(0);
            password.setUser(userRepository.findOne(id));
            passwordRepository.save(password);

            Messages messages = new Messages(password);

            List<String> list = messages.createList();
            List<String> list2 = messages.createListPositive();
            model.addAttribute("messages", list);
            model.addAttribute("messages2",list2);
            model.addAttribute("user_id", id);




            return "form/pass";
        }
    }

    @ModelAttribute("users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    //
//    @ModelAttribute("messages")
//    public List<String> messages() {
//
//        List<String> list = new ArrayList<>();
//
//        list.add("cos");
//        list.add("costam");
//
//        return list;
//    }



    String deleteLink = "fin";

    @GetMapping("/fin/{id}")
    public String allPasswords(@PathVariable long id, Model model) {
        List<Password> passwords = passwordRepository.findAllByUser(userRepository.getOne(id));
        model.addAttribute("passwords", passwords);
        model.addAttribute("user_id", id);

        return deleteLink;
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id, Model model) {

        String link = "deleted";

        try {
            userRepository.delete(id);
        }
        catch (EmptyResultDataAccessException e){
            deleteLink = "/";
        }
        return link;
    }


    @Autowired
    UserConverter userConverter;

    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(userConverter);
    }

}
