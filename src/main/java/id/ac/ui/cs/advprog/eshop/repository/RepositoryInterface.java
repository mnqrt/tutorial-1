package id.ac.ui.cs.advprog.eshop.repository;

import java.util.List;

public interface RepositoryInterface<T> {
    static int id = 0;
    T create(T inventory);
    List<T> findAll();
    T findById(String id);
    boolean delete(String id);
    T edit(T updated);
}