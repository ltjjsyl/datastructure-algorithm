package chuxiao.datastructure.linear.array.myarray.v1;

/**
 * 数组包装类
 */
public class Array {

    private static final int DEFAULT_CAPACITY = 10;//TODO？
    private final int capacity;//容量 可以用data.length代替
    private final int[] data;//数据
    private int size;//实际元素个数

    //无参构造函数，默认容量为10
    public Array() {
        this(DEFAULT_CAPACITY);
    }

    //构造函数，传入参数数组容量
    public Array(int capacity) {
        //...省略了校验
        data = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public static void main(String[] args) {

        Array array = new Array(20);
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
    public void addLast(int e) {

//        if (size == capacity) {
//            throw new IllegalArgumentException("AddLast failed, array is full.");
//        }
//        data[size] = e;
//        size++;

        add(size, e);
    }

    //在所有元素的开头添加元素
    public void addFirst(int e) {
        add(0, e);
    }

    //在第index位置添加元素e
    public void add(int index, int e) {
        if (size == capacity) {
            throw new IllegalArgumentException("Add failed, array is full.");
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, require index >= 0 and index <= size.");
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size++;
    }

    //获取index位置的元素
    public int get(int index) {

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed, index is illegal.");
        }

        return data[index];
    }

    //修改index位置的元素
    public void set(int index, int e) {

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed, index is illegal.");
        }

        data[index] = e;
    }

    //返回数组是否包含元素e
    public boolean contains(int e) {

        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    //查找元素e所在位置的索引，如果找不到返回-1
    public int find(int e) {

        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    //删除index位置的元素，返回删除元素的值
    public int remove(int index) {

        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("Remove failed, index is illegal.");
        }

        int ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        return ret;
    }

    //删除开头位置的元素，返回删除元素的值
    public int removeFirst() {
        return remove(0);
    }

    //删除末尾位置的元素，返回删除元素的值
    public int removeLast() {
        return remove(size - 1);
    }

    //删除指定元素,返回void也可以
    public boolean removeElement(int e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
            return true;
        }
        //TODO ?
        return false;
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
}
