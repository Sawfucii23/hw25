import org.junit.platform.engine.DiscoverySelector;
import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;

import java.util.Arrays;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;

public class TestRunner {
    private final Launcher launcher;

    public TestRunner() {
        this.launcher = LauncherFactory.create();
    }

    public void runTestsForClass(String className) throws ClassNotFoundException {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(selectClass(Class.forName(className)))
                .build();
        launcher.execute(request);
    }


    public void runTestsForClass(Class cls) {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(selectClass(cls))
                .build();
        launcher.execute(request);
    }


    public void runTestsForClassNames(String... classNames) {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(Arrays.stream(classNames)
                        .map(DiscoverySelectors::selectClass)
                        .toArray(DiscoverySelector[]::new))
                .build();
        launcher.execute(request);
    }


    public void runTestsForClasses(Class<?>... classes) {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(Arrays.stream(classes)
                        .map(DiscoverySelectors::selectClass)
                        .toArray(DiscoverySelector[]::new))
                .build();
        launcher.execute(request);
    }

    public void runTestsInPackage(String packageName) {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(selectPackage(packageName))
                .build();
        launcher.execute(request);
    }
}
