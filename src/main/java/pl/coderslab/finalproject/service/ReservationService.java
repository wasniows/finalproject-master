package pl.coderslab.finalproject.service;

import pl.coderslab.finalproject.entity.Hour;
import pl.coderslab.finalproject.entity.Reservation;

import java.util.List;
import java.util.Map;

public interface ReservationService {

    Map<Hour, String> mapReservation (List<Reservation> reservationList, Long userId);

}
