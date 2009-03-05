package com.yuroyoro.wickext.core.events;

import org.apache.wicket.PageParameters;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.link.PageLink;
import org.apache.wicket.markup.html.resources.StyleSheetReference;
import org.objetdirect.wickext.core.effects.EffectSpeed;
import org.objetdirect.wickext.core.effects.fading.FadeOut;
import org.objetdirect.wickext.core.events.Event;
import org.objetdirect.wickext.core.events.MouseEvent;
import org.objetdirect.wickext.core.events.WickextAjaxEventBehavior;
import org.objetdirect.wickext.core.events.WickextEventBehavior;
import org.objetdirect.wickext.core.javascript.JsQuery;
import org.objetdirect.wickext.core.javascript.JsScope;
import org.objetdirect.wickext.core.javascript.JsScopeContext;
import org.objetdirect.wickext.core.javascript.helper.CssHelper;

import com.yuroyoro.wickext.HomePage;

public class EventsPage extends WebPage {

	public EventsPage(final PageParameters parameters) {
		this.add(new StyleSheetReference("css", HomePage.class, "wickext-sample.css"));
		this.add(new PageLink<HomePage>("menuLink", HomePage.class));
		
		JsQuery jsq = new JsQuery(); 
		jsq.$("#clickable").chain(new Event(MouseEvent.CLICK) { 
		    @Override public JsScope callback() {
		        return new JsScope() {
		            @Override protected void execute(JsScopeContext scopeContext) {
		                scopeContext.self().chain(CssHelper.css("border", "1px solid red")); 
		            } 
		        }; 
		    } 
		}); 
		jsq.contribute(this);


		Button button = new Button("sample1");
		add(button);
		button.add(new WickextEventBehavior(new Event(MouseEvent.CLICK) {		
		    @Override
		    public JsScope callback() {
		        return JsScope.quickScope("alert(this)");
		    }	
		}));

		WebMarkupContainer div1 = new WebMarkupContainer("firstDiv");
		add(div1);

		final WebMarkupContainer div2 = new WebMarkupContainer("secondDiv");
		div2.setOutputMarkupId(true);
		add(div2);

		div1.add(new WickextAjaxEventBehavior(MouseEvent.DBLCLICK) {
		    @Override
		    protected void respond(AjaxRequestTarget target) {
		        // do some ajax Java stuff here
						
		        // adding javascript to the outputed response to hide the div
		        target.appendJavascript(
		            new JsQuery(div2)
				    .$()
				    .chain(new FadeOut(EffectSpeed.SLOW))
				    .render()
				    .toString()
			);
		    }
		});
	}
}
