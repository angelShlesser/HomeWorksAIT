package de.ait.homeworks55;

public class FashionItem {
    private String name;

    private double price;

    private FashionCategory fashionCategory;

    private Season season;

    public FashionItem(String name, double preis, FashionCategory fashionCategory, Season season) {
        this.name = name;
        this.price = preis;
        this.fashionCategory = fashionCategory;
        this.season = season;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double preis) {
        this.price = preis;
    }

    public FashionCategory getFashionCategory() {
        return fashionCategory;
    }

    public void setFashionCategory(FashionCategory fashionCategory) {
        this.fashionCategory = fashionCategory;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    @Override
    public String toString() {
        return
                "Название: " + name +
                        ", цена: " + price +
                        ", категория: " + fashionCategory +
                        ", сезон: " + season;
    }
}
