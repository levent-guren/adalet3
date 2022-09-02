package tr.gov.adalet.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tr.gov.adalet.entity.Personel;

@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private PersonelService personelService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<Personel> personeller = personelService.getPersonellerByEmail(username);
		if (personeller.size() == 0) {
			throw new UsernameNotFoundException("Kullanıcı bulunamadı");
		} else if (personeller.size() > 1) {
			throw new UsernameNotFoundException("Birden fazla kullanıcı bulundu");
		}
		Personel personel = personeller.get(0);
		List<GrantedAuthority> roller = new ArrayList<>();
		Arrays.stream(personel.getRol().split(",")).forEach(r -> {
			roller.add(new SimpleGrantedAuthority("ROLE_" + r));
		});
		User user = new User(username, personel.getSifre(), roller);
		return user;
	}

}
