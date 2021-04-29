package Room;
import Person.*;

import java.io.Serializable;
import java.util.ArrayList;

public class Room implements Serializable {
    private String idOfRoom;
    private double pricePerDay;
    private String typeOfRoom;
    private ArrayList<Customer> customers = new ArrayList<Customer>();
    private boolean status;
    private int dayToRent;
    public Room() {
    }

    public Room(String idOfRoom, double pricePerDay, String typeOfRoom) {
        this.idOfRoom = idOfRoom;
        this.pricePerDay = pricePerDay;
        this.typeOfRoom = typeOfRoom;
        this.status = true;
    }

    public String getIdOfRoom() {
        return idOfRoom;
    }

    public void setIdOfRoom(String idOfRoom) {
        this.idOfRoom = idOfRoom;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public String getTypeOfRoom() {
        return typeOfRoom;
    }

    public void setTypeOfRoom(String typeOfRoom) {
        this.typeOfRoom = typeOfRoom;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
    public int getDayToRent() {
        return dayToRent;
    }

    public void setDayToRent(int dayToRent) {
        this.dayToRent = dayToRent;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public void addCustomer(Customer customer){
        customers.add(customer);
        checkStatus();
    }
    public void remoteCustomer(int index){
        customers.remove(index);
        checkStatus();
    }
    public void checkStatus(){
        if (customers.size()>0) this.status = false;
        else this.status = true;
    }

    @Override
    public String toString() {
        String inforOfRoom = "Phòng :"+idOfRoom+", Loại: "+typeOfRoom+", Giá qua đêm: "+pricePerDay+", Trạng thái: "+(status?"Còn trống":"Đã có "+customers.size()+"  người thuê ");
        if(customers.size()==0){
            inforOfRoom+="";
        }
        else {
            inforOfRoom+=", Khách trọ: ";
            for (int i = 0; i < customers.size(); i++) {
                inforOfRoom+= customers.get(i)+" ";
            }
            inforOfRoom+=" thời gian thuê "+dayToRent+" ngày";
        }

        return inforOfRoom+"\n";
    }
}
