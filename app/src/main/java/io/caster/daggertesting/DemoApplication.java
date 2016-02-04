package io.caster.daggertesting;

import android.app.Application;

public class DemoApplication extends Application {

    private DemoComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = createComponent();
    }

    public DemoComponent createComponent() {
        return DaggerApplicationComponent.builder().demoModule(new DemoModule()).build();
    }

    public DemoComponent getComponent() {
        return component;
    }
}
