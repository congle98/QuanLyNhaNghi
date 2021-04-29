package Manager;
import Person.*;
import Room.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Manager {
    private static ArrayList<Room> rooms = TextFileFactory.ReaderListRoom("textData.txt");
    private Scanner sc = new Scanner(System.in);
    public Manager() {
    }

    //menu chính
//    public void mainMenu(){
//        while (true){
//            System.out.println("Mời lựa chọn: \n 1. Thêm phòng trọ \n 2. Sửa phòng trọ \n 3. Xoá phòng trọ " +
//                    "\n 4.Hiển thị danh sách phòng trọ đang có \n 5.Quản lý phòng \n 6.Thoát");
//            int choose = sc.nextInt();
//            switch (choose){
//                case 1:
//                    addRoom();
//                    break;
//                case 2:
//                    System.out.println("Mời nhập id phòng cần sửa");
//                    setRoom(sc.next());
//                    break;
//                case 3:
//                    System.out.println("Mời nhập id phòng cần xoá");
//                    remoteRoom(sc.next());
//                    break;
//                case 4:
//                    showRooms();
//                    break;
//                case 5:
//                    System.out.println("Mời nhập id phòng cần quản lý");
//                    customerMenu(sc.next());
//                    break;
//                case 6:
//                    System.exit(0);
//                    break;
//                default:
//                    System.out.println("Nhập sai lựa chọn rồi mời nhập lại!!!");
//                    break;
//            }
//        }
//    }

    // thêm phòng
    public void addRoom(){
        System.out.println("Mời nhập lần lượt các thông tin dưới đây");
        System.out.println("ID phòng cần tạo");
        String id;
        do {
            id = sc.next();
            if(!checkIdSake(id)) System.out.println("Phòng đã tồn tại mời nhập lại");
        }while (!checkIdSake(id));
        System.out.println("Giá phòng");
        double price = sc.nextDouble();
        System.out.println("Kiểu phòng 1. Vip  2.Thường");
        int choose = sc.nextInt();
        rooms.add(new Room(id,price,typeOfRoom(choose)));
        priceSoft();
    }

    // thay đổi thông tin của phòng theo id
    public void setRoom(String id){
        for (Room room: rooms
             ) {
            if(room.getIdOfRoom().equals(id)){
                boolean loop = true;
                while (loop){
                    System.out.println("Mời nhập lựa chọn \n 1. Thay đổi id  \n 2. Thay đổi giá" +
                            " \n 3. Thay đổi kiểu phòng  \n 4. Thoát");
                    int choose = sc.nextInt();
                    switch (choose){
                        case 1:
                            System.out.println("Mời nhập id mới ");
                            String newId;
                            do {
                                newId = sc.next();
                                if(!checkIdSake( newId)) System.out.println("Phòng đã tồn tại mời nhập lại");
                            }while (!checkIdSake( newId));
                            room.setIdOfRoom( newId);
                            break;
                        case 2:
                            System.out.println("Mời nhập giá mới ");
                            room.setPricePerDay(sc.nextDouble());
                            break;
                        case 3:
                            System.out.println("Thay đổi kiểu phòng");
                            room.setTypeOfRoom(typeOfRoom(sc.nextInt()));
                            break;
                        case 4:
                            loop = false;
                            break;
                        default:
                            System.out.println("Nhập sai lựa chọn rồi mời nhập lại!!!");
                            break;

                    }
                }
            }
        }
    }

    // xoá phòng
    public void remoteRoom(String id){
        for (int i = 0; i < rooms.size(); i++) {
            if(rooms.get(i).getIdOfRoom()==id){
                rooms.remove(i);
            }
        }
    }
    // hiển thị tất cả  các phòng hiện có
    public void showRooms(){
        System.out.println(rooms);
    }



    //Quản lý khách trong phòng

    public void customerMenu(String id){
        for (int i = 0; i < rooms.size(); i++) {
            if(rooms.get(i).getIdOfRoom().equals(id)){
                boolean loop = true;
                while (loop){

                        System.out.println("Mời lựa chọn: \n 1. Thêm khách vào phòng \n 2. Sửa thông tin khách \n 3. Xoá khách" +
                                "\n 4.Hiển thị thông tin khách \n 5.Hiển thị thông tin phòng \n 6. Thay đổi ngày trọ  \n 7.Tính tiền phòng \n 8.Thoát ra ngoài");
                        int choose = sc.nextInt();
                    switch (choose){
                        case 1:
                            addPersonToRoom(i);
                            break;
                        case 2:
                            setCustomer(i);
                            break;
                        case 3:
                            removeCustomer(i);
                            break;
                        case 4:
                            showCustomerInRoom(i);
                            break;
                        case 5:
                            showRoom(i);
                            break;
                        case 6:
                            if(!rooms.get(i).isStatus()){
                                System.out.println("Mời nhập ngày trọ mới");
                                int dayOfRent = sc.nextInt();
                                rooms.get(i).setDayToRent(dayOfRent);
                            }
                            else System.out.println("Xin lỗi phòng vẫn còn trống");
                            break;
                        case 7:
                            showPrice(i);
                            break;
                        case 8:
                            loop=false;
                            break;
                        default:
                            System.out.println("Nhập sai lựa chọn rồi mời nhập lại!!!");
                            break;
                    }
                }
            }

        }
    }

    // thêm khách hàng vào phòng theo id phòng
    public void addPersonToRoom(int index){
        String email;
        System.out.println("Mời nhập tên khách hàng");
        String name = sc.next();
        System.out.println("Mời nhập số chứng minh thư");
        int idCard;
        do {
            idCard = sc.nextInt();
            if(!checkIdCardSake(idCard)) System.out.println("Khách hàng này đã tồn tại");
        }while (!checkIdCardSake(idCard));
        System.out.println("Mời nhập email");
        do {
            email = sc.next();
            if(!CheckInput.validate(email)) System.out.println("Nhập sai định dạng email mời nhập lại");
        }while (!CheckInput.validate(email));
        System.out.println("Mời nhập ngày sinh dd/mm/yyyy");
        String dataDate = sc.next();
        String[] date = dataDate.split("/");
        LocalDate dateOfBirth = LocalDate.of(Integer.parseInt(date[2]),Integer.parseInt(date[1]),Integer.parseInt(date[0]));
        rooms.get(index).addCustomer((new Customer(name,idCard,email,dateOfBirth)));
        if(rooms.get(index).getCustomers().size()==1){
            System.out.println("Mời nhập số ngày thuê");
            int dayOfRent = sc.nextInt();
            rooms.get(index).setDayToRent(dayOfRent);
        }
    }


    // thay đổi thông tin của các khách hàng theo id phòng
    public void setCustomer(int index){
        System.out.println("Mời nhập CMT của khách hàng cần sửa");
        int idCardIn= sc.nextInt();
        for (int i = 0; i < rooms.get(index).getCustomers().size(); i++) {
            if(rooms.get(index).getCustomers().get(i).getIDCard()==idCardIn){
                boolean loop = true;
                while (loop){
                    System.out.println("Mời nhập lựa chọn \n 1. Thay đổi tên khách hàng  \n 2. Thay đổi số CMT" +
                            " \n 3. Thay đổi email  \n 4. Thay đổi ngày sinh \n 5.Thoát" );
                    int choose = sc.nextInt();
                    switch (choose){
                        case 1:
                            System.out.println("Nhập tên mới của khách hàng");
                            String name = sc.next();
                            rooms.get(index).getCustomers().get(i).setName(name);
                            break;
                        case 2:
                            System.out.println("Nhập số cmt mới của khách hàng");
                            int idCard;
                            do {
                                idCard = sc.nextInt();
                                if(!checkIdCardSake(idCard)) System.out.println("Khách hàng này đã tồn tại");
                            }while (!checkIdCardSake(idCard));
                            rooms.get(index).getCustomers().get(i).setIDCard(idCard);
                            break;
                        case 3:
                            String email;
                            System.out.println("Nhập email mới");
                            do {
                                 email = sc.next();
                                 if(!CheckInput.validate(email)) System.out.println("Nhập sai định dạng email mời nhập lại");
                            }while (!CheckInput.validate(email));
                            rooms.get(index).getCustomers().get(i).setEmail(email);
                            break;
                        case 4:
                            System.out.println("Mời nhập ngày sinh dd/mm/yyyy");
                            String dataDate = sc.next();
                            String[] date = dataDate.split("/");
                            LocalDate dateOfBirth = LocalDate.of(Integer.parseInt(date[2]),Integer.parseInt(date[1]),Integer.parseInt(date[0]));
                            rooms.get(index).getCustomers().get(i).setDateOfBirth(dateOfBirth);
                            break;
                        case 5:
                            loop = false;
                            break;
                        default:
                            System.out.println("Nhập sai lựa chọn rồi mời nhập lại!!!");
                            break;

                    }
                }
            }
        }
    }

    // xoá khách hàng khỏi phòng
    public void removeCustomer(int index){
        System.out.println("Mời nhập CMT của khách hàng cần xoá");
        int idCardIn= sc.nextInt();
        for (int i = 0; i < rooms.get(index).getCustomers().size(); i++) {
            if(rooms.get(index).getCustomers().get(i).getIDCard()==idCardIn) {
                rooms.get(index).remoteCustomer(i);
            }
        }
        if (rooms.get(index).getCustomers().size()==0) rooms.get(index).setDayToRent(0);
    }

    // hiện danh sách khách hàng theo phòng
    public void showCustomerInRoom(int index){
        System.out.println(rooms.get(index).getCustomers());
    }

    // hiện thông tin phòng theo index
    public void showRoom(int index){
        System.out.println(rooms.get(index));
    }

    // tính giá phòng
    public void showPrice(int index){
        double priceOfType;
        if (rooms.get(index).getTypeOfRoom().equals("VIP")) priceOfType = 1.5;
        else priceOfType = 1;
        double result = rooms.get(index).getPricePerDay()*
                rooms.get(index).getDayToRent()*rooms.get(index).getCustomers().size()*priceOfType;
        System.out.println(result);
    }

    //sắp xếp theo giá
    public void priceSoft(){
        for (int i = 0; i < rooms.size()-1; i++) {
            for (int j = i+1; j < rooms.size(); j++) {
                if(rooms.get(j).getPricePerDay()<rooms.get(i).getPricePerDay()){
                    Room temp = rooms.get(i);
                    rooms.set(i,rooms.get(j));
                    rooms.set(j,temp);
                }
            }
        }
    }


    // phần check id phòng và id người
    private boolean checkIdSake(String id){
        boolean check = true;
        for (Room room:rooms
             ) {
            if(room.getIdOfRoom().equals(id)) check = false;
        }
        return check;
    }
    private boolean checkIdCardSake(int idCard){
        boolean check = true;
        for (int i = 0; i < rooms.size() ; i++) {
            for (int j = 0; j < rooms.get(i).getCustomers().size(); j++) {
                if(rooms.get(i).getCustomers().get(j).getIDCard()==idCard){
                    check = false;
                }
            }
        }
        return check;
    }
    private String typeOfRoom(int choose){
        if (choose==1) return "VIP";
        else if (choose==2) return "Thường";
        else return null;
    }
    public void saveData(){
        TextFileFactory.writerFile(rooms,"textData.txt");
    }
    public void removeData(){
        TextFileFactory.remove("textData.txt");
        rooms=TextFileFactory.ReaderListRoom("textData.txt");
    }

}
