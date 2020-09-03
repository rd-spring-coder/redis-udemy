package com.redis.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.redis.model.Programmer;
import com.redis.services.ProgrammerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class ProgrammerController {

    @Autowired
    private ProgrammerService programmerService;

    //******STRING*****
    @PostMapping("/programmer-string")
    public void addProgrammer(@RequestBody Programmer programmer) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        programmerService.setProgrammerAsString(String.valueOf(programmer.getId()), mapper.writeValueAsString(programmer));
    }

    @GetMapping("/programmer-string/{id}")
    public String getProgrammer(@PathVariable String id){
        return programmerService.getProgrammerAsString(id);
    }
    //******STRING*****

    //******LIST*****
    @PostMapping("/programmers")
    public void addProgrammersToList(@RequestBody Programmer programmer) throws JsonProcessingException {
        programmerService.addProgrammersToList(programmer);
    }

    @GetMapping("/programmers")
    public Collection<Programmer> fetchProgrammers(){
        return programmerService.getProgrammersListMembers();
    }

    @GetMapping("/programmers/count")
    public Long programmersCount(){
        return programmerService.getProgrammersListCount();
    }

    //******LIST*****
}
