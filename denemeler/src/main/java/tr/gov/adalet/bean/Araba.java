package tr.gov.adalet.bean;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component("araba1")
public class Araba implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Araba sınıfından merhaba");
	}

	@Override
	public String toString() {
		return "Araba []";
	}

}
