package com.fapethedev.tendance.users.services;

import java.util.List;

public interface CrudService<T, V>
{
    T save(V v);

    T delete(V v);

    T findById(V v);

    List<T> findAll();
}
