package tr.gov.adalet.bean;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class Personel {
	@NotEmpty
	@Length(min = 3)
	private String adi;
	private String soyadi;
	@Min(18)
	@Max(99)
	private int yasi;
}
