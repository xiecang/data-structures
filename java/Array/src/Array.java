/**
 * @author fengchen
 * @date 2019-08-08 17:12
 **/
public class Array<E> {

    private E[] data;
    private int size;

    /**
     * 构造函数，传入数组的容量 capacity 构造 Array
     *
     * @param capacity 数组的容量
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参数的构造函数，默认数组的容量 capacity = 10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组的容量
     *
     * @return 数组的容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 获取数组中的元素个数
     *
     * @return 数组中的元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 返回数组是否为空
     *
     * @return 返回数组是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向所有元素后添加一个新元素
     *
     * @param element 待添加元素
     */
    public void addLast(E element) {
        int index = size;
        add(index, element);
    }

    /**
     * 向所有元素前添加一个新元素
     *
     * @param element 待添加元素
     */
    public void addFirst(E element) {
        int index = size;
        add(index, element);
    }

    /**
     * 在 index 索引的位置插入一个新元素 element
     *
     * @param index   索引
     * @param element 待添加元素
     */
    public void add(int index, E element) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");

        if (size == data.length)
            resize(2 * data.length);

        for (int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];

        data[index] = element;

        size++;
    }

    /**
     * 获取 index 位置的元素
     *
     * @param index 索引
     * @return 元素值
     */
    E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        return data[index];
    }


    /**
     * 修改 index 索引位置的元素为 element
     *
     * @param index   索引
     * @param element 修改为 element
     */
    public void set(int index, E element) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        data[index] = element;
    }

    /**
     * 查找数组中是否有元素 element
     *
     * @param element 待查找元素
     * @return 是否存在
     */
    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素 element 所在的索引，如果不存在元素e，则返回-1
     *
     * @param element 待查找元素
     * @return 元素所在索引，不存在返回 -1
     */
    public int find(E element) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 从数组中删除 index 位置的元素, 返回删除的元素
     *
     * @param index 待删除的位置
     * @return 被删除的元素
     */
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");

        E ret = data[index];

        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        // loitering objects
        data[size] = null;

        int newCapacity = data.length / 2;
        if (size == newCapacity) {
            resize(newCapacity);
        }
        return ret;
    }

    /**
     * 从数组中删除第一个元素, 返回删除的元素
     *
     * @return 被删除的元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 从数组中删除最后一个元素, 返回删除的元素
     *
     * @return 被删除的元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 从数组中删除元素 element
     *
     * @param element 待删除的元素
     */
    public void removeElement(E element) {
        int index = find(element);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }

    /**
     * 将数组空间的容量变成 newCapacity 大小
     * @param newCapacity 新的数组容量
     */
    private void resize(int newCapacity){

        E[] newData = (E[])new Object[newCapacity];
        for(int i = 0 ; i < size ; i ++)
            newData[i] = data[i];
        data = newData;
    }
}
