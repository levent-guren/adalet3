package tr.gov.adalet;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Ornek1 {
	// @Scheduled(fixedDelay = 1000)
	// metodun son çalışmasının bitiminden itibaren 1000 ms bekler.
	public void test1() {
		System.out.println("Test1 metoduna girdi.");
		bekle(2000);
		System.out.println("Merhaba");
	}

	// @Scheduled(fixedRate = 1000)
	// her 1000 ms de bit metodu çağırır. Metodun çalışma süresinden bağımsız
	// olarak.
	public void test2() {
		System.out.println("Test2 metoduna girdi.");
		bekle(700);
		System.out.println("Merhaba");
	}

	@Scheduled(cron = "10-40/2 * * * * *")
	// saniye 10-40 arasında ise her iki saniyede bir çağırılır.
	public void test3() {
		System.out.println("Test3 metoduna girdi.");
	}

	private void bekle(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
