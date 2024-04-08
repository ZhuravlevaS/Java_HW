package lessons.lesson_08_04_enum;

public class EnumLesson {

    enum Level {
        LOW(1,"low"),
        MEDIUM(2,"medium"),
        HIGH(3, "high");
        String name;
        int idx;
        Level(int idx, String name) {
            this.idx = idx;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        String myVar = Level.LOW.name;
        int idxLow = Level.LOW.idx;

        Level[] levelArray = Level.values();

        for (Level level: levelArray) {
            System.out.println(level);
        }
        System.out.println(myVar);
        System.out.println(idxLow);
    }
}
