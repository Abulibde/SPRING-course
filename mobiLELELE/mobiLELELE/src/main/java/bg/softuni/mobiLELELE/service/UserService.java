package bg.softuni.mobiLELELE.service;

import bg.softuni.mobiLELELE.model.dto.UserLoginDTO;
import bg.softuni.mobiLELELE.model.dto.UserRegisterDTO;
import bg.softuni.mobiLELELE.model.entity.UserEntity;

import bg.softuni.mobiLELELE.model.mapper.UserMapper;
import bg.softuni.mobiLELELE.repository.UserRepository;
import bg.softuni.mobiLELELE.user.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;
    private CurrentUser currentUser;
    private PasswordEncoder passwordEncoder;
    private UserMapper userMapper;


    public UserService(UserRepository userRepository,
                       CurrentUser currentUser,
                       PasswordEncoder passwordEncoder, UserMapper userMapper
                       ) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;

        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    public void registerAndLogin(UserRegisterDTO userRegisterDTO) {
        boolean active = true;
        UserEntity newUser = new UserEntity();
        newUser.setActive(active);
        newUser.setEmail(userRegisterDTO.getEmail());
        newUser.setFirstName(userRegisterDTO.getFirstName());
        newUser.setLastName(userRegisterDTO.getLastName());
        newUser.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));

        newUser = userRepository.save(newUser);

        login(newUser);
    }

    public boolean login(UserLoginDTO loginDTO) {
        Optional<UserEntity> userOpt = userRepository.findByEmail(loginDTO.getUsername());

        if (userOpt.isEmpty()) {
            LOGGER.debug("User with name [{}] not found", loginDTO.getUsername());
            return false;
        }

        var rawPassword = loginDTO.getPassword();
        var encodedPassword = userOpt.get().getPassword();

        boolean success = passwordEncoder
                .matches(rawPassword, encodedPassword);

        if (success) {
            //todo
            login(userOpt.get());
        } else {
            //todo
            logout();
        }

        return success;
    }

    private void login(UserEntity userEntity) {
        currentUser.setLoggedIn(true);
        currentUser.setName(userEntity.getFirstName() + " " + userEntity.getLastName());
    }

    public void logout() {
        currentUser.clear();
    }
}
