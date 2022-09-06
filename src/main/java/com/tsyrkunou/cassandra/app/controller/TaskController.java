package com.tsyrkunou.cassandra.app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsyrkunou.cassandra.app.model.CassandraS;
import com.tsyrkunou.cassandra.app.model.CassandraLogEntity;
import com.tsyrkunou.cassandra.app.repository.EntityCassandraRepo;
import com.tsyrkunou.cassandra.app.repository.LogCassandraRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/task")
@CrossOrigin(origins = "http://localhost:8787")
@Slf4j
@RequiredArgsConstructor
public class TaskController {
    private final LogCassandraRepo logCassandraRepo;
    private final EntityCassandraRepo entityCassandraRepo;

    @PostMapping("/maketest")
    public Long performanceTest () {
        CassandraS cassandraS = new CassandraS();
        Long startPoint = System.currentTimeMillis();
        for (int i = 1; i < 5000; i++) {
            CassandraS build = CassandraS.builder()
                    .id(UUID.randomUUID())
                    .pot(i)
                    .build();
            entityCassandraRepo.save(build);
            cassandraS = build;
        }
        long l = startPoint - System.currentTimeMillis();
        logCassandraRepo.save(CassandraLogEntity.builder()
                        .id(UUID.randomUUID())
                .logInfo("Common result: " + l +", average result:  " + l/4999).build());
        cassandraS.getPot();
        return startPoint-System.currentTimeMillis();
    }

    @GetMapping("/getall")
    public List<CassandraLogEntity> getall () {
        return logCassandraRepo.findAll();
    }


}
