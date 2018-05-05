package pl.coderslab.converter;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.convert.converter.Converter;

import org.springframework.stereotype.Component;

import pl.coderslab.model.User;
import pl.coderslab.repositories.UserRepository;

@Component
public class UserConverter implements Converter<String, User> {

    @Autowired
    private UserRepository userRepository;

    public UserConverter() {

    }

    @Override
    public User convert(String s) {

        User user = userRepository.findOne(Long.valueOf(s));

        return user;

    }
}
