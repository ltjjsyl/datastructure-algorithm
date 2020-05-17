package chuxiao.datastructure.tree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BSTV2<E extends Comparable<E>> {

    private Node root;
    private int size;

    public BSTV2() {
        root = null;
        size = 0;
    }

    public static void main(String[] args) {
        BSTV2<Integer> bst = new BSTV2<>();
        int[] nums = {5, 3, 6, 8, 4, 2};

        for (int i = 0; i < nums.length; i++) {
            bst.add(nums[i]);
        }

        System.out.println(bst);

        bst.levelOrder();
        System.out.println();

        bst.preOrderNR();
        System.out.println();

        bst.preOrder();
        System.out.println();

        bst.inOrder();
        System.out.println();

        bst.postOrder();
        System.out.println();

        System.out.println(bst.maximumNR());
        System.out.println(bst.maximum());
        System.out.println(bst.minimumNR());
        System.out.println(bst.minimum());

        int size = bst.size;
        for (int i = 0; i < size; i++) {
            System.out.print(bst.removeMin() + " ");
        }

        System.out.println();

        for (int i = 0; i < nums.length; i++) {
            bst.add(nums[i]);
        }
        size = bst.size;
        for (int i = 0; i < size; i++) {
            System.out.print(bst.removeMax() + " ");
        }

        System.out.println();
        for (int i = 0; i < nums.length; i++) {
            bst.add(nums[i]);
        }
        bst.remove(9);
        System.out.println(bst);

        bst.remove(4);
        System.out.println(bst);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root, e);
    }

    //null 也是二分搜素树
    //向node为根节点的二分搜索树添加元素e
    //返回插入新节点的二分搜索树
    private Node add(Node node, E e) {

        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
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

    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node cur = queue.remove();

            System.out.println(cur.e);

            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    public void preOrderNR() {

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);

            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {

        if (node == null) {
            return;
        }

        System.out.println(node.e);

        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {

        if (node == null) {
            return;
        }

        //操作点

        inOrder(node.left);

        //操作点
        System.out.println(node.e);

        inOrder(node.right);

        //操作点
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {

        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);

        System.out.println(node.e);
    }

    public E minimumNR() {

        if (isEmpty()) {
            throw new IllegalStateException("BST is empty.");
        }

        Node cur = root;

        while (cur.left != null) {
            cur = cur.left;
        }
        return cur.e;
    }

    public E minimum() {

        if (isEmpty()) {
            throw new IllegalStateException("BST is empty.");
        }

        return minimum(root).e;
    }

    //返回node为根的最小节点
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }

        return minimum(node.left);
    }

    public E maximumNR() {

        if (isEmpty()) {
            throw new IllegalStateException("BST is empty.");
        }

        Node cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }

        return cur.e;
    }

    public E maximum() {

        if (isEmpty()) {
            throw new IllegalStateException("BST is empty.");
        }

        return maximum(root).e;
    }

    //返回node为根的最大节点
    private Node maximum(Node node) {

        if (node.right == null) {
            return node;
        }

        return maximum(node.right);
    }

    public E removeMin() {

        Node ret = minimum(root);
        root = removeMin(root);
        return ret.e;
    }

    //返回删除node为根的最小节点后的根
    private Node removeMin(Node node) {

        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax() {
        Node ret = maximum(root);
        root = removeMax(root);
        return ret.e;
    }

    //返回删除node为根的最小节点后的根
    private Node removeMax(Node node) {

        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {

        if (node == null) {
            return null;
        }

        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {
            //删除节点的左子树为空
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            //删除的节点的右子树为空
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            //删除节点的左右节点都不为空
            //找到比删除节点大的最小节点，即删除节点右子树的最小节点
            //用这个节点顶替删除的节点
            //使用前驱节点也可以
            Node successor = minimum(node.right);//val同时要拿到
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = null;
            node.right = null;
            return successor;
        }
    }

    //前序遍历
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        toString(root, 0, res);
        return res.toString();
    }

    private void toString(Node node, int depth, StringBuilder res) {

        if (node == null) {
            res.append(generateDepthString(depth)).append("null\n");
            return;
        }

        res.append(generateDepthString(depth)).append(node.e).append("\n");

        toString(node.left, depth + 1, res);
        toString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }

        return res.toString();
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
