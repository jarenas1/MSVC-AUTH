package co.com.pragma.usecase.userbyidentification;

import co.com.pragma.model.user.User;
import co.com.pragma.model.user.gateways.UserRepository;
import co.com.pragma.usecase.error.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UserByIdentificationUseCase implements IUserByIdentificationUseCase {

    private final UserRepository userRepository;

    @Override
    public Mono<User> findByIdentification(String numberIdentification) {
        return userRepository.findByNumberIdentification(numberIdentification)
                .switchIfEmpty(Mono.error(new UserNotFoundException("User not found with identification number: " + numberIdentification)));
    }
}
