package bg.softuni.mobiLELELE.web;

import bg.softuni.mobiLELELE.model.dto.UserRegisterDTO;
import bg.softuni.mobiLELELE.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserRegistrationController {

    private final UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("userModel")
    public UserRegisterDTO initUserModel() {
        return new UserRegisterDTO();
    }

    @GetMapping("/register")
    public String register() {
        return "auth-register";
    }


    @PostMapping("/register")
    public String register(@Valid UserRegisterDTO userModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userModel", userModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.userModel", bindingResult);


            return "redirect:/users/register";
        }

        this.userService.registerAndLogin(userModel);

        return "redirect:/";
    }


}
