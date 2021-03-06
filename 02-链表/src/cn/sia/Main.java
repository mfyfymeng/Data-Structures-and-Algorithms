package cn.sia;

import cn.sia.circle.CircleLinkedList;
import cn.sia.circle.SingleCircleLinkedList;

public class Main {

    static void testList (List<Integer> list) {
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);

        list.add(0, 55);
        list.add(2, 66);
        list.add(list.size(), 77);

        list.remove(0);
        list.remove(2);
        list.remove(list.size() - 1);

        Asserts.test(list.indexOf(44) == 3);
        Asserts.test(list.indexOf(22) == List.ELEMENT_NOT_FOUND);
        Asserts.test(list.contains(33));
        Asserts.test(list.get(0) == 11);
        Asserts.test(list.get(1) == 66);
        Asserts.test(list.get(list.size() - 1) == 44);

        System.out.println(list);
    }

    public static void main(String[] args) {
//        testList(new ArrayList<>());
//        testList(new LinkedList<>());

//        testList(new SingleCircleLinkedList<>());

        testList(new CircleLinkedList<>());

    }
}
