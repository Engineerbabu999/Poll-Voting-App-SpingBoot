package com.voting.votingapp.controller;


import com.voting.votingapp.entities.Poll;
import com.voting.votingapp.service.PollService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/polls")
@AllArgsConstructor
public class PollController {

    @Autowired
    private final PollService pollService;

    @PostMapping
    public Poll createPoll(@RequestBody Poll poll){
        return pollService.createPoll(poll);
    }
}
