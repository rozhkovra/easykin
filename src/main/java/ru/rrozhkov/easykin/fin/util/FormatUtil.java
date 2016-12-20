package ru.rrozhkov.easykin.fin.util;

import java.text.DecimalFormat;

public class FormatUtil {
	private static DecimalFormat kopeckFormatter = new DecimalFormat("00");
	private static DecimalFormat rublesFormatter = new DecimalFormat("###");
	
	public static String formatKopeck(int kopeck){
		return kopeckFormatter.format(kopeck);
	}
	
	public static String formatRubles(int rubles){
		return rublesFormatter.format(rubles);
	}
}
