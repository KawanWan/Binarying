package com.binarying.binproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.binarying.binproject.entities.Phase;
import com.binarying.binproject.repositories.PhaseRepository;

@Service
public class PhaseService {
    
    private final PhaseRepository phaseRepository;

    public PhaseService(PhaseRepository phaseRepository) {
        this.phaseRepository = phaseRepository;
    }

    public Integer[][] getPhasesMap(Integer worldId) {
        List<Phase> phases = phaseRepository.findByWorld(worldId);
    
        // Encontrar as maiores dimensões do mapa
        int maxX = 0;
        int maxY = 0;
        for (Phase phase : phases) {
            maxX = Math.max(maxX, phase.x());
            maxY = Math.max(maxY, phase.y());
        }
    
        // Calcular o tamanho do mapa
        int sizeX = maxX + 1;
        int sizeY = maxY + 1;
    
        Integer[][] map = new Integer[sizeX][sizeY];
    
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                map[i][j] = 0; // Inicializar com 0
            }
        }
    
        // Marcar as fases no mapa
        for (Phase phase : phases) {
            int posX = phase.x();
            int posY = phase.y();
            map[posX][posY] = 3; // Marcar a fase atual com 3
    
            // Marcar adjacências com 1
            for (int i = Math.max(0, posX - 1); i <= Math.min(sizeX - 1, posX + 1); i++) {
                for (int j = Math.max(0, posY - 1); j <= Math.min(sizeY - 1, posY + 1); j++) {
                    if (map[i][j] != 3 && isAdjacent(i, j, posX, posY)) {
                        map[i][j] = 1;
                    }
                }
            }
        }
    
        return map;
    }    

    private boolean isAdjacent(int x, int y, int posX, int posY) {
        return Math.abs(x - posX) <= 1 && Math.abs(y - posY) <= 1 && (x != posX || y != posY);
    }
}
