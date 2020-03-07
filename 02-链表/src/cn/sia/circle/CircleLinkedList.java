package cn.sia.circle;

import cn.sia.AbstractList;

/**
 * 双向循环链表
 * @param <E>
 */

public class CircleLinkedList<E> extends AbstractList<E> {
    private Node<E> first;
    private Node<E> last;

    private static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;

        public Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();

            if (prev != null)
                sb.append(prev.element);
            else
                sb.append("null");

            sb.append("_").append(element).append("_");

            if (next != null)
                sb.append(next.element);
            else
                sb.append("null");

            return sb.toString();
        }
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);

        if (index == size)
        {
            Node<E> oldLast = last;
            last = new Node<>(oldLast, element, first);
            if (oldLast == null) {
                first = last;
                first.next = first;
                first.prev = first;
            }
            else {
                oldLast.next = last;
                first.prev = last;
            }
        }
        else {
            Node<E> next = node(index);
            Node<E> prev = next.prev;
            Node<E> node = new Node<>(prev, element, next);
            next.prev = node;
            prev.next = node;

            if (index == 0)
                first = node;
        }

        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);

        Node<E> node = first;
        if (size == 1) {
            first = null;
            last = null;
        }
        else {
            node = node(index);
            Node<E> prev = node.prev;
            Node<E> next = node.next;
            prev.next = next;
            next.prev = prev;

            if (index == 0)
                first = next;

            if (index == (size - 1))
                last = prev;
        }

        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = first;
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (node.element == null) return i;
                node = node.next;
            }
        }
        else {
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) return i;
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    private Node<E> node (int index) {
        rangeCheck(index);

        if (index < (size >> 1)) {
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }
        else {
            Node<E> node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(", [");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            string.append(node);
            if (i != size - 1) {
                string.append(", ");
            }
            node = node.next;
        }
        string.append("]");
        return string.toString();
    }
}
