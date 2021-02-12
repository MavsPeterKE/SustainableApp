package org.coursera.sustainableapps;

import android.view.View;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.allOf;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class LoginActivityUITest {

    @Rule
    public ActivityScenarioRule<LoginActivity> activityRule =
            new ActivityScenarioRule<>(LoginActivity.class);

    @Test
    public void checkInputsAndButtonClick() {
        onView(withId(R.id.editTextTextEmailAddress)).perform(typeText("mavspeter@gmail.com"));
        onView(withId(R.id.editTextTextPassword)).perform(typeText("ratarat@trat389"));
        onView(withId(R.id.btLogin))
                .perform(forceClick());
    }

    @Test
    public void InvalidEmailAndPassword() {
        onView(withId(R.id.editTextTextEmailAddress)).perform(typeText("mavspete"));
        onView(withId(R.id.editTextTextPassword)).perform(typeText("t389"));
        onView(withId(R.id.btLogin))
                .perform(forceClick());
    }

    public static ViewAction forceClick() {
        return new ViewAction() {
            @Override public Matcher<View> getConstraints() {
                return allOf(isClickable(), isEnabled(), isDisplayed());
            }

            @Override public String getDescription() {
                return "force click";
            }

            @Override public void perform(UiController uiController, View view) {
                view.performClick(); // perform click without checking view coordinates.
                uiController.loopMainThreadUntilIdle();
            }
        };
    }
}