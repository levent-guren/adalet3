package tr.gov.adalet.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import net.minidev.json.JSONObject;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> genelHataOlustu(Exception ex) {
		ex.printStackTrace();
		JSONObject hataCevabi = new JSONObject();
		hataCevabi.appendField("sonuc", "hata");
		hataCevabi.appendField("mesaj", ex.getMessage());
		hataCevabi.appendField("tarih", new Date());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.header("Content-Type", "application/json").body(hataCevabi.toString());
	}
}
