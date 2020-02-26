package cn.sia;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<>();

        ints.add(11);
        ints.add(22);
        ints.add(33);
        ints.add(44);
        ints.add(55);

        Assert.test(ints.size() == 5);

        System.out.println(ints);
    }
}
