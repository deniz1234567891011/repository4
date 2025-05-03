package az.developia.az.developia.Servicee;

import az.developia.az.developia.info.AuthenticationEntity;
import az.developia.az.developia.info.UserEntity;
import az.developia.az.developia.repository.AuthenticationRepository;
import az.developia.az.developia.repository.UserRepository;
import az.developia.az.developia.exception.MyException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationRepository authenticationRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void register(UserEntity user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new MyException("This username already exists!");
        }

        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new MyException("Password cannot be null or empty!");
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
        userEntity.setEnabled(true);

        userRepository.save(userEntity);

        AuthenticationEntity authenticationEntity = new AuthenticationEntity();
        authenticationEntity.setUsername(userEntity.getUsername());
        authenticationEntity.setAuthority("ROLE_USER");

        authenticationRepository.save(authenticationEntity);
    }
}
