package com.omarinhos.hotel.alura.services;

import com.omarinhos.hotel.alura.models.User;

import java.util.Optional;

public class LoginServicePredeterminedImpl implements ILoginService{

    @Override
    public Optional<User> getUser(User user) {
        if (user.getUser().equals("admin") && user.getPassword().equals("12345")) {
            return Optional.of(user);
        }
        return Optional.empty();
    }
}
