package seminars.third.tdd;

public class MoodAnalysis {
    public String analysedMod(String message) {
        if (message.contains("грустное")) {
            return "sad";
        }
        if (message.contains("весёлое")) {
            return "good";
        }
        return "another";
    }
}
