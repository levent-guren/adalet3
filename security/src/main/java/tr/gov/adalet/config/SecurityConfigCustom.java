package tr.gov.adalet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfigCustom {
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// @formatter:off
		http.csrf().and().cors().disable()
		.authorizeRequests().antMatchers("/personel").permitAll()
		.antMatchers("/bolum").hasRole("admin")
		.antMatchers("/personel/**").hasRole("user")
		.anyRequest().authenticated()
		.and().formLogin();
		// @formatter:on

		return http.build();
	}

	@Bean
	PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		System.out.println(new BCryptPasswordEncoder().encode("safak"));
	}
}
