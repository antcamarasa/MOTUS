package com.motus.repository;
import com.motus.entity.Mot;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface MotRepository extends JpaRepository<Mot,Long> {
    List<Mot> findByLongueurAndDifficulte(int longueur, String difficulte);
}