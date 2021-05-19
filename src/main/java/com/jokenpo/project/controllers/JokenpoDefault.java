package com.jokenpo.project.controllers;

import com.jokenpo.project.crud.RoundCrud;
import com.jokenpo.project.models.RoundModel;
import com.jokenpo.project.util.Move;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class JokenpoDefault {
    private RoundCrud roundCrud;

    @Autowired
    public JokenpoDefault(RoundCrud roundCrud) {
        this.roundCrud = roundCrud;
    }

    /**
     * Verifica quem venceu a partida ou se foi empate
     * @param userMove movimento do user
     * @param computerMove movimento do computador
     * @param model model que envia a informação para a tela
     */
    public void checkTheWinner(Move userMove, Move computerMove, Model model) {
        if (!userMove.equals(computerMove)) {
            //COMPUTADOR VENCE
            if ((userMove.equals(Move.PAPEL) && computerMove.equals(Move.TESOURA)) ||
                    (userMove.equals(Move.PEDRA) && computerMove.equals(Move.PAPEL)) ||
                    (userMove.equals(Move.TESOURA) && computerMove.equals(Move.PEDRA))) {
                model.addAttribute("computador", true);
                roundCrud.saveAndFlush(new RoundModel(false, true));
            } else {
                //USER VENCE
                model.addAttribute("usuario", true);
                roundCrud.saveAndFlush(new RoundModel(true, false));
            }
        } else {
            //EMPATE
            model.addAttribute("empate", true);
            roundCrud.saveAndFlush(new RoundModel(true, true));
        }
    }

    public long countByPlayerWin() {
        return roundCrud.countByPlayerWin(true);
    }

    public long countByComputerWin() {
        return roundCrud.countByComputerWin(true);
    }

    public void deleteAllRounds() {
        roundCrud.deleteAll();
    }
}
