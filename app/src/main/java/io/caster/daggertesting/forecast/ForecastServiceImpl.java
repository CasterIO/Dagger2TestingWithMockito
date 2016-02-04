package io.caster.daggertesting.forecast;

import retrofit.RestAdapter;

public class ForecastServiceImpl implements ForecastService {
    @Override
    public Forecast getMyForecast() {
        RestAdapter adapter =
                new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint("https://api.forecast.io/forecast/8aefa5cf69cfeadcf01719c8bbf84d1b") // only 1000 api calls a day, if this breaks, get a new key, this is for demo purposes only
                .build();

        return adapter.create(ForecastApiService.class).getForecast("40.7146", "-74.0072");
    }
}
