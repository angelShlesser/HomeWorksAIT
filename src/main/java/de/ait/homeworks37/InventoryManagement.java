package de.ait.homeworks37;

import java.util.ArrayList;
import java.util.List;

public class InventoryManagement {
    private List<MobilePhone> mobilePhones = new ArrayList<>();
    //addMobilePhone(MobilePhone phone): добавление нового мобильного телефона в список.
    // Добавление нового мобильного телефона в список.
    public boolean addMobilePhone(MobilePhone phone) {
        if (!mobilePhoneCheck(phone)) {
            mobilePhones.add(phone);
            return true;
        } else {
            System.out.println("Мобильный телефон с моделью " + phone.getModel() + " уже существует.");
            return false;
        }
    }
    //добавим проверку на дубликат
    // Проверка на дубликаты мобильных телефонов.
    private boolean mobilePhoneCheck(MobilePhone newPhone) {
        for (MobilePhone mobilePhone : mobilePhones) {
            if (mobilePhone.getId() == newPhone.getId()) {
                // Мобильный телефон с таким ID уже существует.
                return true;
            }
        }
        return false;
    }
    // Поиск и получение мобильного телефона по ID.
    public MobilePhone getMobilePhone(int id) {
        for (MobilePhone mobilePhone : mobilePhones) {
            if (mobilePhone.getId() == id) {
                return mobilePhone;
            }
        }
        // Мобильный телефон с заданным ID не найден.
        return null;
    }
    // updateMobilePhone(MobilePhone phone):
    // обновление информации о существующем мобильном телефоне.
    public boolean updateMobilePhone(MobilePhone phone) {
        for (int i = 0; i < mobilePhones.size(); i++) {
            MobilePhone phoneResult = mobilePhones.get(i);
            if (phoneResult.getId() == phone.getId()) {
                mobilePhones.set(i, phone);
                return true;
            }
        }
        return false;
    }
    //deleteMobilePhone(int id): удаление мобильного телефона по ID.
    public boolean deleteMobilePhone(int id){
        for(MobilePhone phone:mobilePhones){
            if(phone.getId()==id){
                mobilePhones.remove(phone);
                return true;
            }
        }
        return false;
    }
}
