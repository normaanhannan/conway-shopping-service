package normaan.org.conway.service;

import org.junit.jupiter.api.*;

public class SampleJUnitTest {

    //this runs ONLY ONCE before all tests
    @BeforeAll
    public static void beforeAll() {
        System.out.println("beforeAll()");
    }

    // this will run before each test (ie: methods annotated with @Test)
    @BeforeEach
    public void beforeEach() {
        System.out.println("beforeEach()");
    }

    @Test
    public void test1() {
        System.out.println("test1()");
    }

    @Test
    public void test2() {
        System.out.println("test2()");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("afterEach()");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("afterAll()");
    }


}