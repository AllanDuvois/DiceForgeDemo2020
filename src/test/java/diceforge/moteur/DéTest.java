package diceforge.moteur;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DéTest {
    Dé dé;

    @Mock
    Random rand;

    @BeforeEach
    void setUp() {
        dé = new Dé(rand);
    }

    @Test
    /**
     * suppose que le dé renvoie 2 pts pour le random 0 à 4 (5 faces)
     */
    void lancerQuiDonne2Pts() {
        when(rand.nextInt(anyInt())).thenReturn(1, 1,2, 3, 0,4, 1, 2);
        for(int i = 0; i < 8; i++) assertEquals(2, dé.lancer(), "au début, le dé renvoie 2 pour 5 faces");
    }

    @Test
    /**
     * suppose que le dé renvoie 2 pts pour le random = 5
     */
    void lancerQuiDonne3Pts() {
        when(rand.nextInt(anyInt())).thenReturn(5);
        for(int i = 0; i < 8; i++) assertEquals(3, dé.lancer(), "au début, le dé renvoie 3 pour une face");
    }
}