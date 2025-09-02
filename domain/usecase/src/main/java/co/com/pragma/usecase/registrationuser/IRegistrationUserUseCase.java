package co.com.pragma.usecase.registrationuser;

import co.com.pragma.model.user.User;
import reactor.core.publisher.Mono;

public interface IRegistrationUserUseCase {
    Mono<User> registerUser(User user);
    void validateUser(User user) throws IllegalArgumentException;
}
