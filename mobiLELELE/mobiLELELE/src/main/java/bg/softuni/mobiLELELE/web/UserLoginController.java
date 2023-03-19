package bg.softuni.mobiLELELE.web;

import bg.softuni.mobiLELELE.model.dto.UserLoginDTO;
import bg.softuni.mobiLELELE.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserLoginController {

    private UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String login() {
        return "auth-login";
    }

    @GetMapping("/user/logout")
    public String logout() {
        userService.logout();
        return "redirect:/";
    }

    @PostMapping("/user/login")
    public String login(UserLoginDTO userLoginDTO) {
        userService.login(userLoginDTO);
        //System.out.println("User is logged: " + userService.login(userLoginDTO));
        return "redirect:/";
    }
}
