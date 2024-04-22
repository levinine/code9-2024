package examples.comparator;

import java.util.Comparator;

public class MyComparator implements Comparator<Developer> {
    public int compare(Developer d1, Developer d2) {
        return d1.getAge() - d2.getAge();
    }
}
