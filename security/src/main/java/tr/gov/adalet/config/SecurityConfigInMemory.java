package tr.gov.adalet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

// @Configuration
public class SecurityConfigInMemory {
	@Bean
	UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager mgr = new InMemoryUserDetailsManager();
		mgr.createUser(User.builder().username("levent")
				// sifre: 123
				.password("$2a$10$5A06CbZ.oomoBs4VNVV2f.HkiJH8jE.kSMjv5ZUQ2g8eXy91PVrre")
				.roles("admin", "user").build());
		mgr.createUser(User.builder().username("basak").
		// sifre: safak
				password("$2a$10$WKeW8dQj9348jJXy5rbq5u.y4Dcaab.YIj/PNkYG8M86yTc7y39F2")
				.roles("user").build());
		return mgr;
	}

	@Bean
	PasswordEncoder getPasswordEncoder() {
		// return NoOpPasswordEncoder.getInstance();
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		System.out.println(new BCryptPasswordEncoder().encode("safak"));
	}
}
