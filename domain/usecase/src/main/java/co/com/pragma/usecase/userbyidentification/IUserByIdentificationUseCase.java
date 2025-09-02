package co.com.pragma.usecase.userbyidentification;

import co.com.pragma.model.user.User;
import reactor.core.publisher.Mono;

public interface IUserByIdentificationUseCase {
    Mono<User> findByIdentification(String numberIdentification);
}
