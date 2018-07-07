package by.chmut.hotel.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Room {
    private int roomNumber;
    private String type;
    private int bedType;
    private double price;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private String description;

}