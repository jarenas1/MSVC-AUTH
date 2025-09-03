package co.com.pragma.usecase.registrationuser;

import co.com.pragma.model.user.User;
import co.com.pragma.model.user.gateways.UserRepository;
import co.com.pragma.usecase.error.InvalidDataException;
import co.com.pragma.usecase.error.UserExistException;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class RegistrationUserUseCase implements IRegistrationUserUseCase{

    private final UserRepository userRepository;

    @Override
    public Mono<User> registerUser(User user) {

        validateUser(user);

        return userRepository.existsByEmail(user.getEmail())
                .flatMap(exists -> {
                    if (exists) {
                        return Mono.error(
                                new UserExistException("User with email " + user.getEmail() + " already exists")
                        );
                    }
                    return userRepository.save(user);
                });
    }

    @Override
    public void validateUser(User user) throws IllegalArgumentException {

        if (user.getFirstName() == null || user.getFirstName().isEmpty()) {
            throw new InvalidDataException("First name cannot be null");
        }
        if (user.getLastName() == null || user.getLastName().isEmpty()) {
            throw new InvalidDataException("Last name cannot be empty");
        }
        if (user.getBirthDate() == null) {
            throw new InvalidDataException("Birth date cannot be null");
        }
        if (user.getAddress() == null || user.getAddress().isEmpty()) {
            throw new InvalidDataException("Address cannot be empty");
        }
        if (user.getPhone() == null || user.getPhone().isEmpty()) {
            throw new InvalidDataException("Phone cannot be empty");
        }
        if (user.getIdentificationNumber() == null || user.getIdentificationNumber().isEmpty()) {
            throw new InvalidDataException("Identification number cannot be empty");
        }
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new InvalidDataException("Email cannot be empty");
        }
        if (user.getBaseSalary() == null || user.getBaseSalary().doubleValue() < 0 || user.getBaseSalary().doubleValue() > 15000000) {
            throw new InvalidDataException("Base salary must be between 0 and 15,000,000");
        }
        if (!user.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$"))
            throw new InvalidDataException("Invalid email format");

    }
}
