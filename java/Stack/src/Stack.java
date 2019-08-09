/**
 * @author fengchen
 * @date 2019-08-09 16:04
 **/
public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E element);
    E pop();
    E peek();
}
