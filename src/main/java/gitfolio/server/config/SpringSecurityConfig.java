package gitfolio.server.config;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SpringSecurityConfig {
    private static final String[] AUTH_WHITELIST = {
            "/"
    };

    @Bean
    public SecurityFilterChain config(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize
                .dispatcherTypeMatchers(DispatcherType.ERROR, DispatcherType.ASYNC).permitAll()
                .requestMatchers(AUTH_WHITELIST)
                .permitAll()
                .anyRequest()
                .authenticated());

        return http.build();
    }

    /*
    securityFilterChain: Spring Security에서 사용하는 필터 체인입니다.
    http.authorizeHttpRequests(authorize -> authorize: HTTP 요청에 대한 인증을 설정합니다.
    .dispatcherTypeMatchers(DispatcherType.ERROR, DispatcherType.ASYNC).permitAll(): ERROR와 ASYNC DispatcherType (<- http요청 Enum) 에 대한 요청을 허용합니다.
    .requestMatchers(AUTH_WHITELIST).permitAll(): AUTH_WHITELIST에 등록된 요청을 허용합니다.
    .anyRequest().authenticated(): 그 외의 모든 요청은 인증을 필요로 합니다.
    return http.build(): 설정한 보안 정책을 적용한 필터 체인을 반환합니다.
     */
}