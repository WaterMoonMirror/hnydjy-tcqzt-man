package com.wondersgroup.hnydjytcqztman.repository;

import com.wondersgroup.hnydjytcqztman.entity.JybhDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JybhRepository extends JpaRepository<JybhDomain,Long> {
    JybhDomain findFirstByJybh(Integer jybh);
}
