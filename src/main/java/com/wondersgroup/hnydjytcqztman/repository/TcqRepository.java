package com.wondersgroup.hnydjytcqztman.repository;

import com.wondersgroup.hnydjytcqztman.entity.TcqDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TcqRepository extends JpaRepository<TcqDomain,Long> {
    TcqDomain findFirstByTcq(Integer tcq);
}
