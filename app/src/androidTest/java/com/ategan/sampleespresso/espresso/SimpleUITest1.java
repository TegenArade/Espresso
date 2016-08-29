package com.ategan.sampleespresso.espresso;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;

import com.ategan.sampleespresso.OthersActivity;
import com.ategan.sampleespresso.R;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by ategan on 8/28/16.
 */

public class SimpleUITest1 {

    // Preferred JUnit 4 mechanism of specifying the activity to be launched before each test
    @Rule
    public ActivityTestRule<OthersActivity> activityTestRule = new ActivityTestRule<>(OthersActivity.class);

    // Looks for an EditText with id = "R.id.simple_edit_text"
    // Types the text "Hello" into the EditText
    // Verifies the EditText has text "Hello"
    @Test
    public void validateEditText() {
        onView(ViewMatchers.withId(R.id.simple_edit_text))
                .perform(typeText("Hello"))
                    .check(matches(withText("Hello")));
    }

}
