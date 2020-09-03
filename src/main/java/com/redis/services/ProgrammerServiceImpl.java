package com.redis.services;

import com.redis.dao.ProgrammerRepository;
import com.redis.model.Programmer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProgrammerServiceImpl implements  ProgrammerService{

    @Autowired
    private ProgrammerRepository programmerRepository;

    @Override
    public void setProgrammerAsString(String idKey, String programmer) {
        programmerRepository.setProgrammerAsString(idKey, programmer);
    }

    @Override
    public String getProgrammerAsString(String idKey) {
        return programmerRepository.getProgrammerAsString(idKey);
    }

    @Override
    public void addProgrammersToList(Programmer programmer) {
        programmerRepository.addProgrammersToList(programmer);
    }

    @Override
    public Collection<Programmer> getProgrammersListMembers() {
        return programmerRepository.getProgrammersListMembers();
    }

    @Override
    public Long getProgrammersListCount() {
        return programmerRepository.getProgrammersListCount();
    }

}
