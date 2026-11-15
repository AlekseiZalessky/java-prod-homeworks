public class Homework {
    static void main() {
        TestLoggingInterface test = Params.wrap(new TestLogging(), TestLoggingInterface.class);
        test.calculation(1);
        test.calculation(1, 2);
        test.calculation(1, 2, "3");
    }
}
