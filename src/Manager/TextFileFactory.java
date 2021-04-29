package Manager;

import Room.Room;

import java.io.*;
import java.util.ArrayList;

public class TextFileFactory {
    public static void writerFile(ArrayList<Room> data, String path){
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream =null;
        try {
            fileOutputStream = new FileOutputStream(path);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(data);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        finally {

            try {
                objectOutputStream.close();
                fileOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
    public static ArrayList<Room> ReaderListRoom(String path){
        ArrayList<Room> listRoom = new ArrayList<>();
        File file = null;
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            file = new File(path);
            if(file.length()>0){
                fileInputStream = new FileInputStream(file);
                objectInputStream = new ObjectInputStream(fileInputStream);
                Object data = objectInputStream.readObject();
                listRoom = (ArrayList<Room>)data;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            try {
                if(objectInputStream!=null){
                    objectInputStream.close();
                    fileInputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return listRoom;
    }
    public static void remove(String path){
        File file = new File(path);
        try {
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
