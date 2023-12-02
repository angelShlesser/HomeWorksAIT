package de.ait.homeworks55;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Set;

public class FashionShop {
    // Каталог для хранения товаров в соответствии с категориями
    private final EnumMap<FashionCategory, Set<FashionItem>> catalog;
    private static final Logger LOGGER = LoggerFactory.getLogger(FashionShop.class);

    // Конструктор класса
    public FashionShop() {
        // Инициализация каталога с использованием EnumMap
        catalog = new EnumMap<>(FashionCategory.class);

        // Заполнение каталога пустыми множествами для каждой категории
        for (FashionCategory category : FashionCategory.values()) {
            catalog.put(category, new HashSet<>());
        }
    }

    // Метод для добавления товара в каталог
    public void addFashionItem(FashionItem fashionItem) {
        // Получение категории товара и добавление в соответствующее множество
        catalog.get(fashionItem.getFashionCategory()).add(fashionItem);
    }

    // Метод для вывода информации о товарах для определенного сезона
    public void showInfoAboutSeason(Season season) {
        LOGGER.info("Поиск по сезону --> {}", season);
        // Перебор категорий
        for (FashionCategory fashionCategory : FashionCategory.values()) {

            // Перебор товаров в текущей категории
            for (FashionItem item : catalog.get(fashionCategory)) {
                // Вывод информации о товаре, если он относится к указанному сезону
                if (item.getSeason().equals(season)) {
                    LOGGER.info("Информация --> {}",item);
                }
            }
        }
    }
}
