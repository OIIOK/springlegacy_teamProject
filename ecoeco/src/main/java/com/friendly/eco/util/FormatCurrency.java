package com.friendly.eco.util;

import java.text.NumberFormat;
import java.util.Locale;

public class FormatCurrency {
	public static String getCurrency(int price) {
		return NumberFormat.getCurrencyInstance(Locale.KOREA).format(price);
	}
}
