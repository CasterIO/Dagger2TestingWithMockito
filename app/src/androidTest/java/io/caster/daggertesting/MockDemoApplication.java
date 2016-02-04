package io.caster.daggertesting;

public class MockDemoApplication extends DemoApplication {

    @Override
    public DemoComponent createComponent() {
        return DaggerTestingComponent.builder()
                .mockDemoModule(new MockDemoModule()).build();
    }
}
