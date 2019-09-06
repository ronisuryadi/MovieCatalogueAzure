package com.ronisuryadi.moviecatalogue.ui;

import android.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.ronisuryadi.moviecatalogue.MainActivity;
import com.ronisuryadi.moviecatalogue.R;
import com.ronisuryadi.moviecatalogue.ui.movie.MovieFragment;
import com.ronisuryadi.moviecatalogue.ui.tv.TvFragment;
import com.ronisuryadi.moviecatalogue.utils.RecyclerViewItemCountAssertion;

import org.junit.Rule;
import org.junit.Test;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void toDetailMovieActivityTest() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        onView(withId(R.id.rv_movie_popular)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movie_popular)).check(new RecyclerViewItemCountAssertion(11));
    }

    @Test
    public void toDetailMovieActivityAndSelectPopularTest() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        onView(withId(R.id.scroll_view_detail)).perform(scrollTo(), click());
        onView(withId(R.id.rv_movie_popular)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movie_popular)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        onView(withId(R.id.rv_movie_popular)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movie_popular)).check(new RecyclerViewItemCountAssertion(11));
    }
}
