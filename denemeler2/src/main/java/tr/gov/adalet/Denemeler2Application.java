package tr.gov.adalet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tr.gov.adalet.bean.Araba;

@SpringBootApplication
public class Denemeler2Application implements CommandLineRunner {
	@Autowired
	@Qualifier("kia")
	private Araba araba;

	@Autowired
	private List<Araba> arabalar;

	public static void main(String[] args) {
		SpringApplication.run(Denemeler2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(araba);
		System.out.println(arabalar);
	}

}
