package tr.gov.adalet.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import tr.gov.adalet.dto.PersonelDTO;
import tr.gov.adalet.service.PersonelService;

@RestController
public class PersonelController {
	@Autowired
	private PersonelService personelService;
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/personel")
	public List<PersonelDTO> getPersoneller() {
		return personelService.getPersoneller().stream().map(p -> {
			PersonelDTO sonuc = modelMapper.map(p, PersonelDTO.class);
			sonuc.setBolumAdi(p.getBolum().getAdi());
			return sonuc;
		}).collect(Collectors.toList());
	}

	@GetMapping("/personel/{bolumAdi}")
	@SuppressWarnings("unused")
	public ResponseEntity<List<PersonelDTO>> getPersonellerByBolumAdi(
			@PathVariable String bolumAdi) {
		List<PersonelDTO> cevap = personelService.getPersonellerByBolumAdi(bolumAdi).stream()
				.map(p -> {
					PersonelDTO sonuc = modelMapper.map(p, PersonelDTO.class);
					sonuc.setBolumAdi(p.getBolum().getAdi());
					return sonuc;
				}).collect(Collectors.toList());
		if (cevap.size() == 0) {
			int a = 3 / 0;
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.ok(cevap);
	}
}
