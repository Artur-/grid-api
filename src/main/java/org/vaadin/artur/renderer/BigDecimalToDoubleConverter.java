package org.vaadin.artur.whatsnewinvaadin74.renderer;

import java.math.BigDecimal;
import java.util.Locale;

import com.vaadin.data.util.converter.Converter;

public class BigDecimalToDoubleConverter implements
		Converter<Double, BigDecimal> {

	private double scale = 10000;

	@Override
	public Class getModelType() {
		return BigDecimal.class;
	}

	@Override
	public Class getPresentationType() {
		return Double.class;
	}

	@Override
	public Double convertToPresentation(BigDecimal value,
			Class<? extends Double> targetType, Locale locale)
			throws com.vaadin.data.util.converter.Converter.ConversionException {
		if (value == null) {
			return null;
		}
		return value.doubleValue() / scale;
	}

	@Override
	public BigDecimal convertToModel(Double value,
			Class<? extends BigDecimal> targetType, Locale locale)
			throws com.vaadin.data.util.converter.Converter.ConversionException {
		if (value == null) {
			return null;
		}
		return new BigDecimal(value * scale);
	}

}
