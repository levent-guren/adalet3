package tr.gov.adalet.bean;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Component
@Order(1)
public class Volvo extends Araba {

}
