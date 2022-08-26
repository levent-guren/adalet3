package tr.gov.adalet.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bilgisayar {
	private String marka;
	private int ram;
	private Disk disk;

	public static Bilgisayar bilgisayarOlustur() {
		Bilgisayar b = new Bilgisayar();
		b.setRam(16);
		b.setMarka("Lenovo");
		Disk d = new Disk();
		d.setKapasite("4TB");
		b.setDisk(d);
		return b;
	}
}
