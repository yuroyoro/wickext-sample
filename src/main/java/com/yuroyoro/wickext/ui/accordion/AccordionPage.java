package com.yuroyoro.wickext.ui.accordion;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.PageLink;
import org.apache.wicket.markup.html.resources.StyleSheetReference;
import org.objetdirect.wickext.ui.accordion.Accordion;

import com.yuroyoro.wickext.HomePage;

public class AccordionPage extends WebPage {
	
	public AccordionPage(final PageParameters parameters) {
		this.add(new StyleSheetReference("css", HomePage.class, "wickext-sample.css"));
		this.add(new PageLink<HomePage>("menuLink", HomePage.class));
		
		Accordion accordion = new Accordion("accordion");
//		デフォルトのヘッダタグは a だが、すべての a が反応してしまうので、class属性を敢えて指定する
		accordion.setHeader("a.head");
		this.add(accordion);
	}
}
