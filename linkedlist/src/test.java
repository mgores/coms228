import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class test {
    public static void main(String[] args) {
        linkedl<Integer> a = new linkedl<>();
        ArrayList<Integer> b = new ArrayList<>();
        //b.add(1);
        b.add(2);
        b.add(3);
        a.add(0);
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(2,5);
        a.remove(1);

        System.out.println(a.containsAll(b));
       /* ListIterator it = a.listIterator();
        it.next();
        System.out.println(it.previous());
        while (it.hasNext()){
            System.out.println(it.next());
        }

        */
       Object[] c = a.toArray();
       for(int i = 0; i<c.length;i++) {
           System.out.println(c[i]);
       }
    }
}
