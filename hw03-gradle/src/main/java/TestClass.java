import annotations.After;
import annotations.Before;
import annotations.Test;

public class TestClass {

    @Before
    public void method1() {
        System.out.println("Запущен метод с аннотацией @Before");
    }

    @Test
    public void method2() {
        System.out.println("Запущен метод с аннотацией @Test");
    }

    @Test
    public void method3() {
        System.out.println("Запущен метод с аннотацией @Test");
        throw new RuntimeException();
    }

    @After
    public void method4() {
        System.out.println("Запущен метод с аннотацией @After");
    }

}
