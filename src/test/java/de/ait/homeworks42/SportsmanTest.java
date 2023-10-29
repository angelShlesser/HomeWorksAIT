package de.ait.homeworks42;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SportsmanTest {
    private Sportsman sportsmanMaria;
    private Sportsman sportsmanIvan;

    @BeforeEach
    void setUp() {
        sportsmanMaria =new Sportsman("Мария", 30, "Плавание", 15);
        sportsmanIvan = new Sportsman("Иван", 25, "Легкая атлетика", 10);
    }

    @Test
    void testGetNameSuccess() {
        Assertions.assertEquals("Мария",sportsmanMaria.getName());
    }
    @Test
    void testGetAgeSuccess() {
        Assertions.assertEquals(25,sportsmanIvan.getAge());
    }
    @Test
    void testSetAgeSuccess() {
        Assertions.assertEquals(25,sportsmanIvan.getAge());
        sportsmanIvan.setAge(34);
        Assertions.assertEquals(34,sportsmanIvan.getAge());
    }

    @Test
    void testGetSportSuccess() {
        Assertions.assertEquals("Плавание",sportsmanMaria.getSport());
    }

    @Test
    void testSetSportSuccess() {
        sportsmanMaria.setSport("Бокс");
        Assertions.assertEquals("Бокс",sportsmanMaria.getSport());
    }

    @Test
    void testGetRecordsSuccess() {
        Assertions.assertEquals(15,sportsmanMaria.getRecords());
    }

    @Test
    void testSetRecordsSuccess() {
        sportsmanMaria.setRecords(18);
        Assertions.assertEquals(18,sportsmanMaria.getRecords());
    }

    @Test
    void testToStringSuccess() {
        sportsmanMaria.toString();
    }

    @Test
    void testUpdateRecordSuccess() {
        Assertions.assertTrue(sportsmanIvan.updateRecord(22));
    }

    @Test
    void testUpdateRecordFails() {
        Assertions.assertFalse(sportsmanIvan.updateRecord(4));
    }

    @Test
    void testIsEligibleForCompetitionSuccess() {
        Assertions.assertTrue(sportsmanMaria.isEligibleForCompetition(16,30));
    }

    @Test
    void testIsEligibleForCompetitionFails() {
        Assertions.assertFalse(sportsmanIvan.isEligibleForCompetition(12,18));
    }
}