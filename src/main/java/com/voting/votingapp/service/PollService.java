package com.voting.votingapp.service;

import com.voting.votingapp.entities.OptionVote;
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

    public void vote(Long id, int optionIndex) {
        Poll poll = pollRepository.findById(id).orElseThrow(() -> new RuntimeException("Poll not found."));

        List<OptionVote> options = poll.getOptions();

        if(optionIndex < 0 || optionIndex >= options.size()){
            throw new IllegalArgumentException("Invalid option index");
        }

        OptionVote optionVote = options.get(optionIndex);

        optionVote.setVoteCount(optionVote.getVoteCount()+1);

        pollRepository.save(poll);
    }
}
