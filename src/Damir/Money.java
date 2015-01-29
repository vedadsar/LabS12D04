package Damir;
import java.math.BigDecimal;
import java.util.Currency;


public class Money {

	private BigDecimal value;
	private Currency currency;
	
	public Money(BigDecimal value, Currency currency){
		this.value = value;
		this.currency = currency;
	}

	public BigDecimal getValue() {
		return value;
	}

	public Currency getCurrency() {
		return currency;
	}
	
	public String toString(){
		return value.toString() +" " +currency.getSymbol();
	}
}
