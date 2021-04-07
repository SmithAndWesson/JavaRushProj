package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

public class ClientGuiController extends Client{
    private ClientGuiModel model = new ClientGuiModel();
    private ClientGuiView view = new ClientGuiView(this);

    public static void main(String[] args){
        ClientGuiController client = new ClientGuiController();
        client.run();
    }


    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.run();
    }

    public class GuiSocketThread extends SocketThread{

        protected void processIncomingMessage(String message){
            model.setNewMessage(message);
            view.refreshMessages();
        }

        protected void informAboutAddingNewUser(String userName){
            model.addUser(userName);
            view.refreshUsers();
        }

        protected void informAboutDeletingNewUser(String userName){
            model.deleteUser(userName);
            view.refreshUsers();
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected){
            view.notifyConnectionStatusChanged(clientConnected);
        }

    }

    public ClientGuiModel getModel(){
        return model;
    }

    protected SocketThread getSocketThread(){
        return new GuiSocketThread();
    }

    protected String getServerAddress() {
        return view.getServerAddress();
    }

    protected int getServerPort(){
        return view.getServerPort();
    }

    protected String getUserName(){
        return view.getUserName();
    }

}
