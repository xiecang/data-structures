/**
 * @author fengchen
 * @date 2019-08-12 09:36
 **/
public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E element);
    E dequeue();
    E getFront();

}
