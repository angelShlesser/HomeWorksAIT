package de.ait.homeworks55;

public class CatalogClient {

    public static void main(String[] args) {
        // Создаем экземпляр магазина
        FashionShop fashionShop = new FashionShop();

        // Создаем несколько товаров
        FashionItem fashionItemWatch = new FashionItem("Часы", 2000, FashionCategory.АКСЕССУАРЫ, Season.ВСЕСЕЗОННАЯ);
        FashionItem fashionItemCoat = new FashionItem("Пальто", 400, FashionCategory.ОДЕЖДА, Season.ОСЕНЬ);
        FashionItem fashionItemBoot = new FashionItem("Кеды", 50, FashionCategory.ОБУВЬ, Season.ЛЕТО);

        // Добавляем товары в магазин
        fashionShop.addFashionItem(fashionItemWatch);
        fashionShop.addFashionItem(fashionItemCoat);
        fashionShop.addFashionItem(fashionItemBoot);

        // Выводим информацию о товарах для разных сезонов
        fashionShop.showInfoAboutSeason(Season.ВСЕСЕЗОННАЯ);
        fashionShop.showInfoAboutSeason(Season.ОСЕНЬ);
        fashionShop.showInfoAboutSeason(Season.ЛЕТО);
        fashionShop.showInfoAboutSeason(Season.ЗИМА);
    }
}