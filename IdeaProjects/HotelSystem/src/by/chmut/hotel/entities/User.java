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
    private String lastname;
    private String email;
    private String country;
    private String address;
    private String city;
    private String zip;
    private String telephone;
}
