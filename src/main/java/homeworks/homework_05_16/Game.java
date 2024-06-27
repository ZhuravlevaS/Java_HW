package homeworks.homework_05_16;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Game implements Comparable<Game> {
    private LocalDate date;
    private Team<? extends Participant> team1;
    private Team<? extends Participant> team2;
    private boolean isDraw;
    private Team<? extends Participant> winnerTeam;

    public Game(LocalDate date,
                Team<? extends Participant> team1,
                Team<? extends Participant> team2,
                boolean isDraw,
                Team<? extends Participant> winnerTeam) {
        this.date = date;
        this.team1 = team1;
        this.team2 = team2;
        this.isDraw = isDraw;
        if (!isDraw) {
            this.winnerTeam = winnerTeam;
        }
    }

    @Override
    public int compareTo(Game o) {
        return this.date.compareTo(o.getDate());
    }

    @Override
    public String toString() {
        return "Game{" +
                "date=" + date +
                ", team1=" + team1 +
                ", team2=" + team2 +
                ", isDraw=" + isDraw +
                ", winnerTeam=" + winnerTeam +
                '}';
    }
}
