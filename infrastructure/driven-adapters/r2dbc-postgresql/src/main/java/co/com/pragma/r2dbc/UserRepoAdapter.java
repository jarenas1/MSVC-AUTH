package co.com.pragma.r2dbc;

import co.com.pragma.model.user.User;
import co.com.pragma.model.user.gateways.UserRepository;
import co.com.pragma.r2dbc.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Log4j2
@RequiredArgsConstructor
@Repository
public class UserRepoAdapter implements UserRepository {

    private final IUserReactiveRepository userReactiveRepository;

    @Transactional
    @Override
    public Mono<User> save(User user) {
        log.info("Saving user: {}", user);
        return userReactiveRepository.save(UserEntity.fromDomain(user))
                .map(entity -> entity.toDomain());
    }

    @Transactional(readOnly = true)
    @Override
    public Mono<Boolean> existsByEmail(String email) {
        log.info("Checking if user exist with email: {}", email);
        return userReactiveRepository.findByEmail(email)
                .doOnNext(userEntity -> log.info("User by email"))
                .hasElement();
    }

    @Transactional(readOnly = true)
    @Override
    public Flux<User> findAll() {
        log.info("Retrieving all users");
        return userReactiveRepository.findAll()
                .map(UserEntity::toDomain);
    }

    @Transactional(readOnly = true)
    @Override
    public Mono<User> findByNumberIdentification(String numberIdentification) {
        return userReactiveRepository.findByIdentificationNumber(numberIdentification)
                .doOnNext(user -> log.info("Found user by identification number: {}", user))
                .map(UserEntity::toDomain);
    }
   }
