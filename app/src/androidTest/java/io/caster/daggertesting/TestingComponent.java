package io.caster.daggertesting;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { MockDemoModule.class })
public interface TestingComponent extends DemoComponent {
    void inject(MainActivityTest target);
}