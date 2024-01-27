public class App {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();


        try {
            TestRunner testRunner = new TestRunner();
            testRunner.runTestsForClass(SimpleMathLibrary.class);
        }
        catch (Exception e) {
            System.err.println("Error running tests: " + e.getMessage());
        }
        long finishTime = System.currentTimeMillis();
        long duration = finishTime - startTime;
        System.out.println("Test run finished after " + duration + " ms");
    }

}
