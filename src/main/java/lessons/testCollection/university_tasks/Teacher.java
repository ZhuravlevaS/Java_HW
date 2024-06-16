package lessons.testCollection.university_tasks;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Teacher  extends Person implements CommunityMember {

    private String specializedSubject;

    public Teacher(String name, String surname, int age, String specializedSubject) {
        super(name, surname, age);
        this.specializedSubject = specializedSubject;
    }

    @Override
    public String getCommunityStatus() {
        return Main.faker.starTrek().character();
    }
}
