package chuxiao.datastructure.linear.list.v2;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2, 333);
        System.out.println(linkedList);

        linkedList.set(5, 33);
        System.out.println(linkedList);

        linkedList.remove(5);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);

        System.out.println(linkedList.contains(3));
    }
}
