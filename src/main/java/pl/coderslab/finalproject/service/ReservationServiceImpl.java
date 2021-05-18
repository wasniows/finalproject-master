package pl.coderslab.finalproject.service;

import org.springframework.stereotype.Service;
import pl.coderslab.finalproject.entity.Hour;
import pl.coderslab.finalproject.entity.Reservation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Override
    public Map<Hour, String> mapReservation(List<Reservation> reservationList, Long userId) {

        Map<Hour, String> map = new HashMap<>();

        for (Reservation reservation : reservationList) {
            for (Hour hour : reservation.getHours())
                if (reservation.getUser().getId().equals(userId)) {
                    map.put(hour, "bg-success");
                } else {
                    map.put(hour, "bg-danger");
                }
        }

        TreeMap<Hour, String> sorted = new TreeMap<>(map);

        return sorted;
    }
}
