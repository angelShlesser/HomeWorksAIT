package de.ait.homeworks37;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class InventoryManagement {

    private List<MobilePhone> mobilePhones = new ArrayList<>();

    public boolean addMobilePhone(MobilePhone phone) {
        return mobilePhones.add(phone);
    }
    public MobilePhone getMobilephone(UUID id) {
        for (MobilePhone mobilephone : mobilePhones) {
            if (mobilephone.getId().equals(id)) {
                return mobilephone;
            }
        }
        return null;
    }
    public boolean updateMobilePhone(UUID id, MobilePhone newMobilephone) {
        MobilePhone mobilephone = getMobilephone(id);
        if(mobilephone == null){
            System.out.println("Телефон с ID " + id.toString() + " не найден");
            return false;
        }
        else  {
            mobilephone.setOperatingSystem(newMobilephone.getOperatingSystem());
            mobilephone.setPrice(newMobilephone.getPrice());
            System.out.println("Телефон с ID " + id.toString() + " найден и обновлен");
            return true;
        }

    }
    public boolean deleteMobilePhone(UUID id) {
        MobilePhone phone = getMobilephone(id);
        if (phone != null) {
            mobilePhones.remove(phone);
            return true;
        }
        return false;
    }
    public List<MobilePhone> getAllMobilePhones(){
        return mobilePhones;
    }
}