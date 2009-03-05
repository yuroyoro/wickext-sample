package com.yuroyoro.wickext.core.helpers;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.PageLink;
import org.apache.wicket.markup.html.resources.StyleSheetReference;
import org.objetdirect.wickext.core.javascript.JsQuery;
import org.objetdirect.wickext.core.javascript.helper.AttributesHelper;
import org.objetdirect.wickext.core.javascript.helper.CssHelper;
import org.objetdirect.wickext.core.javascript.helper.TraversingHelper;
import org.objetdirect.wickext.core.options.Options;

import com.yuroyoro.wickext.HomePage;

public class HelpersPage extends WebPage {

	public HelpersPage(final PageParameters parameters) {
		this.add(new StyleSheetReference("css", HomePage.class, "wickext-sample.css"));
		this.add(new PageLink<HomePage>("menuLink", HomePage.class));
				
		JsQuery jsq1 = new JsQuery();
		jsq1.$(".foo")
		   .chain(TraversingHelper.eq(1))
		   .chain(CssHelper.css(new Options().putLiteral("border", "1px solid red")));
		jsq1.contribute(this);

		JsQuery jsq2 = new JsQuery();
		jsq2.$("#foo")
		   .chain(TraversingHelper.siblings(".style-me"))
		   .chain(CssHelper.css(
		  	new Options().putLiteral("border", "1px solid red")
		   ));
		jsq2.contribute(this);
		
		JsQuery jsq3 = new JsQuery();
		jsq3.$(".foo2")
		   .chain(TraversingHelper.siblings(".style-me"))
		   .chain(AttributesHelper.addClass("you-are-now-styled"));
		jsq3.contribute(this);

		JsQuery jsq4 = new JsQuery();
		jsq4.$(".foo-important")
		   .chain(CssHelper.css("border", "1px solid red"));
		jsq4.contribute(this);

	}
}
