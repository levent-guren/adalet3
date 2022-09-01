package tr.gov.adalet.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
	public List<PersonelDTO> getPersonellerByBolumAdi(@PathVariable String bolumAdi) {
		return personelService.getPersonellerByBolumAdi(bolumAdi).stream().map(p -> {
			PersonelDTO sonuc = modelMapper.map(p, PersonelDTO.class);
			sonuc.setBolumAdi(p.getBolum().getAdi());
			return sonuc;
		}).collect(Collectors.toList());
	}
}
