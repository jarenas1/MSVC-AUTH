package co.com.pragma.usecase.registrationuser;

import co.com.pragma.model.user.User;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class RegistrationuserUseCase implements IRegistrationUserUseCase{

    //INYECCION DE REPOSITORIO INTERFACE
    @Override
    public Mono<User> registerUser(User user) {
        return null;
    }

    @Override
    public void validateUser(User user) throws IllegalArgumentException {

    }
}
