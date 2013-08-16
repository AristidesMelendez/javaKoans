package intermediate;

import static com.sandwich.koan.constant.KoanConstants.__;
import static com.sandwich.util.Assert.assertEquals;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.sandwich.koan.Koan;

public class AboutLocale {

	@Koan
	public void localizedOutputOfDates() {
		Calendar cal = Calendar.getInstance();
		cal.set(2011, 3, 3);
		Date date = cal.getTime();
		Locale localeBR = new Locale("pt","BR"); // portuguese, Brazil
		DateFormat dateformatBR = DateFormat.getDateInstance(DateFormat.FULL, localeBR);
		assertEquals(dateformatBR.format(date), "Domingo, 3 de Abril de 2011");
		
		Locale localeIt = new Locale("it"); // Japan
		DateFormat dateformatIt = DateFormat.getDateInstance(DateFormat.FULL, localeIt);
		// Well if you don't know how to type these characters, try "de", "it" or "us" ;-)
		assertEquals(dateformatIt.format(date), "domenica 3 aprile 2011");
	}
	
	@Koan
	public void getCountryInformation() {
		Locale locBR = new Locale("pt","BR");
		assertEquals(locBR.getDisplayCountry(), "Brazil");
		assertEquals(locBR.getDisplayCountry(locBR), "Brasil");
		
		Locale locCH = new Locale("es","CH");
		assertEquals(locCH.getDisplayCountry(), "Switzerland");
		assertEquals(locCH.getDisplayCountry(locCH), "Suiza");
		assertEquals(locCH.getDisplayCountry(new Locale("de","CH")), "Schweiz");
	}
	
	@Koan
	public void formatCurrency() {
		float someAmount = 442.23f; // Don't use floats for money in real life. Really. It's a bad idea.
		Locale locBR = new Locale("es","PA");
		NumberFormat nf = NumberFormat.getCurrencyInstance(locBR);
		assertEquals(nf.format(someAmount), "B442.23");
	}
}
