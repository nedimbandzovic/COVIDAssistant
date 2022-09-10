package com.example.covidhelper;


import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.pressImeActionButton;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class VaccineTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void vaccineTest() {
        ViewInteraction materialButton = onView(
                allOf(withId(R.id.vaccine), withText("VACCINATION ASSISTANT"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.button12), withText("PROCEED"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.editTextTextPersonName7),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                9),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("1234567890111"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.editTextTextPersonName7), withText("1234567890111"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                9),
                        isDisplayed()));
        appCompatEditText2.perform(pressImeActionButton());

        ViewInteraction materialButton3 = onView(
                allOf(withId(R.id.button13), withText("PROCEED"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                10),
                        isDisplayed()));
        materialButton3.perform(click());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.editTextTextPersonName18),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                6),
                        isDisplayed()));
        appCompatEditText3.perform(replaceText("Ajdin"), closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.editTextTextPersonName811),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                13),
                        isDisplayed()));
        appCompatEditText4.perform(replaceText("Pasic"), closeSoftKeyboard());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.editTextTextPersonName8123),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                11),
                        isDisplayed()));
        appCompatEditText5.perform(replaceText("ajdin.pasic@gmail.com"), closeSoftKeyboard());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.editTextTextPersonName8),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                9),
                        isDisplayed()));
        appCompatEditText6.perform(replaceText("+38761616161"), closeSoftKeyboard());

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.editTextTextPersonName8), withText("+38761616161"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                9),
                        isDisplayed()));
        appCompatEditText7.perform(pressImeActionButton());

        ViewInteraction materialButton4 = onView(
                allOf(withId(R.id.button15), withText("PROCEED"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                14),
                        isDisplayed()));
        materialButton4.perform(click());

        ViewInteraction spinner = onView(
                allOf(withId(R.id.spinner2),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                6),
                        isDisplayed()));
        spinner.perform(click());

        DataInteraction checkedTextView = onData(anything())
                .inAdapterView(childAtPosition(
                        withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
                        0))
                .atPosition(4);
        checkedTextView.perform(click());

        ViewInteraction imageView = onView(
                allOf(withId(R.id.imageView16),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                8),
                        isDisplayed()));
        imageView.perform(click());

        ViewInteraction button = onView(
                allOf(withId(R.id.button16), withText("PROCEED"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                9),
                        isDisplayed()));
        button.perform(click());

        ViewInteraction appCompatImageView = onView(
                allOf(withId(R.id.imageView17),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                6),
                        isDisplayed()));
        appCompatImageView.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.vaccineName), withText("Oxford-AstraZeneca Vaccine"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class))),
                        isDisplayed()));
        textView.check(matches(withText("Oxford-AstraZeneca Vaccine")));

        ViewInteraction view = onView(
                allOf(withId(androidx.appcompat.R.id.touch_outside),
                        childAtPosition(
                                allOf(withId(androidx.appcompat.R.id.coordinator),
                                        childAtPosition(
                                                withId(androidx.appcompat.R.id.container),
                                                0)),
                                0),
                        isDisplayed()));
        view.perform(click());

        ViewInteraction appCompatImageView2 = onView(
                allOf(withId(R.id.imageView127),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                8),
                        isDisplayed()));
        appCompatImageView2.perform(click());

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.vaccineName), withText("Pfizer-BioNTech Vaccine"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class))),
                        isDisplayed()));
        textView2.check(matches(withText("Pfizer-BioNTech Vaccine")));

        ViewInteraction view2 = onView(
                allOf(withId(androidx.appcompat.R.id.touch_outside),
                        childAtPosition(
                                allOf(withId(androidx.appcompat.R.id.coordinator),
                                        childAtPosition(
                                                withId(androidx.appcompat.R.id.container),
                                                0)),
                                0),
                        isDisplayed()));
        view2.perform(click());

        ViewInteraction appCompatImageView3 = onView(
                allOf(withId(R.id.imageView117),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        appCompatImageView3.perform(click());

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.vaccineName), withText("Sinopharm BBIBP-CorV"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class))),
                        isDisplayed()));
        textView3.check(matches(withText("Sinopharm BBIBP-CorV")));

        ViewInteraction view3 = onView(
                allOf(withId(androidx.appcompat.R.id.touch_outside),
                        childAtPosition(
                                allOf(withId(androidx.appcompat.R.id.coordinator),
                                        childAtPosition(
                                                withId(androidx.appcompat.R.id.container),
                                                0)),
                                0),
                        isDisplayed()));
        view3.perform(click());

        ViewInteraction appCompatImageView4 = onView(
                allOf(withId(R.id.imageView1127),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                9),
                        isDisplayed()));
        appCompatImageView4.perform(click());

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.vaccineName), withText("Moderna COVID-19 vaccine"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class))),
                        isDisplayed()));
        textView4.check(matches(withText("Moderna COVID-19 vaccine")));

        ViewInteraction view4 = onView(
                allOf(withId(androidx.appcompat.R.id.touch_outside),
                        childAtPosition(
                                allOf(withId(androidx.appcompat.R.id.coordinator),
                                        childAtPosition(
                                                withId(androidx.appcompat.R.id.container),
                                                0)),
                                0),
                        isDisplayed()));
        view4.perform(click());

        ViewInteraction appCompatImageView5 = onView(
                allOf(withId(R.id.imageView11247),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                10),
                        isDisplayed()));
        appCompatImageView5.perform(click());

        ViewInteraction textView5 = onView(
                allOf(withId(R.id.vaccineName), withText("Sputnik V"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class))),
                        isDisplayed()));
        textView5.check(matches(withText("Sputnik V")));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
