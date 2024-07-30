package ClientExample;

import java.io.*;
import java.net.Socket;

public class Main {
    private static final String DEFAULT_NAME = "localhost";
    private static final int DEFAULT_PORT = 1234;
    public static void main(String [] args) {
        String serverName = args.length == 0 || args[0] == null || args[0].isBlank() ? DEFAULT_NAME : args[0];
        int port = args.length == 0 || args[1] == null || args[1].isBlank() ? DEFAULT_PORT : Integer.parseInt(args[1]);

        try {
            System.out.println("Подключение к " + serverName + " на порт " + port);
            Socket client = new Socket(serverName, port);

            System.out.println("Просто подключается к " + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            out.writeUTF("Привет из " + client.getLocalSocketAddress());
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);

            System.out.println("Сервер ответил " + in.readUTF());
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}