package cn.sia;

/**
 * 有动态缩容操作
 * @param <E>
 */

public class ArrayList2<E> extends AbstractList<E> {
    private E[] elements;

    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList2(int capacity) {
        capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
        elements = (E[]) new Object[capacity];
    }

    public ArrayList2() {
        this(DEFAULT_CAPACITY);
    }

    public E remove (int index) {
        rangeCheck(index);

        E old = elements[index];
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        elements[--size] = null;
        trim();
        return old;
    }

    public void remove (E element) {
        remove(indexOf(element));
    }

    public void add (int index, E element) {
        rangeCheckForAdd(index);

        ensureCapacity(size + 1);

        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    public int indexOf (E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null)
                    return i;
            }
        }
        else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i]))
                    return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    public void clear () {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public E set (int index, E element) {
        rangeCheck(index);
        E old = elements[index];
        elements[index] = element;
        return old;
    }

    public E get (int index) {
        rangeCheck(index);
        return elements[index];
    }

    private void ensureCapacity (int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;

        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;

        System.out.println(oldCapacity + "扩容为：" + newCapacity);
    }

    private void trim () {
        int oldCapacity = elements.length;
        int newCapacity = oldCapacity >> 1;
        if ((size >= newCapacity) || (oldCapacity <= DEFAULT_CAPACITY)) return;

        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;

        System.out.println(oldCapacity + "缩容为：" + newCapacity);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(", [");
        for (int i = 0; i < size; i++) {
            string.append(elements[i]);
            if (i != size - 1) {
                string.append(", ");
            }
        }
        string.append("]");
        return string.toString();
    }

}
