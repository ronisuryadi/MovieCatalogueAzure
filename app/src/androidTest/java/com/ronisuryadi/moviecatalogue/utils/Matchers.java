package com.ronisuryadi.moviecatalogue.utils;

import android.view.View;
import android.widget.ImageView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class Matchers {


    public static Matcher<View> hasDrawable() {
        return new TypeSafeMatcher<View>() {

            @Override
            public void describeTo(Description description) {

            }

            @Override
            protected boolean matchesSafely(View item) {
                ImageView imageView = (ImageView) item;
                return imageView.getDrawable() != null;
            }
        };
    }
}