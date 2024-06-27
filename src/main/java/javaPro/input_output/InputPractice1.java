package javaPro.input_output;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputPractice1 {
    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(Path.of("input1.txt"));

            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
            scanner.close();
        } catch (IOException e) {
            System.err.println(e);
        }

        System.out.println(list);
        getOutput(list, System.out);
        getOutput(list, new FileOutputStream("output.txt"));
    }

    private static void getOutput(List<String> list, OutputStream outputStream) throws IOException {
        try (OutputStream outputStream1 = new DataOutputStream(outputStream)) {
            for (String s : list) {
                String str = s + " ";
                outputStream1.write(str.getBytes(StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            System.err.println(e);
        }


    }
}
