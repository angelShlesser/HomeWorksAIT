package de.ait.enums;


public class Main {

    public static void main(String[] args) {
        DayUtil today = new DayUtil(29, Day.WEDNESDAY, Seasons.WINTER);
        DayUtil tomorrow = new DayUtil(30, Day.WEDNESDAY, Seasons.WINTER);

        System.out.println(today.getSeason().ordinal());
        System.out.println(today.getDayOfWeek().ordinal());
        System.out.println(Seasons.values()[0]);
        System.out.println(Seasons.valueOf("WINTER").getDescription());

        System.out.println(today.dayOfWeek.equals(Day.FRIDAY));


        switch (today.dayOfWeek){
            case MONDAY -> System.out.println("НЕТ");
            case WEDNESDAY -> System.out.println("ДА");
            default -> System.out.println("Не знаю");
        }


    }
}
