package com.AnimeFavorite.demo.users;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserDAOService {
    Logger logger = LoggerFactory.getLogger(UserDAOService.class);
    private static List<Users> users = new ArrayList<>();

    public Optional<Users> findUser(Users user) {
        String userName = user.getUsername();
        String password = user.getPassword();
        for (Users currentUser : users) {
            if (currentUser.getUsername().equals(userName) && currentUser.getPassword().equals(password)) {
                return Optional.of(currentUser);
            }

        }
        return Optional.empty();
    }

public Boolean newUser(Users user) {
   String userName = user.getUsername();

    // Convert list of Users to a set of usernames
    Set<String> usernameSet = users.stream()
            .map(Users::getUsername)
            .collect(Collectors.toSet());
    if (!usernameSet.contains(userName)){
        users.add(user);
        return true;
    }
    return false;
}
}
