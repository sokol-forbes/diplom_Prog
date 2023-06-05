package com.diplom.server.service.impl;

import com.diplom.server.repository.BaseRepo;
import com.diplom.server.service.CrudOperations;
import lombok.NoArgsConstructor;
import lombok.NonNull;

public abstract class GenericServiceImpl <T> implements CrudOperations<T> {

@NonNull
protected BaseRepo<T> repo;
}
