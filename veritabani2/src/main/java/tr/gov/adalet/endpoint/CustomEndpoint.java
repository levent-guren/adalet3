package tr.gov.adalet.endpoint;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "bilgi")
public class CustomEndpoint {
	@ReadOperation
	public Map<String, Object> oku() {
		Map<String, Object> sonuc = new HashMap<>();
		sonuc.put("toplam_istek_sayisi", 18);

		Map<String, Object> istekler = new HashMap<>();
		istekler.put("personel", 10);
		istekler.put("bolum", 8);

		sonuc.put("istekler", istekler);
		return sonuc;
	}
}
