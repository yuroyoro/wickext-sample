package com.yuroyoro.wickext.core.genjs;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.PageLink;
import org.apache.wicket.markup.html.resources.StyleSheetReference;
import org.objetdirect.wickext.core.javascript.JsQuery;

import com.yuroyoro.wickext.HomePage;

public class GenJsPage extends WebPage {

	public GenJsPage(final PageParameters parameters) {
		this.add(new StyleSheetReference("css", HomePage.class, "wickext-sample.css"));
		this.add(new PageLink<HomePage>("menuLink", HomePage.class));
				
		JsQuery jsq = new JsQuery();
		jsq.$(".foo").chain("css", "{border: '1px solid red'}");
		jsq.contribute(this);	

	}
}
