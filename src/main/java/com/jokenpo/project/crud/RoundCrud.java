package com.jokenpo.project.crud;

import com.jokenpo.project.models.RoundModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoundCrud extends JpaRepository<RoundModel, Long> {
    Long countByPlayerWin(boolean playerWin);
    Long countByComputerWin(boolean computerWin);
}
