package com.alexanders.petclinic.services.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.alexanders.petclinic.model.BaseEntity;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    private final Map<Long, T> map = new HashMap<>();

    public Map<Long, T> getMap() {
        return map;
    }

    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    public T findById(ID id) {
        return map.get(id);
    }

    public T save(T t) {
        Long id = getNextId();
        t.setId(id);
        map.put(id, t);
        return t;
    }

    public void delete(T t) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(t));
    }

    public void deleteById(ID id) {
        map.remove(id);
    }

    private Long getNextId() {
        return (map.size() == 0)
                ? 1L
                : Collections.max(map.keySet()) + 1L;
    }
}
