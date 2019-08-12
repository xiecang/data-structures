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

    private Node head;
    int size;

    public LinkedList() {
        head = null;
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
     * 在链表头添加新的元素 element
     *
     * @param element 新元素
     */
    public void addFirst(E element) {
//        Node node = new Node(element);
//        node.next = head;
//        head = node;
        head = new Node(element, head);
        size++;
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

        if (index == 0) {
            addFirst(element);
        } else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
//            Node node = new Node(element, prev.next);
//            node.next = prev.next;
//            prev.next = node;
            prev.next = new Node(element, prev.next);

            size++;
        }
    }

    /**
     * 在链表末尾添加新的元素 element
     * @param element 待添加新元素
     */
    public void addLast(E element) {
        add(size, element);
    }
}
