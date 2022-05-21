package me.matamor.backend.services.user;

import lombok.RequiredArgsConstructor;
import me.matamor.backend.models.user.User;
import me.matamor.backend.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public User register(User user) {
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        return this.userRepository.save(user);
    }

    public User findByUsername(String email) {
        return this.userRepository.findFirstByUsername(email);
    }

    public User findByEmail(String email) {
        return this.userRepository.findFirstByEmail(email);
    }

    public User findByUsernameOrEmail(String username, String email) {
        return this.userRepository.findByUsernameOrEmail(username, email);
    }
}
