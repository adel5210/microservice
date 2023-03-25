package com.adel.contentstream.repository;

import com.adel.contentstream.model.Logs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogsRepository extends CrudRepository<Logs, String> {
}
