package homeworks.homework_05_16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Handler {
    public static Map<Team<? extends Participant>, Double> teamTotalPoints = new HashMap<>();
    public static Map<Category, List<Team<? extends Participant>>> bestTeams;

    public static void main(String[] args) {
        GenerateData.init();
        init();
        System.out.println(teamTotalPoints);

    }


    private static void generateTotalPoints() {
        for (Team<? extends Participant> team : GenerateData.teams) {
            teamTotalPoints.put(team, team.getTotalPoints());
        }
    }

    private static Map<Category, List<Team<? extends Participant>>> getBest3Commands(Category category) {
        Map<Category, List<Team<? extends Participant>>> bestPerCategory = new HashMap<>();
        GenerateData.teams.stream()
                .filter((team -> team.getCategory().equals(category)))
                .sorted((team1, team2) -> (int) (team2.getTotalPoints() - team1.getTotalPoints()))
                .forEach((team) -> {
                    if (!bestPerCategory.containsKey(category)) {
                        bestPerCategory.put(category, new ArrayList<>());
                        bestPerCategory.get(category).add(team);
                    } else if (bestPerCategory.get(category).size() < 3) {
                        bestPerCategory.get(category).add(team);
                    }
                });

        return bestPerCategory;
    }

    public static void checkForDiffPoints() {
        bestTeams.forEach((category, list) -> {
            boolean isDiffPoints = true;
            while (isDiffPoints) {
                if (list.get(0).getTotalPoints() == list.get(1).getTotalPoints()) {
                    GenerateData.createGame(list.get(0), list.get(1));
                } else if (list.get(1).getTotalPoints() == list.get(2).getTotalPoints()) {
                    GenerateData.createGame(list.get(1), list.get(2));
                } else if (list.get(0).getTotalPoints() == list.get(2).getTotalPoints()) {
                    GenerateData.createGame(list.get(0), list.get(2));
                } else {
                    isDiffPoints = false;
                }
            }
        });
    }

    public static void init() {
        generateTotalPoints();
        bestTeams.putAll(getBest3Commands(Category.PUPIL));
        bestTeams.putAll(getBest3Commands(Category.ADULT));
        bestTeams.putAll(getBest3Commands(Category.TEENAGER));
        checkForDiffPoints();
    }
}
