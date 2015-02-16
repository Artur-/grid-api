package org.vaadin.artur.whatsnewinvaadin74;

import com.vaadin.data.Container;
import com.vaadin.data.Container.Filter;
import com.vaadin.data.Container.Filterable;
import com.vaadin.data.Container.Indexed;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.converter.Converter;
import com.vaadin.data.util.filter.Compare;
import com.vaadin.data.util.filter.SimpleStringFilter;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.ui.Field;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.HeaderCell;
import com.vaadin.ui.Grid.HeaderRow;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.TextField;

public class FilterRow {

	public static class Filterer implements ValueChangeListener,
	TextChangeListener {

		private Filter currentFilter = null;
		private Grid grid;
		private Object propertyId;
		private Class<?> type;

		public Filterer(Grid grid, Object propertyId, Class<?> type) {
			this.grid = grid;
			this.propertyId = propertyId;
			this.type = type;
		}

		private void updateFilter(Object value) {
			Filterable container = ((Container.Filterable) grid
					.getContainerDataSource());
			if (currentFilter != null) {
				container.removeContainerFilter(currentFilter);
				currentFilter = null;
			}

			if (value == null) {
				return;
			}

			String filterText = value.toString();
			if (filterText.startsWith(">=")) {
				currentFilter = new Compare.GreaterOrEqual(propertyId,
						stringToType(filterText.substring(2), type));
			} else if (filterText.startsWith("<=")) {
				currentFilter = new Compare.LessOrEqual(propertyId,
						stringToType(filterText.substring(2), type));
			} else if (filterText.startsWith(">")) {
				currentFilter = new Compare.Greater(propertyId, stringToType(
						filterText.substring(1), type));
			} else if (filterText.startsWith("<")) {
				currentFilter = new Compare.Less(propertyId, stringToType(
						filterText.substring(1), type));
			} else {
				boolean exact = false;
				if (Enum.class.isAssignableFrom(type)) {
					exact = true;
				}
				currentFilter = new SimpleStringFilter(propertyId, filterText,
						true, exact);
			}
			container.addContainerFilter(currentFilter);
		}

		private <T> T stringToType(String substring, Class<T> type) {
			Converter<String, T> conv = grid.getUI().getSession()
					.getConverterFactory().createConverter(String.class, type);
			return conv.convertToModel(substring, type, grid.getLocale());
		}

		@Override
		public void valueChange(ValueChangeEvent event) {
			updateFilter(event.getProperty().getValue());
		}

		@Override
		public void textChange(TextChangeEvent event) {
			updateFilter(event.getText());
		}
	};

	public static void add(Grid grid) {
		// Filtering row
		HeaderRow row = grid.appendHeaderRow();

		Indexed dataSource = grid.getContainerDataSource();

		for (Object propertyId : dataSource.getContainerPropertyIds()) {
			HeaderCell cell = row.getCell(propertyId);
			if (cell == null) {
				continue;
			}

			Class<?> type = dataSource.getType(propertyId);
			Class<? extends Field> fieldType = TextField.class;
			if (Enum.class.isAssignableFrom(type)) {
				fieldType = NativeSelect.class;
			}

			Field filterComponent = grid.getEditorFieldFactory().createField(
					type, fieldType);
			filterComponent.setWidth("100%");
			if (fieldType == NativeSelect.class) {
				((NativeSelect) filterComponent).setNullSelectionAllowed(true);
			}
			Filterer filterer = new Filterer(grid, propertyId, type);
			if (filterComponent instanceof TextField) {
				((TextField) filterComponent).addTextChangeListener(filterer);
			} else {
				filterComponent.addValueChangeListener(filterer);
			}

			cell.setComponent(filterComponent);
		}

	}

}
