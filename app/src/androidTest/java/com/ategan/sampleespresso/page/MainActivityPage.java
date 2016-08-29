package com.ategan.sampleespresso.page;

import com.ategan.sampleespresso.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by ategan on 8/28/16.
 */
public class MainActivityPage {


    public MainActivityPage openNavigationDrawer() {
        onView(allOf(withContentDescription(R.string.navigation_drawer_open),
                withParent(withId(R.id.toolbar)), isDisplayed()))
                .perform(click());
        return this;
    }

    public WebViewActivityPage tapOnWebView() {
        onView(allOf(withId(R.id.design_menu_item_text), withText("Web view"), isDisplayed()))
                .perform(click());
        return new WebViewActivityPage();
    }

    public OthersActivityPage tapOnOthers() {
        onView(allOf(withId(R.id.design_menu_item_text), withText(R.string.nav_web_view_title), isDisplayed()))
                .perform(click());
        return new OthersActivityPage();
    }

}
