package me.kuuds.copier.api;

import me.kuuds.copier.domain.User;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.security.provider.MD5;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;
import java.util.UUID;

/**
 * User API
 *
 * @since 1.0.0
 */
@RestController
@RequestMapping("/user")
public class UserApi extends BaseApi {

    @PutMapping("")
    public User register(User user) {
        Optional<User> exists = userRepository.findUserByUsername(user.getUsername());
        if (exists.isPresent()) {
            return exists.get();
        }

        User saved = new User();
        saved.setUsername(user.getUsername());
        saved.setApiKey(createApiKey());
        return userRepository.save(saved);
    }

    private static String createApiKey() {
        return Base64.getEncoder().encodeToString(UUID.randomUUID().toString().getBytes(StandardCharsets.UTF_8));
    }

}
