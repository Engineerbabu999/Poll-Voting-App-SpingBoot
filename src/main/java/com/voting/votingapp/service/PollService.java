package com.voting.votingapp.service;

import com.voting.votingapp.entities.Poll;
import com.voting.votingapp.repository.PollRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PollService {

    @Autowired
    private final PollRepository pollRepository;

    public Poll createPoll(Poll poll) {
        return pollRepository.save(poll);
    }

    public List<Poll> getAllPolls() {
        return pollRepository.findAll();
    }

    public Optional<Poll> getPollById(Long pollId) {
        return pollRepository.findById(pollId);
    }
}
