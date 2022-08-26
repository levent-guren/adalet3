package tr.gov.adalet.bean;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Component
@Order(-2)
public class Kia extends Araba {

}
