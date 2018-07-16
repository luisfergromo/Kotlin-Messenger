package me.luisfergromo.kotlinmessenger


import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.runner.AndroidJUnit4
import org.hamcrest.Matchers.allOf
import org.junit.Test
import org.junit.runner.RunWith


/*
@RunWith (AndroidJUnit4::class)
@LargeTest
class testingFlow{

    @Rule
    public ActivityTestRule<MainActivity> mainActivityTestRule =
    new ActivityTestRule<>(MainActivity.class)

    @Test
    fun loginTest(){
        onView(withId(R.id.loginBtn)).perform(click());
    }


}
*/
@RunWith (AndroidJUnit4::class)
class UITest {
    //@Rule
    //class ActivityTestRule<MainActivity>
    /* README
     * https://stackoverflow.com/questions/37821148/why-cannot-i-import-androidjunit4-and-activitytestrule-into-my-unit-test-class */
    @Test
    fun textView() {
       onView(allOf(withId(R.id.textView)))
               .check(matches(isDisplayed()));
        //onView(withItemText("LOGIN")).check(matches(isDisplayed()))
        //onView(withId(R.id.registerBtn)).perform(click())
        //onView(withId(R.id.loginBtn)).check(matches(isDisplayed()))
    }
    /*
    @Test
    fun loginBtn(){
        onView(withText("LOGIN"))
                .check(matches(isDisplayed()))
                .perform(click());
    }
    @Test
    fun registerBtn(){
        onView(withId(R.id.registerBtn))
                .check(matches(isDisplayed()))
                .perform(click())
    }*/
    @Test
    fun usernameHint(){
        onView(withText("Username:"))
                .check(matches(isDisplayed()));
    }
    @Test
    fun emailHint(){
        onView(withText("Email:"))
                .check(matches(isDisplayed()))
    }
    @Test
    fun passwordHint(){
        onView(withText("Password:"))
                .check(matches(isDisplayed()))
    }
}