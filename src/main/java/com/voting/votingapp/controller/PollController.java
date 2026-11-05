package com.voting.votingapp.controller;


import com.voting.votingapp.dto.Vote;
import com.voting.votingapp.entities.Poll;
import com.voting.votingapp.service.PollService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/polls")
@AllArgsConstructor
public class PollController {

    @Autowired
    private final PollService pollService;

    @PostMapping
    public ResponseEntity<Poll> createPoll(@RequestBody Poll poll){
        return ResponseEntity.status(201).body(pollService.createPoll(poll));
    }

    @GetMapping
    public ResponseEntity<List<Poll>> getAllPolls(){
        return ResponseEntity.status(200).body(pollService.getAllPolls());
    }

    @GetMapping("/{pollId}")
    public ResponseEntity<Poll> getPollById(@PathVariable Long pollId){
        return pollService.getPollById(pollId).map(ResponseEntity::ok)
                        .orElse(ResponseEntity.noContent().build());
    }

    @PostMapping("/vote")
    public ResponseEntity<String> vote(@RequestBody Vote vote){
         pollService.vote(vote.getId(), vote.getOptionIndex());

         return ResponseEntity.ok("Vote has been given to ID :: "+vote.getId());
    }
}
