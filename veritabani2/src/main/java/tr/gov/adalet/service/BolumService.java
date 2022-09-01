package tr.gov.adalet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.gov.adalet.dao.BolumDAO;
import tr.gov.adalet.entity.Bolum;

@Service
public class BolumService {
	@Autowired
	private BolumDAO bolumDAO;

	public List<Bolum> getBolumler() {
		return bolumDAO.getBolumler();
	}
}
