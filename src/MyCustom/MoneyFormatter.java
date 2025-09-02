package MyCustom;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class MoneyFormatter {
	public static String formatMoney(long amount) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("vi", "VN"));
        symbols.setGroupingSeparator('.');  
        DecimalFormat formatter = new DecimalFormat("#,###", symbols);
        return formatter.format(amount);
    }
	
	public static long parseMoney(String moneyStr) {
	    if (moneyStr == null || moneyStr.trim().isEmpty()) {
	        return 0L;
	    }
	    String plainNumber = moneyStr.replace(".", "").trim();
	    return Long.parseLong(plainNumber);
	}

}
