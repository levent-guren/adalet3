package tr.gov.adalet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tr.gov.adalet.entity.Personel;

public interface PersonelRepository extends JpaRepository<Personel, Integer> {
	public List<Personel> findByEmail(String eposta);

	@Query("select p from Personel p where p.email = ?1")
	public List<Personel> emaileGorePersonelleriOku(String eposta);

	@Query(value = "select * from personel where email = :eposta", nativeQuery = true)
	public List<List<Object>> emaileGorePersonelleriOku2(String eposta);
}
