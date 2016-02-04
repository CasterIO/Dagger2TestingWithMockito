package io.caster.daggertesting;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

import io.caster.daggertesting.forecast.Forecast;
import io.caster.daggertesting.forecast.ForecastService;

public class MainActivity extends AppCompatActivity {

    @Inject ForecastService forecastService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((DemoApplication)getApplication()).getComponent().inject(this);

        final TextView currentForecast = (TextView) findViewById(R.id.current_forecast);

        new AsyncTask<Void, Void, Forecast>() {

            @Override
            protected Forecast doInBackground(Void... params) {
                return forecastService.getMyForecast();
            }

            @Override
            protected void onPostExecute(Forecast forecast) {
                super.onPostExecute(forecast);
                currentForecast.setText(forecast.getCurrently().getIcon());
            }
        }.execute();

    }
}
