package co.com.pragma.api.mapper;

import co.com.pragma.api.dto.UserRegistrationReq;
import co.com.pragma.api.dto.UserRegistrationRes;
import co.com.pragma.model.user.User;

public class UserDtoMapper {
    public static User toUser(UserRegistrationReq request) {
        return new User(
                null,
                request.firstName(),
                request.lastName(),
                request.birthDate(),
                request.address(),
                request.phone(),
                request.email(),
                request.identificationNumber(),
                request.baseSalary()
        );
    }

    public static UserRegistrationRes toUserRegistrationResponse(User user) {
        return new UserRegistrationRes(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getBirthDate(),
                user.getAddress(),
                user.getPhone(),
                user.getIdentificationNumber(),
                user.getEmail(),
                user.getBaseSalary()
        );
    }
}
