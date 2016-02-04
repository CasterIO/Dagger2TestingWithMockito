package io.caster.daggertesting;

import android.app.Instrumentation;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import javax.inject.Inject;

import io.caster.daggertesting.forecast.Currently;
import io.caster.daggertesting.forecast.Forecast;
import io.caster.daggertesting.forecast.ForecastService;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> main = new ActivityTestRule<>(
            MainActivity.class,
            true,
            false);   // do not launch the activity immediately

    @Inject ForecastService forecastService;

    @Before
    public void setUp() {
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        DemoApplication app
                = (DemoApplication) instrumentation.getTargetContext().getApplicationContext();
        TestingComponent component = (TestingComponent) app.getComponent();
        component.inject(this);
    }

    @Test
    public void shouldBeAbleToMockTheWeather() {
        // Set up the stub we want to return in the mock
        Forecast forecastStub = new Forecast();
        Currently currentlyStub = new Currently();
        currentlyStub.setIcon("Raining Cats and Dogs!");
        forecastStub.setCurrently(currentlyStub);

        // Set up the mock
        Mockito.when(forecastService.getMyForecast()).thenReturn(forecastStub);

        // Launch the activity
        main.launchActivity(new Intent());

        // Check that the view is what we expect it to be
        onView(withId(R.id.current_forecast)).check(matches(withText("Raining Cats and Dogs!")));
    }
}

