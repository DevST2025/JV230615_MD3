package fakecolletion;

import java.util.Arrays;

public class MyArrayList<E> implements MyList<E> {
    private int size;
    private Object[] data = {};

    public MyArrayList() {
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    public MyArrayList(E[] objects) {
        this.data = objects;
    }

    @Override
    public void add(E e) {
        //Tăng kích thước lên 1
        Object[] newData = Arrays.copyOf(data, size + 1);
        newData[size] = e;
        size++;
        data = newData;
    }

    @Override
    public boolean remove(E e) {
        int indexDel = indexOf(e);
        if (indexDel == -1) {
            return false;
        }
        remove(indexDel);
        return true;
    }

    @Override
    public void add(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: "+index+"Size: "+size);
        }
        Object[] newData = Arrays.copyOf(data, size + 1);
        for (int i = size -1; i >= index; i--) {
            newData[i + 1] = newData[i];
        }
        newData[index] = e;
        data = newData;
        size++;
    }

    @Override
    public void clear() {
        this.data = new Object[]{};
        size = 0;
    }

    @Override
    public boolean contains(E e) {
        return indexOf(e) != -1;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: "+index+"Size: "+size);
        }
        return (E) data[index];
    }

    @Override
    public int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E e) {
        for (int i = size - 1; i >= 0; i--) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: "+index+"Size: "+size);
        }
        E e = (E) data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data = Arrays.copyOf(data, size - 1);
        size--;
        return e;
    }

    @Override
    public E set(int index, E e) {
        data[index] = e;
        return e;
    }

    @Override
    public Object[] toArr() {
        return data;
    }
}
