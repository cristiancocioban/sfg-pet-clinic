package guru.springframework.sfgpetclinic.services;

import java.util.Set;

public interface CrudService<T, ID> {
    T findById(ID Id);
    T save(T object);
    void deleteById(ID id);
    void delete(T object);
    T findByName(String name);
    Set<T> findAll();
}
