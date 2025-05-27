package com.motus.service;
import com.motus.entity.Mot;
import com.motus.repository.MotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;

@Service
public class MotService {
    @Autowired
    private MotRepository motRepo;

    public Mot getRandomMot(int longueur, String difficulte) {
        List<Mot> list = motRepo.findByLongueurAndDifficulte(longueur, difficulte);
        return list.get(new Random().nextInt(list.size()));
    }

    public String[] checkProposition(String secret, String proposition) {
        String[] result = new String[proposition.length()];
        for(int i=0;i<proposition.length();i++){
            char c = proposition.charAt(i);
            if(c == secret.charAt(i)) result[i] = "ROUGE";
            else if(secret.indexOf(c)>=0) result[i] = "JAUNE";
            else result[i] = "BLEU";
        }
        return result;
    }
}