package com.diplom.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepo <T> extends JpaRepository<T, Integer> {
}
