package ru.rrozhkov.easykin.fin.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import ru.rrozhkov.easykin.fin.Money;

public class FormatUtil {
	private static DecimalFormat kopeckFormatter = new DecimalFormat("00");
	private static DecimalFormat rublesFormatter = new DecimalFormat("###,###");
	private static DecimalFormat moneyFormatter = new DecimalFormat("###,###.00");
	public static DecimalFormat intFormatter = new DecimalFormat("###");
	static {
		DecimalFormatSymbols symbols = rublesFormatter.getDecimalFormatSymbols();
	    symbols.setGroupingSeparator(' ');
	    rublesFormatter.setDecimalFormatSymbols(symbols);
	}
	
	public static String formatKopeck(int kopeck){
		return kopeckFormatter.format(kopeck);
	}
	
	public static String formatRubles(int rubles){
		return rublesFormatter.format(rubles);
	}
	public static String formatMoney(Money money){
		return moneyFormatter.format(money.getValue());
	}
	public static String formatInt(int value){
		return intFormatter.format(value);
	}
}
