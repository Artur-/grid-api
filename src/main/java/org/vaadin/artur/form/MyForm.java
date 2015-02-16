package org.vaadin.artur.whatsnewinvaadin74.form;

import java.util.Map;

import org.vaadin.artur.whatsnewinvaadin74.data.Person;
import com.vaadin.data.Validator.InvalidValueException;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Field;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;

public class MyForm extends GridLayout {
	public BeanFieldGroup<Person> fieldGroup = new BeanFieldGroup<Person>(
			Person.class);
	private TextField firstName, lastName;
	private TextField age;
	private NativeSelect gender;
	private TextField salary;

	public MyForm() {
		super(3, 1);
		setSpacing(true);
		fieldGroup.buildAndBindMemberFields(this);
		addComponents(firstName, lastName, age, gender, salary);
		space();
		addComponent(new Button("Save", new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				try {
					fieldGroup.commit();
				} catch (CommitException e) {
					Map<Field<?>, InvalidValueException> invalidFields = e
							.getInvalidFields();
					Field<?> f = invalidFields.keySet().iterator().next();
					Notification.show(f.getCaption() + ": "
							+ invalidFields.get(f).getMessage());
				}
			}
		}));
		addComponent(new Button("Cancel", new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				onDiscard();
			}
		}));
	}

	protected void onDiscard() {
		fieldGroup.discard();
	}
}
