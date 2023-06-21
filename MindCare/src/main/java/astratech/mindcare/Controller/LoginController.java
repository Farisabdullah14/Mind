package astratech.mindcare.Controller;

import astratech.mindcare.Model.User;
import astratech.mindcare.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }


    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {

        User user = userService.authenticateUser(username, password);
        model.addAttribute("user", user);
        if (user != null) {
            model.addAttribute("user", user);
            // Autentikasi sukses
            // Redirect ke halaman berdasarkan peran (role) pengguna
            if ("DKA".equals(user.getRole())) {
                return "redirect:/HomeDKA";
            } else if ("PIC Kemahasiswaan".equals(user.getRole())) {
                return "redirect:/HomePIC";
            } else if ("Wali Akademik".equals(user.getRole())) {
                return "redirect:/HomeWali";
            }

        }

        // Autentikasi gagal atau peran pengguna tidak valid
        // Tampilkan pesan kesalahan
        model.addAttribute("error", true);
        return "login";
    }

    @GetMapping("/HomeDKA")
    public String showDKABoard(Model model){

        return "HomeDKA";
    }

    @GetMapping("/HomePIC")
    public String showPICBoard(Model model){

        return "HomePIC";
    }

    @GetMapping("/HomeWali")
    public String showWaliBoard(Model model){
        return "HomeWali";
    }

}
