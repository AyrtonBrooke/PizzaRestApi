package net.pizza.PizzaRESTAPIs.auth;

import net.pizza.PizzaRESTAPIs.admin.Role;
import net.pizza.PizzaRESTAPIs.config.JwtService;
import net.pizza.PizzaRESTAPIs.token.Token;
import net.pizza.PizzaRESTAPIs.token.TokenRepository;
import net.pizza.PizzaRESTAPIs.token.TokenType;
import net.pizza.PizzaRESTAPIs.admin.Admin;
import net.pizza.PizzaRESTAPIs.admin.AdminRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AdminRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenRepository tokenRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request) {
        var admin = Admin.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ADMIN)
                .build();
        repository.save(admin);
        var savedAdmin = repository.save(admin);
        var jwtToken = jwtService.generateToken(admin);
        saveAdminToken(savedAdmin, jwtToken);
        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthResponse authenticate(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var admin = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(admin);
        revokeAllAdminTokens(admin);
        saveAdminToken(admin, jwtToken);
        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }

    private void saveAdminToken(Admin admin, String jwtToken) {
        var token = Token.builder()
                .admin(admin)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    private void revokeAllAdminTokens(Admin admin) {
        var validAdminTokens = tokenRepository.findAllValidTokensByAdmin(admin.getId());
        if (validAdminTokens.isEmpty())
            return;
        validAdminTokens.forEach(t -> {
            t.setExpired(true);
            t.setRevoked(true);
        });
        tokenRepository.saveAll(validAdminTokens);
    }
}