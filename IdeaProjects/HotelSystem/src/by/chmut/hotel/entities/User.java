package by.chmut.hotel.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class User {
    private int id;
    private String login;
    private String password;
    private String name;
    private String lastName;
    private String role;
    private String email;
    private String telephone;
    private String country;
    private String city;
    private String address;
    private String zip;

    public User(String login, String password, String name, String lastName,
                String role, String email, String telephone, String country, String city, String address, String zip) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.role = role;
        this.email = email;
        this.telephone = telephone;
        this.country = country;
        this.city = city;
        this.address = address;
        this.zip = zip;
    }
}

