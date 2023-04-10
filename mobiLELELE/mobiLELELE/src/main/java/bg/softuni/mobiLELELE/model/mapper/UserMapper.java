package bg.softuni.mobiLELELE.model.mapper;

import bg.softuni.mobiLELELE.model.dto.UserRegisterDTO;
import bg.softuni.mobiLELELE.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.Bean;


@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "active", constant = "true")
    UserEntity userDtoToUserEntity(UserRegisterDTO registerDTO);

}
