package seminars.third.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class TestDrivenDevelopment {
    /**
     * 3.5 Нужно написать (TDD) класс MoodAnalyser, который оценивает фразы по настроению
     */
    private MoodAnalysis moodAnalysis;

    @BeforeEach
    public void setup() {
        moodAnalysis = new MoodAnalysis();
    }

    @Test
    void testMoodSadAnalysis() {
        String mood = moodAnalysis.analysedMod("Это сообщение грустное");
        assertThat(mood).isEqualTo("sad");
    }
    @Test
    void testMoodHappyAnalysis() {
        String mood = moodAnalysis.analysedMod("Это сообщение весёлое");
        assertThat(mood).isEqualTo("good");
    }
    @Test
    void testMoodOtherAnalysis() {
        String mood = moodAnalysis.analysedMod("Это сообщение другое");
        assertThat(mood).isEqualTo("another");
    }
}