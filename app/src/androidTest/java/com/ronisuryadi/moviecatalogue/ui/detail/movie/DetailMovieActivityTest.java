package com.ronisuryadi.moviecatalogue.ui.detail.movie;

import android.content.Context;
import android.content.Intent;

import com.ronisuryadi.moviecatalogue.R;
import com.ronisuryadi.moviecatalogue.data.MovieEntity;
import com.ronisuryadi.moviecatalogue.utils.FakeDataDummy;
import com.ronisuryadi.moviecatalogue.utils.RecyclerViewItemCountAssertion;

import org.junit.Rule;
import org.junit.Test;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.ronisuryadi.moviecatalogue.utils.Matchers.hasDrawable;
import static org.junit.Assert.*;

public class DetailMovieActivityTest {
    private MovieEntity dummyMovie = FakeDataDummy.generateDummyMovie().get(0);

    @Rule
    public ActivityTestRule<DetailMovieActivity> activityRule = new ActivityTestRule<DetailMovieActivity>(DetailMovieActivity.class) {
        @Override
        protected Intent getActivityIntent() {
            Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
            Intent result = new Intent(targetContext, DetailMovieActivity.class);
            result.putExtra(DetailMovieActivity.EXTRA_DATA, dummyMovie.getId());
            return result;
        }
    };

    @Test
    public void loadMovie() {
        onView(withId(R.id.tvMovieName)).check(matches(isDisplayed()));
        onView(withId(R.id.tvMovieName)).check(matches(withText(dummyMovie.getName())));
        onView(withId(R.id.tvMovieDescription)).check(matches(isDisplayed()));
        onView(withId(R.id.tvMovieDescription)).check(matches(withText(dummyMovie.getDescription())));
        onView(withId(R.id.tvMovieGenre)).check(matches(isDisplayed()));
        onView(withId(R.id.tvMovieGenre)).check(matches(withText(dummyMovie.getGenre())));
        onView(withId(R.id.tvMovieRelease)).check(matches(isDisplayed()));
        onView(withId(R.id.tvMovieRelease)).check(matches(withText(dummyMovie.getRelease())));

        onView(withId(R.id.material_icon_button)).check(matches(isDisplayed()));


        onView(withId(R.id.ratings)).check(matches(isDisplayed()));

        onView(withId(R.id.movie_photo)).check(matches(isDisplayed()));
        onView(withId(R.id.movie_photo)).check(matches(hasDrawable()));


    }

    @Test
    public void loadMovies(){
        onView(withId(R.id.rv_movie_popular)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movie_popular)).check(new RecyclerViewItemCountAssertion(11));
    }

    @Test
    public void clickPopular(){
        onView(withId(R.id.scroll_view_detail)).perform(scrollTo(), click());
        onView(withId(R.id.rv_movie_popular)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movie_popular)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        onView(withId(R.id.rv_movie_popular)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movie_popular)).check(new RecyclerViewItemCountAssertion(11));
    }
}