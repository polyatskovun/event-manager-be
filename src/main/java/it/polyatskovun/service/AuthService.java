package it.polyatskovun.service;

import it.polyatskovun.config.JwtProvider;
import it.polyatskovun.dto.LoginRequest;
import it.polyatskovun.entity.UserEntity;
import it.polyatskovun.mappers.UserMapper;
import it.polyatskovun.repository.UserRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;
    private final UserMapper mapper;


    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtProvider jwtProvider, UserMapper mapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
        this.mapper = mapper;
    }

    public void register(LoginRequest loginRequestDto) {
        UserEntity user = new UserEntity();
        user.setUsername(loginRequestDto.getUsername());
        user.setEmail(loginRequestDto.getEmail());
        user.setPassword(passwordEncoder.encode(loginRequestDto.getPassword()));
        userRepository.save(user);
    }

    public String login(LoginRequest loginRequest) {
        UserEntity user = userRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));


        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Invalid username or password");
        }

        return jwtProvider.generateToken(user.getUsername());
    }
}
