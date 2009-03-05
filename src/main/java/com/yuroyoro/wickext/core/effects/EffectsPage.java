package com.yuroyoro.wickext.core.effects;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.link.PageLink;
import org.apache.wicket.markup.html.resources.StyleSheetReference;
import org.objetdirect.wickext.core.effects.EffectSpeed;
import org.objetdirect.wickext.core.effects.fading.FadeIn;
import org.objetdirect.wickext.core.events.Event;
import org.objetdirect.wickext.core.events.MouseEvent;
import org.objetdirect.wickext.core.events.WickextEventBehavior;
import org.objetdirect.wickext.core.javascript.JsQuery;
import org.objetdirect.wickext.core.javascript.JsScope;
import org.objetdirect.wickext.core.javascript.JsScopeContext;

import com.yuroyoro.wickext.HomePage;

public class EffectsPage extends WebPage {
	
	public EffectsPage(final PageParameters parameters) {
		
		this.add(new StyleSheetReference("css", HomePage.class, "wickext-sample.css"));
		this.add(new PageLink<HomePage>("menuLink", HomePage.class));
		
		Button button = new Button("effects.button.show");
		add(button);
		button.add(new WickextEventBehavior(new Event(MouseEvent.CLICK) {
			@Override
			public JsScope callback() {
				return new JsScope() {
					@Override
					protected void execute(JsScopeContext scopeContext) {
						scopeContext.append(new JsQuery().$(".show-me").chain(
								new FadeIn(EffectSpeed.FAST)).render());
					}
				};
			}
		}));
		
	}

}
