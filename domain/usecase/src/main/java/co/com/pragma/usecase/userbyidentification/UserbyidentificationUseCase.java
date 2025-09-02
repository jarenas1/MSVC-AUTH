package co.com.pragma.usecase.userbyidentification;

import co.com.pragma.model.user.User;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UserbyidentificationUseCase implements IUserByIdentificationUseCase {
    @Override
    public Mono<User> findByIdentification(String numberIdentification) {
        return null;
    }
}
