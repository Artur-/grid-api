package org.vaadin.artur.whatsnewinvaadin74;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import org.vaadin.artur.whatsnewinvaadin74.data.Person;
import org.vaadin.artur.whatsnewinvaadin74.data.Persons;
import org.vaadin.artur.whatsnewinvaadin74.form.MyForm;
import org.vaadin.artur.whatsnewinvaadin74.renderer.BigDecimalToDoubleConverter;
import org.vaadin.artur.whatsnewinvaadin74.renderer.BooleanTrafficLight;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Viewport;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.SelectionEvent;
import com.vaadin.event.SelectionEvent.SelectionListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.CommitErrorEvent;
import com.vaadin.ui.Grid.EditorErrorHandler;
import com.vaadin.ui.Grid.FooterRow;
import com.vaadin.ui.Grid.HeaderRow;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.renderers.HtmlRenderer;
import com.vaadin.ui.renderers.ProgressBarRenderer;

@SuppressWarnings("serial")
@Theme("mytheme")
@Viewport("initial-scale=1.0")
public class Whatsnewin74UI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = Whatsnewin74UI.class, widgetset="org.vaadin.artur.MyAppWidgetset")
	public static class Servlet extends VaadinServlet {
	}

	private List<Person> personList = Persons.create(100);

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setSizeFull();
		layout.setMargin(true);
		setContent(layout);

		final BeanItemContainer<Person> container = new BeanItemContainer<Person>(
				Person.class, personList);
		final Grid grid = new Grid(container);
		grid.setSizeFull();
		layout.addComponent(grid);
		layout.setExpandRatio(grid, 1);

		// Column setup

		container.addNestedContainerBean("address");
		grid.setColumnOrder("firstName", "lastName", "age", "gender", "salary",
				"address.streetAddress", "address.city", "address.country");
		grid.removeColumn("id");

		// Sizing

		grid.getColumn("address.streetAddress").setExpandRatio(1);
		grid.getColumn("salary").setMinimumWidth(200);

		// Renderers and converters
		// Data -> Converter -> Renderer

		grid.getColumn("salary").setRenderer(new ProgressBarRenderer(),
				new BigDecimalToDoubleConverter());

		grid.getColumn("busy").setConverter(new BooleanTrafficLight())
		.setRenderer(new HtmlRenderer());

		// Editor

		grid.setEditorEnabled(true);
		grid.setEditorSaveCaption("Do it!");

		grid.setEditorErrorHandler(new EditorErrorHandler() {
			@Override
			public void commitError(CommitErrorEvent event) {
				com.vaadin.ui.Notification.show(event.getCause()
						.getInvalidFields().values().iterator().next()
						.getMessage(),
						com.vaadin.ui.Notification.Type.ERROR_MESSAGE);
				event.setUserErrorMessage("You're doing it wrong man!");
			}
		});

		// Frozen column

		grid.setFrozenColumnCount(2);
		// grid.getColumn("lastName").setLastFrozenColumn();

		// Header

		HeaderRow row = grid.addHeaderRowAt(0);
		row.join("firstName", "lastName").setHtml("<b>Full name</b>");

		FilterRow.add(grid);

		// Footer

		FooterRow footer = grid.appendFooterRow();
		String averageSalary = "1528.55";
		footer.getCell("salary").setStyleName("emphasis");
		footer.getCell("salary").setText(averageSalary);

		// Selection

		grid.setSelectionMode(SelectionMode.NONE);
		grid.setSelectionMode(SelectionMode.MULTI);
		grid.setSelectionMode(SelectionMode.SINGLE);

		// External form

		final MyForm form = new MyForm() {
			@Override
			protected void onDiscard() {
				grid.select(null);
			}
		};
		layout.addComponent(form);
		grid.addSelectionListener(new SelectionListener() {
			@Override
			public void select(SelectionEvent event) {
				BeanItem<Person> item = container.getItem(grid.getSelectedRow());
				form.fieldGroup.setItemDataSource(item);
			}
		});

	}
}