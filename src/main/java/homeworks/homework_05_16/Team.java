package homeworks.homework_05_16;

import lombok.Getter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Getter
public class Team <T extends Participant>{
    private String teamName;
    private final List<T> listParticipants = new ArrayList<>();
    private final List<Game> playedGames = new LinkedList<>();
    private double totalPoints;
    private Category category;

    public void addNewParticipant(T newParticipant) {
        this.listParticipants.add(newParticipant);
    }

    public void addPlayedGames(Game game) {
        this.playedGames.add(game);
        if (game.isDraw()) {
            totalPoints += 0.5;
        } else if (this.equals(game.getWinnerTeam())) {
            totalPoints += 1;
        }
    }

    public Team(String teamName, Category category) {
        this.teamName = teamName;
        this.category = category;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team<?> team = (Team<?>) o;
        return Objects.equals(teamName, team.teamName) && Objects.equals(listParticipants, team.listParticipants) && Objects.equals(playedGames, team.playedGames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamName, listParticipants, playedGames);
    }

    @Override
    public String toString() {
        return "Team{" +
                "category='" + category + '\'' +
                "teamName='" + teamName + '\'' +
                ", totalPoints=" + totalPoints +
                '}';
    }
}