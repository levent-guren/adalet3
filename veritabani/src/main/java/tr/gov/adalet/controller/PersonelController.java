package tr.gov.adalet.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.minidev.json.JSONObject;
import tr.gov.adalet.entity.Personel;
import tr.gov.adalet.service.PersonelService;

@RestController
public class PersonelController {
	@Autowired
	private PersonelService personelService;

	@GetMapping("/personel")
	public List<Personel> getPersoneller() {
		return personelService.getPersoneller();
	}

	@GetMapping("/personel/{id}")
	public Personel getPersonel(@PathVariable int id) {
		return personelService.getPersonel(id).orElseThrow();
	}

	@PostMapping("/personel")
	public Personel kaydet(@RequestBody Personel personel) {
		return personelService.kaydet(personel);
	}

	@DeleteMapping("/personel/{id}")
	@Transactional
	// @Transactional annotation'ı ilk rastlandığı metodu transactional yapar.
	// Metod düzgün sonlandığında sonunda commit yapar, exception fırlatırsa
	// rolback yapar. Transactional yapılan metoddan çağırılan metodlardaki
	// transactional tanımları işe yaramaz. Hiç transaction yazılmazsa otomatik
	// yazılan repository sınıfındaki metodların her biri transactional olurlar.
	public String sil(@PathVariable int id) {
		// personelService.kaydet(null);
		personelService.personelSil(id);
		JSONObject sonuc = new JSONObject();
		sonuc.appendField("mesaj", "Personel Silinmiştir");
		return sonuc.toString();

	}

	@PostMapping("/personel/email")
	public List<Personel> getPersonellerByEmail(String email) {
		return personelService.getPersonellerByEmail(email);
	}
}
