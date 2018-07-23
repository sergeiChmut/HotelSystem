package by.chmut.hotel.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Room implements Serializable {
    private int id;
    private int roomNumber;
    private String type;
    private int bedType;
    private double price;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private String description;

    public Room(int roomNumber, String type, int bedType, double price, LocalDate checkIn, LocalDate checkOut, String description) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.bedType = bedType;
        this.price = price;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.description = description;
    }
}