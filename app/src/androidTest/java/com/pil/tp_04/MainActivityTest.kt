package com.pil.tp_04

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.pil.tp_04.activity.MainActivity
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun onPressIncUpdateCounter() {
        Espresso.onView(withId(R.id.input_count)).perform(ViewActions.typeText(FIVE))
        Espresso.onView(withId(R.id.increment)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.counter)).check(ViewAssertions.matches(ViewMatchers.withText(FIVE)))
    }

    @Test
    fun onPressDecUpdateCounter() {
        Espresso.onView(withId(R.id.input_count)).perform(ViewActions.typeText(FIVE))
        Espresso.onView(withId(R.id.decrement)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.counter)).check(ViewAssertions.matches(ViewMatchers.withText(MINUS_FIVE)))
    }

    @Test
    fun onPressResetUpdateCounter() {
        Espresso.onView(withId(R.id.reset)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.counter)).check(ViewAssertions.matches(ViewMatchers.withText(ZERO)))
    }

    companion object {
        private const val ZERO = "0"
        private const val MINUS_FIVE = "-5"
        private const val FIVE = "5"
    }
}
