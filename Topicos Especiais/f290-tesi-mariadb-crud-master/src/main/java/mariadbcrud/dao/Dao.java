package mariadbcrud.dao;

import java.util.List;

public interface Dao<T> {
    //TODO: Adicionar metodos para os metodos comuns aos Daos que venham a ser implementados
    void insert(T t);
    T update(T t);
    void delete(Integer id);
    T findById(Integer id);
    List<T> findAll();
}
