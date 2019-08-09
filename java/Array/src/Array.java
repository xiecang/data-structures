/**
 * @author fengchen
 * @date 2019-08-08 17:12
 **/
public class Array {

    private int[] data;
    private int size;

    /**
     * 构造函数，传入数组的容量 capacity 构造 Array
     *
     * @param capacity 数组的容量
     */
    public Array(int capacity) {
        data = new int[capacity];
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
    public void addLast(int element) {
        int index = size;
        add(index, element);
    }

    /**
     * 向所有元素前添加一个新元素
     *
     * @param element 待添加元素
     */
    public void addFirst(int element) {
        int index = size;
        add(index, element);
    }

    /**
     * 在 index 索引的位置插入一个新元素 element
     *
     * @param index   索引
     * @param element 待添加元素
     */
    public void add(int index, int element) {

        if (size == data.length)
            throw new IllegalArgumentException("Add failed. Array is full.");

        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");

        for (int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];

        data[index] = element;

        size++;
    }

    /**
     * 获取 index 位置的元素
     * @param index 索引
     * @return 元素值
     */
    int get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        return data[index];
    }


    /**
     * 修改 index 索引位置的元素为 element
     * @param index 索引
     * @param element 修改为 element
     */
    public void set(int index, int element){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        data[index] = element;
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
}
