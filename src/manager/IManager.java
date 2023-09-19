package manager;

import java.util.List;

public interface IManager<E> {
    void add(E e);

    void edit(int code, E e);

    void remove(int code);

    List<E> findAll();
}
