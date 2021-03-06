package com.example.android.scorekeeper;


import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<> ( MainActivity.class );

    @Test
    public void mainActivityTest() {
        openActionBarOverflowOrOptionsMenu ( getInstrumentation ( ).getTargetContext ( ) );

        ViewInteraction appCompatTextView = onView (
                allOf ( withId ( R.id.title ) , withText ( "Night Mode" ) ,
                        childAtPosition (
                                childAtPosition (
                                        withClassName ( is ( "android.support.v7.view.menu.ListMenuItemView" ) ) ,
                                        0 ) ,
                                0 ) ,
                        isDisplayed ( ) ) );
        appCompatTextView.perform ( click ( ) );

        ViewInteraction appCompatImageButton = onView (
                allOf ( withId ( R.id.increaseTeam1 ) , withContentDescription ( "Plus Button" ) ,
                        childAtPosition (
                                childAtPosition (
                                        withClassName ( is ( "android.widget.LinearLayout" ) ) ,
                                        0 ) ,
                                3 ) ,
                        isDisplayed ( ) ) );
        appCompatImageButton.perform ( click ( ) );

        ViewInteraction appCompatImageButton2 = onView (
                allOf ( withId ( R.id.increaseTeam1 ) , withContentDescription ( "Plus Button" ) ,
                        childAtPosition (
                                childAtPosition (
                                        withClassName ( is ( "android.widget.LinearLayout" ) ) ,
                                        0 ) ,
                                3 ) ,
                        isDisplayed ( ) ) );
        appCompatImageButton2.perform ( click ( ) );

        ViewInteraction appCompatImageButton3 = onView (
                allOf ( withId ( R.id.decreaseTeam2 ) , withContentDescription ( "Minus Button" ) ,
                        childAtPosition (
                                childAtPosition (
                                        withClassName ( is ( "android.widget.LinearLayout" ) ) ,
                                        1 ) ,
                                1 ) ,
                        isDisplayed ( ) ) );
        appCompatImageButton3.perform ( click ( ) );

        ViewInteraction appCompatImageButton4 = onView (
                allOf ( withId ( R.id.decreaseTeam2 ) , withContentDescription ( "Minus Button" ) ,
                        childAtPosition (
                                childAtPosition (
                                        withClassName ( is ( "android.widget.LinearLayout" ) ) ,
                                        1 ) ,
                                1 ) ,
                        isDisplayed ( ) ) );
        appCompatImageButton4.perform ( click ( ) );

        openActionBarOverflowOrOptionsMenu ( getInstrumentation ( ).getTargetContext ( ) );

        ViewInteraction appCompatTextView2 = onView (
                allOf ( withId ( R.id.title ) , withText ( "Day Mode" ) ,
                        childAtPosition (
                                childAtPosition (
                                        withClassName ( is ( "android.support.v7.view.menu.ListMenuItemView" ) ) ,
                                        0 ) ,
                                0 ) ,
                        isDisplayed ( ) ) );
        appCompatTextView2.perform ( click ( ) );
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher , final int position) {

        return new TypeSafeMatcher<View> ( ) {
            @Override
            public void describeTo(Description description) {
                description.appendText ( "Child at position " + position + " in parent " );
                parentMatcher.describeTo ( description );
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent ( );
                return parent instanceof ViewGroup && parentMatcher.matches ( parent )
                        && view.equals ( ( (ViewGroup) parent ).getChildAt ( position ) );
            }
        };
    }
}
