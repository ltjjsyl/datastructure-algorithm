package chuxiao.datastructure.tree.set;

import chuxiao.datastructure.tree.BSTV2;

public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BSTV2<E> bst;

    public BSTSet() {
        bst = new BSTV2<>();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }
}
