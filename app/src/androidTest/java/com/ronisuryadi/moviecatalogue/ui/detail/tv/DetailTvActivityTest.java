package com.ronisuryadi.moviecatalogue.ui.detail.tv;

import android.content.Context;
import android.content.Intent;

import com.ronisuryadi.moviecatalogue.R;
import com.ronisuryadi.moviecatalogue.data.MovieEntity;
import com.ronisuryadi.moviecatalogue.data.TvEntity;
import com.ronisuryadi.moviecatalogue.ui.detail.movie.DetailMovieActivity;
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

public class DetailTvActivityTest {
    private TvEntity dummyTv = FakeDataDummy.generateDummyTv().get(0);

    @Rule
    public ActivityTestRule<DetailTvActivity> activityRule = new ActivityTestRule<DetailTvActivity>(DetailTvActivity.class) {
        @Override
        protected Intent getActivityIntent() {
            Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
            Intent result = new Intent(targetContext, DetailTvActivity.class);
            result.putExtra(DetailTvActivity.EXTRA_DATA, dummyTv.getId());
            return result;
        }
    };

    @Test
    public void loadTv() {
        onView(withId(R.id.tvTvName)).check(matches(isDisplayed()));
        onView(withId(R.id.tvTvName)).check(matches(withText(dummyTv.getName())));
        onView(withId(R.id.tvDescription)).check(matches(isDisplayed()));
        onView(withId(R.id.tvDescription)).check(matches(withText(dummyTv.getDescription())));

        onView(withId(R.id.tvEpisode)).check(matches(isDisplayed()));
        onView(withId(R.id.tvEpisode)).check(matches(withText(dummyTv.getEpisode())));

        onView(withId(R.id.tvGenre)).check(matches(isDisplayed()));
        onView(withId(R.id.tvGenre)).check(matches(withText(dummyTv.getGenre())));
        onView(withId(R.id.tvRelease)).check(matches(isDisplayed()));
        onView(withId(R.id.tvRelease)).check(matches(withText(dummyTv.getRelease())));

        onView(withId(R.id.material_icon_button)).check(matches(isDisplayed()));


        onView(withId(R.id.ratings)).check(matches(isDisplayed()));

        onView(withId(R.id.movie_photo)).check(matches(isDisplayed()));
        onView(withId(R.id.movie_photo)).check(matches(hasDrawable()));


    }

    @Test
    public void loadTvs() {
        onView(withId(R.id.rv_tv_popular)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_tv_popular)).check(new RecyclerViewItemCountAssertion(10));
    }

    @Test
    public void clickPopular(){
        onView(withId(R.id.scroll_view_detail)).perform(scrollTo(), click());
        onView(withId(R.id.rv_tv_popular)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_tv_popular)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        onView(withId(R.id.rv_tv_popular)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_tv_popular)).check(new RecyclerViewItemCountAssertion(10));
    }
}