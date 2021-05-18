package pl.coderslab.finalproject.controller;

import lombok.Data;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.finalproject.entity.*;
import pl.coderslab.finalproject.repository.*;
import pl.coderslab.finalproject.service.ReservationService;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@Controller
public class ReservationController {

    private final HourRepository hourRepository;
    private final CourtRepository courtRepository;
    private final UserRepository userRepository;
    private final ReservationRepository reservationRepository;
    private final ReservationService reservationService;

    @RequestMapping("reservation")
    public String reservation(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, Model model,
                              @AuthenticationPrincipal UserDetails userDetails) {
        String email = userDetails.getUsername();
        User user = userRepository.findFirstByEmail(email);

        //check reservation access
        if (!user.isReservationAccess()) {
            model.addAttribute("message", "Brak dostępu do rezerwacji. Skontaktuj się z administratorem.");
            return "noAccess";
        }

        if (date == null) {
            date = LocalDate.now();
        }
        model.addAttribute("date", date);
        List<Reservation> reservationsCort1 = reservationRepository.reservationByCourtID(date, 1);
        List<Reservation> reservationsCort2 = reservationRepository.reservationByCourtID(date, 2);
        List<Reservation> reservationsCort3 = reservationRepository.reservationByCourtID(date, 3);
        Map<Hour, String> mapReservationCourt1 = reservationService.mapReservation(reservationsCort1, user.getId());
        Map<Hour, String> mapReservationCourt2 = reservationService.mapReservation(reservationsCort2, user.getId());
        Map<Hour, String> mapReservationCourt3 = reservationService.mapReservation(reservationsCort3, user.getId());
        model.addAttribute("mapReservationsCort1", mapReservationCourt1);
        model.addAttribute("mapReservationsCort2", mapReservationCourt2);
        model.addAttribute("mapReservationsCort3", mapReservationCourt3);
        return "reservation";
    }

    @GetMapping("reservation/add")
    public String formAddReservation(Model model, @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        Reservation reservation = new Reservation();
        reservation.setDate(date);
        model.addAttribute("reservation", reservation);
        return "addReservation";
    }

    @PostMapping("reservation/add")
    public String addReservation(Reservation reservation, @AuthenticationPrincipal UserDetails userDetails, BindingResult result, Model model) {

        //check reservation if exist
        LocalDate date = reservation.getDate();
        int courtId = reservation.getCourt().getId();
        List<Hour> hours = reservation.getHours();
        List<Integer> hoursId = hours.stream()
                .map(Hour::getId)
                .collect(Collectors.toList());
        List<Reservation> checkHours = reservationRepository.CheckReservationByCourtID(date, courtId, hoursId);
        if (checkHours.size() > 0) {
            result.rejectValue("hours", "error.reservation", "Taka rezerwacja już istnieje. Wybierz inne godziny.");
            model.addAttribute("reservation", reservation);
            return "addReservation";
        }
        String email = userDetails.getUsername();
        User user = userRepository.findFirstByEmail(email);

        //check reservation access
        if (!user.isReservationAccess()) {
            model.addAttribute("message", "Brak dostępu do rezerwacji. Skontaktuj się z administratorem.");
            return "noAccess";
        }

        reservation.setUser(user);
        reservationRepository.save(reservation);
        return "redirect:/reservation" + "?date=" + reservation.getDate();
    }

    @GetMapping("reservation/user")
    public String userReservation(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        String email = userDetails.getUsername();
        User user = userRepository.findFirstByEmail(email);

        //check reservation access
        if (!user.isReservationAccess()) {
            model.addAttribute("message", "Brak dostępu do rezerwacji. Skontaktuj się z administratorem.");
            return "noAccess";
        }

        List<Reservation> reservations = reservationRepository.reservationByUserID(user.getId());
        model.addAttribute("reservations", reservations);
        return "userReservation";
    }

    @RequestMapping("/reservation/del/{id}")
    public String deleteReservation(@PathVariable long id) {
        Reservation reservation = reservationRepository.findFirstById(id);
        reservationRepository.delete(reservation);
        return "redirect:/reservation/user";
    }


    @ModelAttribute("hours")
    public Collection<Hour> hours() {
        return this.hourRepository.findAll();
    }

    @ModelAttribute("courts")
    public Collection<Court> courts() {
        return this.courtRepository.findAll();
    }

}
