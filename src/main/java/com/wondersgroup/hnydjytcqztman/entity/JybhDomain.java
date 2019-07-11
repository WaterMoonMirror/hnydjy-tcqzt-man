package com.wondersgroup.hnydjytcqztman.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.omg.CORBA.INTERNAL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JybhDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lsh;
    // 交易编号
    private Integer jybh;
   private Integer jylx;

    public JybhDomain(Integer jybh, Integer jylx) {
        this.jybh = jybh;
        this.jylx = jylx;
    }
}
