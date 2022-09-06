package com.tsyrkunou.cassandra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import com.tsyrkunou.cassandra.app.repository.EntityCassandraRepo;
import com.tsyrkunou.cassandra.app.repository.LogCassandraRepo;

@EnableCassandraRepositories(basePackageClasses ={LogCassandraRepo.class, EntityCassandraRepo.class})
@SpringBootApplication
public class CassandraApplication {

	public static void main(String[] args) {
		SpringApplication.run(CassandraApplication.class, args);
	}

}
