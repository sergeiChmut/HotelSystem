package by.chmut.hotel.services;

import by.chmut.hotel.entities.User;

public interface UserService {

    public User getUserByLogin(String login);
    public User addUser(String login, String password, String name, String lastName, String email, String phone, String country,
                        String city, String address, String zip);
}
