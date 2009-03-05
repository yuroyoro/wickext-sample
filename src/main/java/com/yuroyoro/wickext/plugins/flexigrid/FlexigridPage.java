package com.yuroyoro.wickext.plugins.flexigrid;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.PageLink;
import org.apache.wicket.markup.html.resources.StyleSheetReference;
import org.objetdirect.wickext.plugins.grid.GridPlugin;

import com.yuroyoro.wickext.HomePage;

public class FlexigridPage extends WebPage {
	
	public FlexigridPage(final PageParameters parameters) {
		this.add(new StyleSheetReference("css", HomePage.class, "wickext-sample.css"));
		this.add(new PageLink<HomePage>("menuLink", HomePage.class));
		
		add(new GridPlugin("flexigrid-example"));
	}
}
