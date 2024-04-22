package examples.inheritance;

public class InheritanceInterfaces implements Interface1, Interface2 {
    @Override
    public void show1() {
        System.out.println("Overridden default from I1");
    }

    /*@Override
    public void show1Static() {
        System.out.println("Overridden static from I1");
    }*/

    public static void main(String args[]) {
        InheritanceInterfaces d = new InheritanceInterfaces();
        d.show1();
        Interface1.show1Static();
        d.show2();
    }
}
