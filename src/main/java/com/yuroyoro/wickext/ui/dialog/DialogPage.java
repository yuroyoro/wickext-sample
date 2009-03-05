package com.yuroyoro.wickext.ui.dialog;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.PageLink;
import org.apache.wicket.markup.html.resources.StyleSheetReference;
import org.objetdirect.wickext.ui.dialog.Window;

import com.yuroyoro.wickext.HomePage;

public class DialogPage extends WebPage{
	
	public DialogPage(final PageParameters parameters) {
		this.add(new StyleSheetReference("css", HomePage.class, "wickext-sample.css"));
		this.add(new PageLink<HomePage>("menuLink", HomePage.class));
		
		Window window = new Window("modal");
        add(window);
        window.add(new Label("message", "これはWickextで出してるダイアログなんだぜ?"));
        window.setAutoOpen(true);

	}

}
