package com.company;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;



@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Tests {
    //public final TollFeeCalculator tollFeeCalculator = new TollFeeCalculator("testData/Lab4.txt");

    @Test
    @Order(1)
    @DisplayName("Tests if ")
    public void testIfGameIsSaved() {
        assertTrue(GameProgress.ifGameIsSaved(), "Saved game does not exist");
    }
}
