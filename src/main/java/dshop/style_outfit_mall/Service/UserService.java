package dshop.style_outfit_mall.Service;

import dshop.style_outfit_mall.domain.User;
import dshop.style_outfit_mall.Repository.UserRepository;
import dshop.style_outfit_mall.dto.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User register(User user) {
        // 비밀번호 암호화
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public String login(LoginRequest loginRequest) {
        Optional<User> user = userRepository.findByEmail(loginRequest.getEmail());

//        if (user.isPresent() && passwordEncoder.matches(loginRequest.getPassword(), user.get().getPassword())) {
//            // JWT 생성 로직 (생략)
//            return "Generated JWT Token"; // 실제 JWT 토큰 반환
//        } else {
//            throw new RuntimeException("Invalid credentials");
//        }
        return "testing";
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(String id, User user) {
        User existingUser = getUserById(id);
        // 필요한 필드 업데이트
        existingUser.setNickname(user.getNickname());
        existingUser.setPhoneNumber(user.getPhoneNumber());
        return userRepository.save(existingUser);
    }
}
