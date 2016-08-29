package com.ategan.sampleespresso.espresso.page;

import com.ategan.sampleespresso.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by ategan on 8/28/16.
 */

public class LoginActivityPage {

    public LoginActivityPage writeUsername(String username) {
        onView(allOf(withId(R.id.user_name_field), withParent(allOf(withId(R.id.activity_login),
                withParent(withId(android.R.id.content)))), isDisplayed()))
                .perform(replaceText(username), closeSoftKeyboard());
        return this;
    }

    public LoginActivityPage writePassword(String password) {
        onView(allOf(withId(R.id.password_field), withParent(allOf(withId(R.id.activity_login),
                withParent(withId(android.R.id.content)))), isDisplayed()))
                .perform(replaceText(password), closeSoftKeyboard());

        return this;
    }

    public MainActivityPage tapOnLogin() {
        onView(allOf(withId(R.id.login_button), withParent(allOf(withId(R.id.activity_login),
                withParent(withId(android.R.id.content)))), isDisplayed()))
                .perform(click());
        return new MainActivityPage();
    }




}
