package com.redis.services;

import com.redis.model.Programmer;

import java.util.Collection;

public interface ProgrammerService {

    public void setProgrammerAsString(String idKey, String programmer);

    public String getProgrammerAsString(String idKey);

    public void addProgrammersToList(Programmer programmer);

    public Collection<Programmer> getProgrammersListMembers();

    public Long getProgrammersListCount();
}
