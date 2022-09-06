package com.tsyrkunou.cassandra.app.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.tsyrkunou.cassandra.app.model.CassandraS;

public interface EntityCassandraRepo extends CrudRepository<CassandraS, UUID> {
}
