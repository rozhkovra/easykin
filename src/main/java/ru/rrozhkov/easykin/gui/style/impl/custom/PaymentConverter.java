package ru.rrozhkov.easykin.gui.style.impl.custom;

import ru.rrozhkov.easykin.fin.payment.IPayment;
import ru.rrozhkov.easykin.gui.style.impl.DataConverter;
import ru.rrozhkov.easykin.util.DateUtil;

public class PaymentConverter extends DataConverter<IPayment> {
	public String[] entryToStringArr(int i, IPayment entry) {
		return new String[]{String.valueOf(i), entry.getCategory().toString(), entry.getComment(), entry.getAmount().toString(), DateUtil.format(entry.getDate())};
	}
}