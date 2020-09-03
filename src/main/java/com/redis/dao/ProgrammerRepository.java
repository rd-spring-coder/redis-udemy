package com.redis.dao;

import com.redis.model.Programmer;

import java.util.Collection;
import java.util.List;

public interface ProgrammerRepository {

    public void setProgrammerAsString(String idKey, String programmer);

    public String getProgrammerAsString(String idKey);

    public void addProgrammersToList(Programmer programmer);

    public Collection<Programmer> getProgrammersListMembers();

    public Long getProgrammersListCount();
}
