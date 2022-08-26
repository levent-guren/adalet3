package tr.gov.adalet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import tr.gov.adalet.bean.Bilgisayar;

@SpringBootApplication
@ImportResource("classpath:beans.xml")
public class IlkprojeApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(IlkprojeApplication.class,
				args);
		Bilgisayar bilgisayar = (Bilgisayar) context.getBean("bilgisayar");
		System.out.println(bilgisayar);

		Bilgisayar bilgisayar2 = (Bilgisayar) context.getBean("bilgisayar2");
		System.out.println(bilgisayar2);

		System.out.println(context.getBean("bilgisayar3"));
		System.out.println(context.getBean("bilgisayar4"));

	}

}
