package chuxiao.datastructure.tree;

public class BSTV1<E extends Comparable<E>> {

    private Node root;
    private int size;

    public BSTV1() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public void add(E e) {

        if (root == null) {
            root = new Node(e);
            return;
        }

        add(root, e);

    }

    //向node为根节点的二分搜索树添加元素e
    private void add(Node node, E e) {

        if (node.e.compareTo(e) == 0) {
            return;
        } else if (node.e.compareTo(e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        } else if (node.e.compareTo(e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }

        if (node.e.compareTo(e) < 0) {
            add(node.left, e);
        } else {
            add(node.right, e);
        }
    }

    private class Node {
        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }
}
