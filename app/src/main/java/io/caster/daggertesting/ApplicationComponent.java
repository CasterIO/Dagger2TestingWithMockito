package io.caster.daggertesting;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { DemoModule.class })
public interface ApplicationComponent extends DemoComponent {

}
