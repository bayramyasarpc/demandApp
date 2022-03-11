package yte.parttime.demandApp.deneme;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class GreetingTest {

   private Greeting greeting;

    @BeforeAll
    static void beforeClass(){
        System.out.println("Before-I am only called once!!!");
    }

    @BeforeEach
    void setUp() {
        System.out.println("In before each ....");
        greeting =new Greeting();
    }

    @Test
    void helloWorld() {
        System.out.println(greeting.helloWorld());
    }
    @Test
    void HelloWorld1() {
        System.out.println(greeting.helloWorld("bayram"));
    }
    @Test
    void HelloWorld2() {
        System.out.println(greeting.helloWorld("dlr"));
    }

    @AfterEach
    void tearDown() {
        System.out.println("In after each .....");
    }
    @AfterAll
    static void afterAll() {
        System.out.println("After - I am only called once!!!!");
    }


}