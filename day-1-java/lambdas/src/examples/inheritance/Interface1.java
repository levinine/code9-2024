package examples.inheritance;

public interface Interface1 {
    // Default method
    default void show1() {
        System.out.println("Default I1");
    }

    // Static method
    static void show1Static() {
        System.out.println("Static I1");
    }
}
