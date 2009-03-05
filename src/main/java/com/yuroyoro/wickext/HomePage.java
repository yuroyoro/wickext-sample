package com.yuroyoro.wickext;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.PageLink;
import org.apache.wicket.markup.html.resources.StyleSheetReference;

import com.yuroyoro.wickext.core.effects.EffectsPage;
import com.yuroyoro.wickext.core.events.EventsPage;
import com.yuroyoro.wickext.core.genjs.GenJsPage;
import com.yuroyoro.wickext.core.helpers.HelpersPage;
import com.yuroyoro.wickext.plugins.flexigrid.FlexigridPage;
import com.yuroyoro.wickext.plugins.treeview.TreeViewPage;
import com.yuroyoro.wickext.ui.accordion.AccordionPage;
import com.yuroyoro.wickext.ui.datepicker.DatePickerPage;
import com.yuroyoro.wickext.ui.dialog.DialogPage;
import com.yuroyoro.wickext.ui.tabs.TabsPage;

/**
 * Homepage
 */
public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;

    /**
	 * Constructor that is invoked when page is invoked without a session.
	 * 
	 * @param parameters
	 *            Page parameters
	 */
    public HomePage(final PageParameters parameters) {
    	
    	this.add(new StyleSheetReference("css", HomePage.class, "wickext-sample.css"));

    	this.add(new PageLink<DialogPage>("modaldialogLink", DialogPage.class));
    	this.add(new PageLink<AccordionPage>("accordionLink", AccordionPage.class));
    	
    	// ソースを読む限り、Behavior系はまだ動かないらしい
    	//this.add(new PageLink<AutoCompletePage>("autocompleteLink", AutoCompletePage.class));
    	
    	this.add(new PageLink<DatePickerPage>("datepickerLink", DatePickerPage.class));
    	this.add(new PageLink<TabsPage>("tabsLink", TabsPage.class));
    	
    	this.add(new PageLink<TreeViewPage>("treeviewLink", TreeViewPage.class));
    	this.add(new PageLink<FlexigridPage>("flexigridLink", FlexigridPage.class));
    	
    	this.add(new PageLink<GenJsPage>("genJsLink", GenJsPage.class));
    	this.add(new PageLink<HelpersPage>("helpersLink", HelpersPage.class));
    	this.add(new PageLink<EffectsPage>("effectsLink", EffectsPage.class));
    	this.add(new PageLink<EventsPage>("eventsLink", EventsPage.class));
    	    	
    }
}
