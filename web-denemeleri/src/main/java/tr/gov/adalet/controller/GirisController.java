package tr.gov.adalet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tr.gov.adalet.bean.Personel;

@RestController
@RequestMapping("/v1")
public class GirisController {
	@GetMapping("/giris")
	public String deneme(HttpServletRequest request) {
		String adi = request.getParameter("adi");
		return "Merhaba: " + adi;
	}

	@GetMapping("/giris2")
	public String deneme2(String adi) {
		return "Merhaba: " + adi;
	}

	@GetMapping("/giris3")
	public String deneme3(String adi,
			@RequestParam(name = "soyad", required = true) String soyadi) {
		return "Merhaba: " + adi + ", " + soyadi;
	}

	@GetMapping("/giris4")
	public String deneme4(String adi, int yasi) {
		return "Merhaba: " + adi + ", yasi: " + yasi;
	}

	@GetMapping("/giris5")
	public String deneme5(@Valid Personel personel) {
		return "Merhaba: " + personel.getAdi() + ", soyadi: " + personel.getSoyadi() + ", yasi: "
				+ personel.getYasi();
	}

	@PostMapping("/giris6")
	public String deneme6(@RequestBody Personel personel) {
		return "Merhaba: " + personel.getAdi() + ", soyadi: " + personel.getSoyadi() + ", yasi: "
				+ personel.getYasi();
	}

	@PostMapping("/giris7")
	public Personel deneme7(@RequestBody Personel personel) {
		return personel;
	}
}
