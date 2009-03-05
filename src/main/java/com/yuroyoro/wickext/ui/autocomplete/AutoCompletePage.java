package com.yuroyoro.wickext.ui.autocomplete;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.PageLink;
import org.apache.wicket.markup.html.resources.StyleSheetReference;
import org.apache.wicket.model.Model;
import org.objetdirect.wickext.ui.autocomplete.AutocompleteBehavior;
import org.objetdirect.wickext.ui.autocomplete.AutocompleteValue;

import com.yuroyoro.wickext.HomePage;

public class AutoCompletePage extends WebPage {
	
	
	public AutoCompletePage(final PageParameters parameters) {
		this.add(new StyleSheetReference("css", HomePage.class, "wickext-sample.css"));
		this.add(new PageLink<HomePage>("menuLink", HomePage.class));
		
		
        Form<Model<String>> acForm = new Form<Model<String>>("acForm");
        final TextField<String> acText = new TextField<String>("acText", new Model<String>("なんか入れる"));
        acForm.add(acText);
        this.add(acForm);
        
        acText.add(new  AutocompleteBehavior<String, String>(){
			private static final long serialVersionUID = 1L;
        	
			@Override
			public List<AutocompleteValue<String, String>> autocomplete() {
				ArrayList<AutocompleteValue<String, String>> list =
        			new ArrayList<AutocompleteValue<String, String>>();
				list.add( new AutocompleteValue<String, String>(new Model<String>("a"),new Model<String>("Apple")) );
        		list.add( new AutocompleteValue<String, String>(new Model<String>("b"),new Model<String>("Banana")));
        		list.add( new AutocompleteValue<String, String>(new Model<String>("c"),new Model<String>("Chocolate")) );
        		
				return list;
			}
        });
        
        
	}

}
