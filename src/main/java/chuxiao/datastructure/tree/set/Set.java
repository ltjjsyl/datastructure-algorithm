package chuxiao.datastructure.tree.set;

public interface Set<E> {

    boolean isEmpty();

    int getSize();

    boolean contains(E e);

    void add(E e);

    void remove(E e);
}
