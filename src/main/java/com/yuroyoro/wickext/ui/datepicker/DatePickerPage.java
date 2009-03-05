package com.yuroyoro.wickext.ui.datepicker;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.PageLink;
import org.apache.wicket.markup.html.resources.StyleSheetReference;
import org.apache.wicket.model.Model;
import org.objetdirect.wickext.ui.datepicker.DatePicker;

import com.yuroyoro.wickext.HomePage;

public class DatePickerPage extends WebPage {
	public DatePickerPage(final PageParameters parameters) {
		this.add(new StyleSheetReference("css", HomePage.class, "wickext-sample.css"));
		this.add(new PageLink<HomePage>("menuLink", HomePage.class));
		
	    Form<Model<String>> acForm = new Form<Model<String>>("acForm");
		final DatePicker<String> acText = new DatePicker<String>("datePickerText", new Model<String>(""));
		acForm.add(acText);
		this.add(acForm);

	}
}
