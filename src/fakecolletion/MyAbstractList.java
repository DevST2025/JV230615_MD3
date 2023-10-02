package fakecolletion;

public abstract class MyAbstractList<E> {
    private int size;

    public MyAbstractList() {
    }

    public MyAbstractList(E[] object) {
    }

    public abstract void add(E e);
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }

    public abstract boolean remove(E e);
    int setSize() {
        return size;
    }
}
