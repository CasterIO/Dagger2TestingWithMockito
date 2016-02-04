package io.caster.daggertesting.forecast;

import retrofit.http.GET;
import retrofit.http.Path;

public interface ForecastApiService {
    @GET("/{latitude},{longitude}")
    Forecast getForecast(@Path("latitude") String latitude, @Path("longitude") String longitude);
}