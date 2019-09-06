package com.ronisuryadi.moviecatalogue.ui.tv;

import com.ronisuryadi.moviecatalogue.R;
import com.ronisuryadi.moviecatalogue.testing.SingleFragmentActivity;
import com.ronisuryadi.moviecatalogue.utils.RecyclerViewItemCountAssertion;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class TvFragmentTest {
    @Rule
    public ActivityTestRule<SingleFragmentActivity> activityRule = new ActivityTestRule<>(SingleFragmentActivity.class);
    private TvFragment tvFragment = new TvFragment();

    @Before
    public void setUp() {
        activityRule.getActivity().setFragment(tvFragment);
    }

    @Test
    public void loadTvs() {
        onView(withId(R.id.rv_tv)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_tv)).check(new RecyclerViewItemCountAssertion(10));
    }
}