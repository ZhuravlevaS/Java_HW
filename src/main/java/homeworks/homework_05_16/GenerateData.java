package homeworks.homework_05_16;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class GenerateData {
    public static List<Team<? extends Participant>> teams = new LinkedList<>();
    private static final Faker FAKER = new Faker();
    private static LocalDate date = LocalDate.of(1990, 1, 1);
    public static void main(String[] args) {
        init();
    }

    private static void generateTeams() {
        for (int i = 0; i < 25; i++) {
            teams.add(
                    generateTeam((team) -> {
                        for (int j = 1; j <= 4; j++) {
                            team.addNewParticipant(new Adult(
                                    FAKER.name().lastName(),
                                    FAKER.number().numberBetween(21, 120)));
                        }
                    }, Category.ADULT));
            teams.add(
                    generateTeam((team) -> {
                        for (int j = 1; j <= 4; j++) {
                            team.addNewParticipant(new Teenager(
                                    FAKER.name().lastName(),
                                    FAKER.number().numberBetween(10, 20)));
                        }
                    }, Category.TEENAGER));

            teams.add(
                    generateTeam((team) -> {
                        for (int j = 1; j <= 4; j++) {
                            team.addNewParticipant(new Pupil(
                                    FAKER.name().lastName(),
                                    FAKER.number().numberBetween(5, 9)));
                        }
                    }, Category.PUPIL));
        }
    }


    private static void generateGames(List<Team<? extends Participant>> teams) {
        for (int i = 0; i < teams.size(); i++) {
            for (int j = i; j < teams.size(); j++) {
                if (j > i && teams.get(i).getCategory().equals(teams.get(j).getCategory())) {
                    createGame(teams.get(i), teams.get(j));

                }
            }
        }
    }

    public static void createGame(Team<? extends Participant> team1, Team<? extends Participant> team2) {
        Game game = new Game(
                date,
                team1,
                team2,
                FAKER.bool().bool(),
                FAKER.bool().bool() ? team1 : team2);
        date = date.plusDays(1);

        team1.addPlayedGames(game);
        team2.addPlayedGames(game);
    }

    public static void init() {
        generateTeams();
        generateGames(teams);
    }

    private static <T extends Participant> Team<T> generateTeam(AddParticipant<T> addParticipant, Category category) {
        Team<T> team = new Team<>(FAKER.team().name(), category);
        addParticipant.add(team);
        return team;
    }

}

@FunctionalInterface
interface AddParticipant<T extends Participant> {
    void add(Team<T> team);
}
