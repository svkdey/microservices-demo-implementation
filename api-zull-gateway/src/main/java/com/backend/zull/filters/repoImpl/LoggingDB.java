package com.backend.zull.filters.repoImpl;

import org.springframework.data.repository.CrudRepository;

import com.backend.zull.filters.models.LogginDeatils;

public interface LoggingDB extends CrudRepository<LogginDeatils, Long> {

}
