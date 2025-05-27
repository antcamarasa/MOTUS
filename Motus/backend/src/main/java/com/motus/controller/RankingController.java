package com.motus.controller;
import com.motus.entity.Score;
import com.motus.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class RankingController {
    @Autowired private ScoreRepository repo;
    @GetMapping("/api/ranking")
    public List<Score> top(){return repo.findTop10ByOrderByScoreDesc();}
}