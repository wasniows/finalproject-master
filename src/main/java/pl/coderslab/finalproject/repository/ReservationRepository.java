package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.finalproject.entity.Reservation;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Reservation findFirstById(Long id);


    @Query(value = "SELECT * FROM reservations  WHERE user_id = :userID ORDER BY date",
            nativeQuery = true)
    List<Reservation> reservationByUserID(@Param("userID") Long userID);


    @Query(value = "SELECT * FROM reservations r JOIN courts c ON c.id = r.court_id JOIN reservations_hours rh ON r.id = rh.reservation_id\n" +
            "WHERE date = DATE_FORMAT(:date ,'%Y-%m-%d') AND court_id = :courtID ORDER BY hours_id",
            nativeQuery = true)
    List<Reservation> reservationByCourtID(@Param("date") LocalDate date, @Param("courtID") int courID);


    @Query(value = "SELECT * FROM reservations r JOIN courts c ON c.id = r.court_id JOIN reservations_hours rh ON r.id = rh.reservation_id\n" +
            "WHERE date = DATE_FORMAT(:date ,'%Y-%m-%d') AND court_id = :courtID AND hours_id IN (:hours)",
            nativeQuery = true)
    List<Reservation> CheckReservationByCourtID(@Param("date") LocalDate date, @Param("courtID") int courID, @Param("hours") List<Integer> hours);
}
