package com.kbaldauf.playerfinder.activity;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.kbaldauf.playerfinder.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class NoPlayerFoundTest {

    @Rule
    public ActivityTestRule<TeamActivity> mActivityTestRule = new ActivityTestRule<>(TeamActivity.class);

    @Test
    public void noPlayerFoundTest() {
        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.team_list),
                        withParent(allOf(withId(R.id.activity_team_container),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        recyclerView.perform(actionOnItemAtPosition(22, click()));

        ViewInteraction actionMenuItemView = onView(
                allOf(withId(R.id.action_done), withContentDescription(R.string.done), isDisplayed()));
        actionMenuItemView.perform(click());

        ViewInteraction button = onView(
                allOf(withId(R.id.submit_button),
                        withParent(allOf(withId(R.id.roster_view_container),
                                withParent(withId(R.id.activity_roster_container)))),
                        isDisplayed()));
        button.check(matches(withText(R.string.submit)));

        ViewInteraction textView = onView(
                allOf(withId(R.id.player_name),
                        withParent(allOf(withId(R.id.roster_view_container),
                                withParent(withId(R.id.activity_roster_container)))),
                        isDisplayed()));
        textView.check(matches(withText("")));

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.submit_button), withText(R.string.submit),
                        withParent(allOf(withId(R.id.roster_view_container),
                                withParent(withId(R.id.activity_roster_container)))),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.player_name),
                        withParent(allOf(withId(R.id.roster_view_container),
                                withParent(withId(R.id.activity_roster_container)))),
                        isDisplayed()));
        textView2.check(matches(withText("No player found with uniform number ")));

    }
}
