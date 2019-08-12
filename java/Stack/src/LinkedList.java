/**
 * @author fengchen
 * @date 2019-08-12 17:03
 **/
public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    /**
     * @return 链表中元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * @return 链表是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表的 index(0-based) 位置添加新的元素 element
     * 在链表中不是一个常用的操作，练习用:)
     *
     * @param index   索引位置
     * @param element 待添加新元素
     */
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
//            Node node = new Node(element, prev.next);
//            node.next = prev.next;
//            prev.next = node;
        prev.next = new Node(element, prev.next);

        size++;

    }

    /**
     * 在链表头添加新的元素 element
     *
     * @param element 新元素
     */
    public void addFirst(E element) {
//        Node node = new Node(element);
//        node.next = head;
//        head = node;
        add(0, element);
    }

    /**
     * 在链表末尾添加新的元素 element
     *
     * @param element 待添加新元素
     */
    public void addLast(E element) {
        add(size, element);
    }

    /**
     * 在链表的 index(0-based) 位置添加新的元素 element
     * 在链表中不是一个常用的操作，练习用:)
     *
     * @param index 索引位置
     */
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * @return 返回链表的第一个元素
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * @return 返回链表的最后一个元素
     */
    public E getLast() {
        return get(size - 1);
    }


    /**
     * 修改链表的第index(0-based)个位置的元素为 element
     * 在链表中不是一个常用的操作，练习用:)
     *
     * @param index   元素索引
     * @param element 待修改元素
     */
    public void set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = element;
    }

    /**
     * @param element 待查找元素
     * @return 查找链表中是否有元素 element
     */
    public boolean contains(E element) {

        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(element)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * @param index 待删除元素
     * @return 从链表中删除index(0 - based)位置的元素, 返回删除的元素
     * 在链表中不是一个常用的操作，练习用:)
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        }

        Node prev = dummyHead.next;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;

        return retNode.e;
    }

    /**
     * @return 第一个节点
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * @return 最后一个节点
     */
    public E removeLast() {
        return remove(size - 1);
    }


    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();

        //        Node cur = dummyHead.next;
//        while(cur != null){
//            res.append(cur + "->");
//            cur = cur.next;
//        }
        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            res.append(cur + "->");
        }
        res.append("NULL");

        return res.toString();
    }

}