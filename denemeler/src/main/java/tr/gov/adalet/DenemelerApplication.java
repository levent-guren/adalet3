package tr.gov.adalet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tr.gov.adalet.bean.Araba;

@SpringBootApplication
public class DenemelerApplication implements CommandLineRunner {
	@Autowired
	private Araba araba;

	public static void main(String[] args) {
		SpringApplication.run(DenemelerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(araba);
	}

}
