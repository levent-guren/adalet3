package tr.gov.adalet.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tr.gov.adalet.dto.BolumDTO;
import tr.gov.adalet.service.BolumService;

@RestController
public class BolumController {
	@Autowired
	private BolumService bolumService;
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/bolum")
	public List<BolumDTO> getBolumler() {
		return bolumService.getBolumler().stream().map(b -> modelMapper.map(b, BolumDTO.class))
				.collect(Collectors.toList());
	}
}
