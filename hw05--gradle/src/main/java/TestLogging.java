import annotations.Log;

public class TestLogging implements TestLoggingInterface{
    @Log
    @Override
    public void calculation(int param1) {
        System.out.println("Вызван calculation(int param1)");
    }

    @Log
    @Override
    public void calculation(int param1, int param2) {
        System.out.println("Вызван calculation(int param1, int param2)");
    }

    @Log
    @Override
    public void calculation(int param1, int param2, String param3) {
        System.out.println("Вызван calculation(int param1, int param2, String param3)");
    }
}
