package tr.gov.adalet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@Log4j2
public class Veritabani2Application implements CommandLineRunner {
	@SuppressWarnings("el-syntax")
	@Value("${server.port:port bulunamadı}")
	private String port;

	public static void main(String[] args) {
		SpringApplication.run(Veritabani2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Server port: " + port);
	}

}
