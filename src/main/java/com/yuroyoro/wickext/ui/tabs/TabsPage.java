package com.yuroyoro.wickext.ui.tabs;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.link.PageLink;
import org.apache.wicket.markup.html.resources.StyleSheetReference;
import org.objetdirect.wickext.core.events.Event;
import org.objetdirect.wickext.core.events.MouseEvent;
import org.objetdirect.wickext.core.events.WickextEventBehavior;
import org.objetdirect.wickext.core.javascript.JsScope;
import org.objetdirect.wickext.ui.tabs.Tabs;

import com.yuroyoro.wickext.HomePage;

public class TabsPage extends WebPage {

	public TabsPage(final PageParameters parameters) {
		this.add(new StyleSheetReference("css", HomePage.class, "wickext-sample.css"));
		this.add(new PageLink<HomePage>("menuLink", HomePage.class));
		
		final Tabs tabs = new Tabs("tabs");
		this.add(tabs);
		
		
		final WebMarkupContainer webMarkupContainer = new WebMarkupContainer("tabsPanel");
		webMarkupContainer.setOutputMarkupId(true);
		add(webMarkupContainer);

		Button addTabButton = new Button("tabsAdd");
		add(addTabButton);
		addTabButton.add(new WickextEventBehavior(new Event(MouseEvent.CLICK) {

			private static final long serialVersionUID = 1L;

			@Override
			public JsScope callback() {
				return JsScope.quickScope(tabs.add(0, "Tabbified ", webMarkupContainer).render());
			}
			
		}));
	}
}
