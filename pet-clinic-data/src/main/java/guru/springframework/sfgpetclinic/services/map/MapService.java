package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.BaseEntity;
import guru.springframework.sfgpetclinic.services.CrudService;

import java.util.*;

public abstract class MapService<T extends BaseEntity, ID extends Long> implements CrudService<T, ID> {
    private Map<Long, T> map;

    public MapService() {
        map = new HashMap<>();
    }

    @Override
    public T findById(ID Id) {
        return map.get(Id);
    }

    @Override
    public T save(T object) {
        if(null != object) {
            if(null == object.getId()) {
                Long id = 1L;
                if(!map.isEmpty()) {
                    id = Collections.max(map.keySet()) + 1L;
                }

                object.setId(id);
            }

            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object cannot be null");
        }

        return object;
    }

    @Override
    public void deleteById(ID Id) {
        map.remove(Id);
    }

    @Override
    public void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    @Override
    abstract public T findByName(String name);

    @Override
    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }
}
