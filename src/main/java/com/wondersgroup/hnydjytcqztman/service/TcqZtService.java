package com.wondersgroup.hnydjytcqztman.service;

import com.wondersgroup.hnydjytcqztman.entity.JybhDomain;
import com.wondersgroup.hnydjytcqztman.entity.TcqDomain;
import com.wondersgroup.hnydjytcqztman.repository.JybhRepository;
import com.wondersgroup.hnydjytcqztman.repository.TcqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TcqZtService {
    @Autowired
    JybhRepository jybhRepository;

    @Autowired
    TcqRepository tcqRepository;

    public boolean isTcqZt(Integer jybh,Integer jyd,Integer cbd,Integer tdlx,Integer ydbs) throws Exception {
        JybhDomain jybhDomain = jybhRepository.findFirstByJybh(jybh);
        if (jybhDomain == null) {
            throw new Exception("没有查询到有效交易编号！");
        }
        // 类型一   参保地
        if (jybhDomain.getJylx()==3){
            TcqDomain tcqDomain = tcqRepository.findFirstByTcq(jyd);
            if (tcqDomain!=null&&tcqDomain.getYxbz()>=0)return  true;
        }else if(jybhDomain.getJylx()==2){ // 就医地
            TcqDomain tcqDomain = tcqRepository.findFirstByTcq(jyd);
            if (tcqDomain!=null&&tcqDomain.getYxbz()<=0)return  true;
        }else {
            TcqDomain tcqDomain = tcqRepository.findFirstByTcq(jyd);
            if (tcqDomain!=null&&tcqDomain.getYxbz()<=0)return  true;
             tcqDomain = tcqRepository.findFirstByTcq(cbd);
            if (tcqDomain!=null&&tcqDomain.getYxbz()>=0)return  true;
        }
        return false;
    }
}
