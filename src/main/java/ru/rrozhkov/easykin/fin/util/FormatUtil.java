package ru.rrozhkov.easykin.fin.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import ru.rrozhkov.easykin.fin.Money;

public class FormatUtil {
	private static DecimalFormat moneyFormatter = new DecimalFormat("###,###.00");
	public static DecimalFormat intFormatter = new DecimalFormat("###");
	static {
		DecimalFormatSymbols symbols = moneyFormatter.getDecimalFormatSymbols();
	    symbols.setGroupingSeparator(' ');
	    moneyFormatter.setDecimalFormatSymbols(symbols);
	}
	
	public static String formatMoney(Money money){
		return moneyFormatter.format(money.getValue());
	}
	public static String formatInt(int value){
		return intFormatter.format(value);
	}

	public static String formatEditMoney(Money money) {
		return formatMoney(money).replace(" ", "");
	}
}
