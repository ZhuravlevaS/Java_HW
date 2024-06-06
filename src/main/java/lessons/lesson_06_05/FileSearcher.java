package lessons.lesson_06_05;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FileSearcher {
    public static void main(String[] args) {

        List<File> files = new LinkedList<>();
        long startTime = System.currentTimeMillis();

        findPDFFiles(new File("/Users/karpenter/Downloads"), files);

        long endTime = System.currentTimeMillis();

        System.out.println("************************************");
        System.out.println("TIME: " + (endTime - startTime));
        System.out.println("************************************");

        files.forEach(System.out::println);
    }

    //сделать точно такой же, но не рекурсивно
    private static void searchFile(File rootFile, List<File> files) {
        if(rootFile.isDirectory()) {
            //System.out.println("Searching for.... " + rootFile.getAbsolutePath());
            File[] subFiles = rootFile.listFiles();
            if(subFiles != null) {
                for(File subFile : subFiles) {
                    if(subFile.isDirectory()) {
                        searchFile(subFile, files);
                    } else {
                        if(subFile.getName().endsWith(".pdf")) {
                            files.add(subFile);
                        }
                    }
                }
            }
        }
    }

    public static void findPDFFiles(File directory, List<File> filesList) {
        if (!directory.isDirectory()) {
            System.out.println("Provided path is not a directory");
            return;
        }

        Queue<File> queue = new LinkedList<>();
        queue.add(directory);

        while (!queue.isEmpty()) {
            File currentDirectory = queue.poll();
            File[] files = currentDirectory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        queue.add(file);
                    } else if (file.getName().toLowerCase().endsWith(".pdf")) {
                        filesList.add(file);
                    }
                }
            }
        }
    }

    //реализовать поиск файлов только при помощи Path Files walkFileTree()
//    private static void searchFilewalkTreeFiles(File rootFile, List<File> files) {
//        Path rootPath = rootFile.toPath();
//
//        Files.walkFileTree(rootFile, )
//    }
}
