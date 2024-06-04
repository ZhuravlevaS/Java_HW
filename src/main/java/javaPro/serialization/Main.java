package javaPro.serialization;

import javaPro.serialization.user.UserData;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        // writeFile();
        UserData userData1 = readFile("UserData.data");
        UserData userData2 = readFile("UserData.data");

        System.out.println(userData1.hashCode());
        System.out.println(userData2.hashCode());



    }

    private static UserData readFile(String nameFile) {
        UserData userData = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nameFile))) {
            Object o = inputStream.readObject();
            if (o instanceof UserData) {
                userData = (UserData) o;
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return userData;
    }

    private static void writeFile() {
        UserData user = new UserData("login", "password", "email@email.com");
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("UserData.data"))) {
            outputStream.writeObject(user);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
