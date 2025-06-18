package com.tareas.Tareas.security;

import com.tareas.Tareas.repository.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/login", "/css/**", "/js/**", "/usuarios/crear", "/usuarios/guardar").permitAll() // Permitir acceso a recursos estáticos y login
                .anyRequest().authenticated() // Requiere autenticación para cualquier otra solicitud
            )
            .formLogin(form -> form
                .loginPage("/login").permitAll() // Página de inicio de sesión personalizada
                 // Permitir acceso a la página de inicio de sesión
                .defaultSuccessUrl("/", true) // Redirigir a /home después del inicio de sesión exitoso
            )
            .logout(logout -> logout
                .logoutUrl("/logout") // URL para cerrar sesión
                .logoutSuccessUrl("/login?logout").permitAll() // Redirigir a /login con parámetro de cierre de sesión
            ); // Permitir cierre de sesión

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(UsuarioRepository usuarioRepository) {
        return username -> usuarioRepository.findByNombre(username)
                .map(user -> User.withUsername(user.getNombre())
                        .password(user.getPassword()) // Usar {noop} para contraseñas sin codificación
                        .roles("USER").build())
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
