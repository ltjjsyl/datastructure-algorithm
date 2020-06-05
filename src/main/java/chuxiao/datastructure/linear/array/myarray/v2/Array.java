package chuxiao.datastructure.linear.array.myarray.v2;

/**
 * 数组包装类
 */
public class Array<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private int capacity;//容量 可以用data.length代替
    private E[] data;//数据
    private int size;//实际元素个数

    //无参构造函数，默认容量为10
    public Array() {
        this(DEFAULT_CAPACITY);
    }

    public Array(E[] arr) {

        capacity = arr.length;
        data = (E[]) new Object[capacity];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        size = arr.length;

    }

    //构造函数，传入参数数组容量
    public Array(int capacity) {
        //...省略了校验
        data = (E[]) new Object[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public static void main(String[] args) {

        Array<Integer> array = new Array<>(10);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);

        array.addFirst(-1);
        System.out.println(array);

        array.add(1, 100);
        System.out.println(array);

        array.set(8, 20);
        System.out.println(array);

        array.remove(2);
        System.out.println(array);

        array.removeElement(5);
        System.out.println(array);

        array.removeFirst();
        System.out.println(array);

        array.removeLast();
        System.out.println(array);

        System.out.println(array.get(5));
    }

    //获取数组中元素个数
    public int getSize() {
        return this.size;
    }

    //返回数组的容量
    public int getCapacity() {
        return this.capacity;
    }

    //返回数组是否为空
    public boolean isEmpty() {
        return this.size == 0;
    }

    //在所有元素的末尾添加元素
    public void addLast(E e) {

//        if (size == capacity) {
//            throw new IllegalArgumentException("AddLast failed, array is full.");
//        }
//        data[size] = e;
//        size++;

        add(size, e);
    }

    //在所有元素的开头添加元素
    public void addFirst(E e) {
        add(0, e);
    }

    //在第index位置添加元素e
    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, require index >= 0 and index <= size.");
        }

        if (size == capacity) {
            resize(capacity * 2);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size++;
    }

    //获取index位置的元素
    public E get(int index) {

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed, index is illegal.");
        }

        return data[index];
    }

    public E getLast() {
        return get(size - 1);
    }

    public E getFirst() {
        return get(0);
    }

    //修改index位置的元素
    public void set(int index, E e) {

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed, index is illegal.");
        }

        data[index] = e;
    }

    //返回数组是否包含元素e
    public boolean contains(E e) {

        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    //查找元素e所在位置的索引，如果找不到返回-1
    public int find(E e) {

        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    //删除index位置的元素，返回删除元素的值
    public E remove(int index) {

        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("Remove failed, index is illegal.");
        }

        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null; //loitering objects != memory leak

        if (size == capacity / 4 && capacity / 2 != 0) {
            resize(capacity / 2);
        }
        return ret;
    }

    //删除开头位置的元素，返回删除元素的值
    public E removeFirst() {
        return remove(0);
    }

    //删除末尾位置的元素，返回删除元素的值
    public E removeLast() {
        return remove(size - 1);
    }

    //删除指定元素,返回void也可以
    public boolean removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    public void swap(int i, int j) {

        if (i < 0 || i > size - 1 || j < 0 || j > size - 1) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, capacity));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
        capacity = newCapacity;
    }
}
