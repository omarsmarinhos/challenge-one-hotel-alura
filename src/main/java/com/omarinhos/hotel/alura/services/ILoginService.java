package com.omarinhos.hotel.alura.services;

import java.util.Optional;
import com.omarinhos.hotel.alura.models.User;

public interface ILoginService {

    Optional<User> getUser(User user);
}
