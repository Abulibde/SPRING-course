package bg.softuni.mobiLELELE.web;

import bg.softuni.mobiLELELE.model.dto.UserLoginDTO;
import bg.softuni.mobiLELELE.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
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
    public String login(@Valid UserLoginDTO userLoginDTO,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !this.userService.login(userLoginDTO)) {
            redirectAttributes.addFlashAttribute("userModel", userLoginDTO);
            redirectAttributes.addAttribute(
                    "org.springframework.validation.BindingResult.userModel",
                    bindingResult);

            bindingResult.rejectValue(
                    "password",
                    "InvalidPasswordError",
                    "InvalidPassword.");
            return "redirect:/users/login";
        }


        userService.login(userLoginDTO);
        //System.out.println("User is logged: " + userService.login(userLoginDTO));
        return "redirect:/";
    }


}
