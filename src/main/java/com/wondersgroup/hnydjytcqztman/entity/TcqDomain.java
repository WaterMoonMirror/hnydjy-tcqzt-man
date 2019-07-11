package com.wondersgroup.hnydjytcqztman.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TcqDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lsh;
    // 统筹区编码
    private Integer tcq;
    private Integer yxbz;

    public TcqDomain(Integer tcq, Integer yxbz) {
        this.tcq = tcq;
        this.yxbz = yxbz;
    }
}
