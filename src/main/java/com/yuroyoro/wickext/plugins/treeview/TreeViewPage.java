package com.yuroyoro.wickext.plugins.treeview;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.PageLink;
import org.apache.wicket.markup.html.resources.StyleSheetReference;
import org.objetdirect.wickext.plugins.treeview.TreeViewPlugin;

import com.yuroyoro.wickext.HomePage;

public class TreeViewPage extends WebPage {
	
	public TreeViewPage(final PageParameters parameters) {
		this.add(new StyleSheetReference("css", HomePage.class, "wickext-sample.css"));
		this.add(new PageLink<HomePage>("menuLink", HomePage.class));
		add(new TreeViewPlugin("treeview-example"));
	}
}
