package project.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // 스프링의 설정 클래스임을 나타냄
@EnableWebSecurity // 스프링 시큐리티의 웹 보안을 활성화한다.
public class SecurityConfig  {
//    화이트리스트 경로를 정의하는 문자열 배열
//    이 경로들은 인증 없이 접근할 수 있도록 허용
    private static final String[] WHITE_LIST = {
//            /user 와 그 하위 경로에 대한 모든 요청을 허용
            "/users/**",
//            모든 경로에 대한 요청을 허용
            "/**"
    };

//    매서드가 스프링 컨텍스트에서 관리되는 빈을 생성
    @Bean
    protected SecurityFilterChain config(HttpSecurity http) throws Exception {
        http.csrf().disable(); // CSRF(Cross-Site Request Forgery) 보호를 비활성화
        http.headers().frameOptions().disable(); // X-Frame-Options 헤더를 비활성화합니다. ,  웹 애플리케이션이 iframe으로 다른 웹 페이지에 포함될 수 있도록 허용합니다
        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers(WHITE_LIST).permitAll()); // http.authorizeHttpRequests -> 요청에 대한 인가 규칙을 설정
//        authorize -> authorize.requestMatchers(WHITE_LIST).permitAll() -> WHITE_LIST 배열에 정의된 경로에 대한 모든 요청을 허용합니다. 이 경로들은 인증 없이 접근할 수 있습니다.
        return http.build();
    }
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
//                        .requestMatchers("/", "/login**", "/error**").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .oauth2Login(oauth2 -> oauth2
//                        .defaultSuccessUrl("/user", true)
//                )
//                .logout(logout -> logout
//                        .logoutSuccessUrl("/")
//                        .permitAll()
//                );
//
//        return http.build();
//    }
}
