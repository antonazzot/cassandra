package com.tsyrkunou.cassandra.app.repository;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.tsyrkunou.cassandra.app.model.CassandraLogEntity;

public interface LogCassandraRepo extends CassandraRepository<CassandraLogEntity, UUID> {
}
