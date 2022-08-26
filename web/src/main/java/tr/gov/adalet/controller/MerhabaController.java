package tr.gov.adalet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MerhabaController {
	// @RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping("/")
	public String merhaba() {
		System.out.println("Merhaba çağırıldı");
		return "Merhaba";
	}
}
