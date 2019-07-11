package com.wondersgroup.hnydjytcqztman.service;

import com.wondersgroup.hnydjytcqztman.entity.JybhDomain;
import com.wondersgroup.hnydjytcqztman.entity.TcqDomain;
import com.wondersgroup.hnydjytcqztman.repository.JybhRepository;
import com.wondersgroup.hnydjytcqztman.repository.TcqRepository;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.NaturalId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Log4j2
public class TcqZtServiceTest {

    @Autowired
    TcqZtService tcqZtService;
    @Autowired
    TcqRepository tcqRepository;
    @Autowired
    JybhRepository jybhRepository;

    @Test
    public void isTcqZt() {
        //
        jybhRepository.save(new JybhDomain(1101,1));
        jybhRepository.save(new JybhDomain(1104,1));
        jybhRepository.save(new JybhDomain(1601,2));
        jybhRepository.save(new JybhDomain(1602,3));

        tcqRepository.save(new TcqDomain(410200,1));
        tcqRepository.save(new TcqDomain(410300,0));
        tcqRepository.save(new TcqDomain(410400,-1));


        // 情况一  就医地河南 参保地外地
        // 410200   310000
        log.info("情况一  就医地河南 参保地外地 410200   310000");
        boolean zt = false;
        try {
            zt = tcqZtService.isTcqZt(1101, 410200, 310000, 1, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (zt){
            System.out.println("你已经被暂停业务");
        }else {
            System.out.println("你业务成功开通");
        }

        // 情况二 就医地外省  参保地河南
        log.info("情况二  就医地河南 参保地外地 310000   410200");
        try {
            zt = tcqZtService.isTcqZt(1101, 310000, 410200, 1, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (zt){
            System.out.println("你已经被暂停业务");
        }else {
            System.out.println("你业务成功开通");
        }

        // 情况三 就医地外省  参保地河南
        log.info("情况三  就医地河南 参保河南 410300   410400 没有被暂停业务");
        try {
            zt = tcqZtService.isTcqZt(1101, 410300, 410400, 1, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (zt){
            System.out.println("你已经被暂停业务");
        }else {
            System.out.println("你业务成功开通");
        }


        // 情况四 就医地外省  参保地河南
        log.info("情况四  上传类业务  就医地河南 参保河南 410300   410400 没有被暂停业务");
        try {
            zt = tcqZtService.isTcqZt(1602, 410400, 410300, 1, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (zt){
            System.out.println("你已经被暂停业务");
        }else {
            System.out.println("你业务成功开通");
        }
    }
}