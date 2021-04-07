package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.javarush.task.task30.task3008.MessageType.*;

public class Server {

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    private static class Handler extends Thread{
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage("установлено новое соединение с удаленным адресом" + socket.getRemoteSocketAddress());
            String userName = "";
            try (Connection connection = new Connection(socket)){
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(USER_ADDED, userName));
                notifyUsers(connection, userName);
                serverMainLoop(connection, userName);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            if(connectionMap.containsKey(userName)){
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(USER_REMOVED, userName));
            }

            ConsoleHelper.writeMessage("Cоединение закрыто" + socket.getRemoteSocketAddress());

        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
            Message message;
            while(true) { //numTries-- > 0
                connection.send(new Message(NAME_REQUEST));
                message = connection.receive();
                if (message.getType() == USER_NAME &&
                        !message.getData().isEmpty() &&
                        !connectionMap.containsKey(message.getData())
                )
                    break;
            }
            connectionMap.put(message.getData(), connection);
            connection.send(new Message(NAME_ACCEPTED));
            return message.getData();

        }

        private void notifyUsers(Connection connection, String userName) throws IOException{
            for(Map.Entry<String, Connection> entry : connectionMap.entrySet()){
                if(!userName.equals(entry.getKey())) connection.send(new Message(USER_ADDED, entry.getKey()));
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
           while (true){
               Message message = connection.receive();
               if (message.getType() == TEXT) {
                   Message messageWithName = new Message(TEXT, userName + ": " + message.getData());
                   sendBroadcastMessage(messageWithName);
               } else
                   ConsoleHelper.writeMessage("Сообщение не является текстом");

           }
        }
    }

    public static void main(String[] args) throws IOException {

        ConsoleHelper.writeMessage("Введите номер порта:");
        int portNumber = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            ConsoleHelper.writeMessage("Сервер запущен");
            while (true) {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void sendBroadcastMessage(Message message){
        for(Map.Entry<String, Connection> entry : connectionMap.entrySet()){
            try {
                entry.getValue().send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Сообщение не было отправлено");
            }
        }
    }
}
