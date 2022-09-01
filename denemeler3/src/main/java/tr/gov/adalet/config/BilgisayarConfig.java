package tr.gov.adalet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tr.gov.adalet.bean.Bilgisayar;

@Configuration
public class BilgisayarConfig {
	@Bean("bilgisayar1")
	Bilgisayar bilgisayarOlustur() {
		Bilgisayar bilgisayar = new Bilgisayar();
		bilgisayar.setMarka("MONSTER");
		bilgisayar.setRam(32);
		return bilgisayar;
	}
}
