package objectPool.interfaces;

/**
 * @author Anderson Matte
 */
public interface Pool<T> {

    T acquire();

    void release(T t);
}
