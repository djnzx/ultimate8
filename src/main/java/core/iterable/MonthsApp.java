package core.iterable;

import java.util.Iterator;

public class MonthsApp {
    public static void main(String[] args) {
        Months1 months1 = new Months1();
        Months2 months2 = new Months2();

        System.out.println("print by advanced for statement (our iterator)");
        for (String m : months1) {
            System.out.println(m);
        }

        System.out.println("print by advanced for statement (iterator from List)");
        for (String m : months2) {
            System.out.println(m);
        }

        System.out.println("print by advanced for statement (our iterator), what happen under the hood");
        Iterator<String> it = months1.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("print by advanced for statement (iterator from List), what happen under the hood");
        Iterator<String> it2 = months2.iterator();
        while (it2.hasNext()) {
            System.out.println(it2.next());
        }
    }
}
