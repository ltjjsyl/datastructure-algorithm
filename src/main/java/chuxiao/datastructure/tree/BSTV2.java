package chuxiao.datastructure.tree;

public class BSTV2<E extends Comparable<E>> {

    private Node root;
    private int size;

    public BSTV2() {
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

    //null 也是二分搜素树
    //向node为根节点的二分搜索树添加元素e
    //返回插入新节点的二分搜索树
    private Node add(Node node, E e) {

        if (node == null) {
            size++;
            return new Node(e);
        }

        if (node.e.compareTo(e) < 0) {
            node.left = add(node.left, e);
        } else if (node.e.compareTo(e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }


    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (node.e.compareTo(e) == 0) {
            return true;
        } else if (node.e.compareTo(e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
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
