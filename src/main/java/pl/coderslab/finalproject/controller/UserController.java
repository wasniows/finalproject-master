package pl.coderslab.finalproject.controller;

import lombok.Data;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.finalproject.entity.Authority;
import pl.coderslab.finalproject.entity.User;
import pl.coderslab.finalproject.repository.AuthorityRepository;
import pl.coderslab.finalproject.repository.UserRepository;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@Data
@Controller
public class UserController {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    @GetMapping("user")
    public String getUser(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        String email = userDetails.getUsername();
        User user = userRepository.findFirstByEmail(email);
        model.addAttribute("user", user);
        return "user";
    }

    @PostMapping("user")
    public String updateUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {

        //check for errors
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "user";
        }
        userRepository.save(user);
        return "redirect:user";
    }

    @RequestMapping("checkadmin")
    public String checkAdmin(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        String email = userDetails.getUsername();
        List<Authority> authorities = authorityRepository.authoritiesByEmail(email);
        for (Authority authority : authorities) {
            if (authority.getAuthority().equals("ROLE_ADMIN")) {
                return "redirect:/admin";
            }
        }
        model.addAttribute("message", "Brak uprawnień do panelu administratora.");
        return "noAccess";
    }

    @RequestMapping("admin")
    public String adminPanel(@AuthenticationPrincipal UserDetails userDetails) {
        String email = userDetails.getUsername();
        List<Authority> authorities = authorityRepository.authoritiesByEmail(email);
        for (Authority authority : authorities) {
            if (authority.getAuthority().equals("ROLE_ADMIN")) {
                return "adminPanel";
            }
        }
        return "noAccess";
    }

    @RequestMapping("admin/useraccess/{id}")
    public String userAccess(@PathVariable long id) {
        User user = userRepository.findFirstById(id);
        Boolean reservationAccess = user.isReservationAccess();
        if (reservationAccess) {
            reservationAccess = false;
        } else {
            reservationAccess = true;
        }
        user.setReservationAccess(reservationAccess);
        userRepository.save(user);
        return "redirect:/admin";
    }

    @ModelAttribute("users")
    public Collection<User> users() {
        return this.userRepository.findAll();
    }
}
