import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class linkedl<T> implements List<T> {
int lindex = 0;
UnsupportedOperationException a;
IndexOutOfBoundsException e;
    public class linkedlistiterator<T> implements ListIterator <T> {
        linkedl<T>.node<T> current;
        int index =0;
        public linkedlistiterator(linkedl<T> list){
            current = list.getHead();
        }
        public linkedlistiterator(linkedl<T> list, int index){
            current = list.getHead();
            lindex = index;
        }
        public T current(){
            return current.getdata();
        }


        @Override
        public boolean hasNext() {
            if(current.next!=null && lindex<size) return true;
            return false;
        }

        @Override
        public T next() {
            if(!hasNext()){ return null;}
            else{
                lindex++;
                current=current.next;
                return current.getdata();
            }
        }

        @Override
        public boolean hasPrevious() {
            if(current!=head) return true;
            return false;
        }

        @Override
        public T previous() {
            if(hasPrevious()) {
                current = current.prev;
                lindex--;
                return current.getdata();
            }
            return null;
        }

        @Override
        public int nextIndex() {
            if(lindex == size){
                return size;
            }
            int index = lindex + 1;
            return index;
        }

        @Override
        public int previousIndex() {
            if (lindex==0){
                return -1;
            }
            int index = lindex - 1;
            return index;
        }

        @Override
        public void remove() {
            throw a;

        }

        @Override
        public void set(T t) {
            throw a;

        }

        @Override
        public void add(T t) {
            throw a;

        }
    }
    public class node<T>{
        T data;
        node next;
        node prev;
        node (T a){
            data = a;
        }
        public node getNext() {
            return next;
        }

        public node getPrev() {
            return prev;
        }
        public T getdata(){
            return data;
        }
    }
    private node head = new node(null);
    private node tail = new node(null);
    int size = 0;
    public linkedl(){
        head = null;
        size =  0;
    }
    public node<T> getHead(){ return head;}
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean contains(Object o) {
        node a = head;
        for(int i = 0; i<size; i++){
            if(o==a.getdata()){
                return true;
            }
            a= a.next;
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new linkedlistiterator(this);
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        node<T> temp = head;
        for(int i=0; i<size;i++){
            arr[i] = temp.getdata();
            temp = temp.next;
        }

        return arr;
    }

    @Override
    public boolean add(T o) {
        node newnode = new node<>(o);
        node temp = tail;
        if(size == 0){
            tail = newnode;
            head = newnode;
            newnode.next = null;
            newnode.prev = null;
            size ++;
            return true;
        }
        if(size > 0) {
            newnode.next = null;
            newnode.prev = temp;
            temp.next = newnode;
            tail = newnode;
            size++;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        if(indexOf(o)!=-1){
            int a = indexOf(o);
            remove(a);
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if(head!=null){
            for(T a:c){
                add(a);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        int i =index;
        for (T a:c){
            add(i,a);
            i++;
        }
        return true;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;

    }

    @Override
    public T get(int index) {
        node<T> temp = head;
        for(int i = 0; i<index;i++){
            temp=temp.next;
        }
        return temp.getdata();
    }

    @Override
    public T set(int index, T element) {
        node<T> temp = head;
        if(index<0|index>=size){
            throw e;
        }
        for(int i= 0;i<index;i++){
            temp=temp.next;
        }
        T a = temp.data;
        temp.data = element;
        return a;
    }

    @Override
    public void add(int index, Object element) {
        node<T> temp = head;
        node<T> newnode = new node(element);
        if(index<0|index>size) {
            throw e;
        }
        for(int i= 0;i<index-1;i++){
            temp=temp.next;
        }
        newnode.next = temp.next;
        newnode.prev = temp;
        temp.next.prev = newnode;
        temp.next = newnode;

        size++;


    }

    @Override
    public T remove(int index) {
        if(isEmpty()) {
            return null;
        }
        node<T> temp = head;
        for(int i= 0;i<index;i++){
            temp=temp.next;
        }
        T data = temp.getdata();
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        size --;
        return data;
    }

    @Override
    public int indexOf(Object o) {
        node<T> temp = head;
        int index = 0;
        for(int i=0;i<size;i++) {
            if (temp.getdata() == o) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        node<T> temp=head;
        int index=0;
        int index1=-1;
        for(int i=0;i<size;i++) {
            if(temp.getdata()==o) {
                index1=index;
            }
            temp=temp.next;
            index++;

        }
        return index1;
    }

    @Override
    public ListIterator listIterator() {
        linkedlistiterator a = new linkedlistiterator(this);
        return a;
    }

    @Override
    public ListIterator listIterator(int index) {
        linkedlistiterator a = new linkedlistiterator(this,index);
        return a;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        throw  a;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        node<T> temp=head;
        for(Object a:c) {
            for(int i =0;i<size;i++) {
                if(temp.getdata()!=a) {
                    remove(temp);
                }
                temp=temp.next;
            }
            return true;
        }
        return false;
    }


    @Override
    public boolean removeAll(Collection<?> c) {
        for(Object a:c) {
            if(contains(a)) {
                remove(a);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        node<T> temp=head;

            for(Object a:c) {
                if(!contains(a)) {
                    return false;
                }
            temp=temp.next;
        }
        return true;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        node<T> temp = head;
        for(int i=0;i<size;i++) {
            a[i]=(T) temp.getdata();
            temp=temp.next;
        }
        return a;
    }
}
