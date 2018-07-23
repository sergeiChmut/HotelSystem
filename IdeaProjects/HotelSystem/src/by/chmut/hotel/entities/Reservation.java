package by.chmut.hotel.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Reservation {
    private int id;
    private int userId;
    private int roomId;
    private LocalDate date;
//    private LocalDate checkIn;
//    private LocalDate checkOut;

}
