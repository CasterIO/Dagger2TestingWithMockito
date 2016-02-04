package io.caster.daggertesting;

import org.mockito.Mockito;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.caster.daggertesting.forecast.ForecastService;

@Module
public class MockDemoModule {
    @Provides @Singleton
    public ForecastService providesForecastService() {
        return Mockito.mock(ForecastService.class);
    }
}
