package bg.softuni.mobiLELELE.web;

import bg.softuni.mobiLELELE.model.dto.UserLoginDTO;
import bg.softuni.mobiLELELE.model.dto.UserRegisterDTO;
import bg.softuni.mobiLELELE.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserLoginController {

    private final UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "auth-login";
    }

    @GetMapping("/logout")
    public String logout() {
        userService.logout();
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(UserLoginDTO userLoginDTO) {
        userService.login(userLoginDTO);
        //System.out.println("User is logged: " + userService.login(userLoginDTO));
        return "redirect:/";
    }

    @GetMapping("/register")
    public String register() {

        return "auth-register";
    }

    @PostMapping("/register")
    public String register(UserRegisterDTO userRegisterDTO){
        return "redirect:/";
    }
}
