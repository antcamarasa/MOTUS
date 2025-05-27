package com.motus.controller;
import com.motus.entity.Score;
import com.motus.entity.User;
import com.motus.repository.ScoreRepository;
import com.motus.repository.UserRepository;
import com.motus.service.MotService;
import com.motus.entity.Mot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/game")
public class GameController {
    @Autowired private MotService motService;
    @Autowired private UserRepository userRepo;
    @Autowired private ScoreRepository scoreRepo;

    private Map<String, Mot> sessions = new HashMap<>();

    @PostMapping("/start")
    public Mot start(@RequestParam int longueur, @RequestParam String difficulte, Principal p) {
        Mot m = motService.getRandomMot(longueur,difficulte);
        sessions.put(p.getName(), m);
        return new Mot() {{ setId(null); setWord(m.getWord().substring(0,1)); }};
    }

    @PostMapping("/play")
    public String[] play(@RequestParam String guess, Principal p) {
        Mot secret = sessions.get(p.getName());
        String[] res = motService.checkProposition(secret.getWord(),guess);
        if(guess.equals(secret.getWord())){
            User u = userRepo.findByPseudo(p.getName()).get();
            Score s=new Score(); s.setUser(u); s.setScore(1);
            scoreRepo.save(s);
            sessions.remove(p.getName());
        }
        return res;
    }
}