package tr.gov.adalet.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;
import tr.gov.adalet.bean.Bilgisayar;

@Component
@Log4j2
public class TestSenaryosu implements CommandLineRunner {
	@Autowired
	private Bilgisayar bilgisayar;

	@Override
	public void run(String... args) throws Exception {
		log.info(bilgisayar);
	}

}
