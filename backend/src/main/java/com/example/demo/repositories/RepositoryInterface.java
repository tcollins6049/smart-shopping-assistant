package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

public interface RepositoryInterface<T> {
    void insert(T entity);
    void delete(T entity);
}
