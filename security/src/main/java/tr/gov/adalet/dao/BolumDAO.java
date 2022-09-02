package tr.gov.adalet.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tr.gov.adalet.entity.Bolum;
import tr.gov.adalet.repository.BolumRepository;

@Component
public class BolumDAO {
	@Autowired
	private BolumRepository bolumRepository;

	public List<Bolum> getBolumler() {
		return bolumRepository.findAll();
	}
}
