package de.ait.homeworks37;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InventoryManagementTest {
    private InventoryManagement inventoryManagement;
    private MobilePhone mobilePhone1;
    private MobilePhone mobilePhone2;

    @BeforeEach
    void setUp() {
        inventoryManagement = new InventoryManagement();
        mobilePhone1 = new MobilePhone(1, "Brand 1", "Model 1", 64,200);
        mobilePhone2 = new MobilePhone(2, "Brand 2", "Model 2", 128, 350);

        inventoryManagement.addMobilePhone(mobilePhone1);
    }
    @Test
    void TestAddMobilePhoneSuccess(){
        assertTrue(inventoryManagement.addMobilePhone(mobilePhone2));
    }
    @Test
    void TestAddMobilePhoneFail(){
        assertTrue(inventoryManagement.addMobilePhone(mobilePhone2));
        // Попытка добавить мобильный телефон с тем же ID (не должно добавиться)
        Assertions.assertFalse(inventoryManagement.addMobilePhone(mobilePhone2));
    }
    @Test
    void TestGetMobilePhone(){
        MobilePhone result = inventoryManagement.getMobilePhone(1);
        Assertions.assertNotNull(result);
        assertEquals(1,result.getId());
        assertEquals("Model 1",result.getModel());
        assertEquals("Brand 1",result.getBrand());
        MobilePhone notFoundPhone = inventoryManagement.getMobilePhone(3);
        assertNull(notFoundPhone);
    }
    @Test
    void testUpdateMobilePhone() {
        MobilePhone updatePhone = new MobilePhone(1, "Обновленный Бренд", "Обновленная Модель", 128, 300);
        Assertions.assertTrue(inventoryManagement.updateMobilePhone(updatePhone));
        MobilePhone updatePhone2 = new MobilePhone(4, "Обновленный Бренд", "Обновленная Модель", 128, 300);
        Assertions.assertFalse(inventoryManagement.updateMobilePhone(updatePhone2));
    }
    @Test
    void testDeleteMobilePhone(){
        assertTrue(inventoryManagement.deleteMobilePhone(1));
        assertNull(inventoryManagement.getMobilePhone(1));
        assertFalse(inventoryManagement.deleteMobilePhone(3));
    }
}