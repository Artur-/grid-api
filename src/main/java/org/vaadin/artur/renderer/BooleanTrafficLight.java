package org.vaadin.artur.whatsnewinvaadin74.renderer;

import java.util.Locale;

import com.vaadin.data.util.converter.StringToBooleanConverter;
import com.vaadin.server.FontAwesome;

public class BooleanTrafficLight extends StringToBooleanConverter {

	@Override
	public String convertToPresentation(Boolean value,
			Class<? extends String> targetType, Locale locale)
					throws com.vaadin.data.util.converter.Converter.ConversionException {
		String color;
		if (value == null || !value) {
			color = "#2dd085";
		} else {
			color = "#f54993";
		}

		return FontAwesome.CIRCLE.getHtml().replace("style=\"",
				"style=\"color: " + color + ";");

	}
}
