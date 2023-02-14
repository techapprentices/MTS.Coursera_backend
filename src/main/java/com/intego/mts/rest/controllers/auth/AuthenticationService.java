package com.intego.mts.rest.controllers.auth;

import com.intego.mts.models.Role;
import com.intego.mts.models.User;
import com.intego.mts.models.enumeration.ERole;
import com.intego.mts.repositories.UserRepository;
import com.intego.mts.security.service.JwtService;
import com.intego.mts.security.service.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {
        Set<Role> roles = new HashSet<>();
        Role role = Role.builder().title(ERole.ROLE_READER).build();
        roles.add(role);
        User user = User.builder()
                .password(request.getPassword())
                .username(request.getUsername())
                .roles(roles)
                .build();
        UserDetailsImpl userDetails = UserDetailsImpl.build(user);
        repository.save(user);
        var jwtToken = jwtService.generateToken(userDetails);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        var user = repository.findByUsername(request.getUsername()).orElseThrow();
        var jwtToken = jwtService.generateToken(UserDetailsImpl.build(user));
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
