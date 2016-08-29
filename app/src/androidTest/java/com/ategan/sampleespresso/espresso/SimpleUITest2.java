package com.ategan.sampleespresso.espresso;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.ategan.sampleespresso.LoginActivity;
import com.ategan.sampleespresso.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class SimpleUITest2 {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void testNavigationToWebView() {
        onView(allOf(ViewMatchers.withId(R.id.user_name_field), withParent(allOf(withId(R.id.activity_login),
                withParent(withId(android.R.id.content)))), isDisplayed()))
                .perform(replaceText("Android"), closeSoftKeyboard());

        onView(allOf(withId(R.id.password_field), withParent(allOf(withId(R.id.activity_login),
                withParent(withId(android.R.id.content)))), isDisplayed()))
                .perform(replaceText("123"), closeSoftKeyboard());

        onView(allOf(withId(R.id.login_button), withParent(allOf(withId(R.id.activity_login),
                withParent(withId(android.R.id.content)))), isDisplayed()))
                .perform(click());

        onView(allOf(withContentDescription(R.string.navigation_drawer_open),
                withParent(withId(R.id.toolbar)), isDisplayed()))
                .perform(click());

        onView(allOf(withId(R.id.design_menu_item_text), withText(R.string.nav_web_view_title), isDisplayed()))
                .perform(click());

    }

    @Test
    public void testNavigationToOthers() {
        onView(allOf(withId(R.id.user_name_field), withParent(allOf(withId(R.id.activity_login),
                withParent(withId(android.R.id.content)))), isDisplayed()))
                .perform(replaceText("Android"), closeSoftKeyboard());

        onView(allOf(withId(R.id.password_field), withParent(allOf(withId(R.id.activity_login),
                withParent(withId(android.R.id.content)))), isDisplayed()))
                .perform(replaceText("123"), closeSoftKeyboard());

        onView(allOf(withId(R.id.login_button), withParent(allOf(withId(R.id.activity_login),
                withParent(withId(android.R.id.content)))), isDisplayed()))
                .perform(click());

        onView(allOf(withContentDescription(R.string.navigation_drawer_open),
                withParent(withId(R.id.toolbar)), isDisplayed()))
                .perform(click());

        onView(allOf(withId(R.id.design_menu_item_text), withText(R.string.nav_others_title), isDisplayed()))
                .perform(click());
    }
}
