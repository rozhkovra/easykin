package ru.rrozhkov.easykin.gui.style.impl.custom;

import ru.rrozhkov.easykin.fin.payment.IPayment;
import ru.rrozhkov.easykin.gui.style.IDataConverter;
import ru.rrozhkov.easykin.gui.style.IStyle;
import ru.rrozhkov.easykin.gui.style.ITableStyle;

public class PaymentStyle implements IStyle<IPayment> {

	public ITableStyle tableStyle() {
		return new PaymentTableStyle();
	}

	public IDataConverter<IPayment> dataConverter() {
		return new PaymentConverter();
	}
}
