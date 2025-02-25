package it.polyatskovun.enums;

public enum EventType {
    BIRTHDAY("День народження"),
    WEDDING("Весілля"),
    CORPORATE("Корпоратив"),
    HALLOWEEN("Геллоуін"),
    NEW_YEAR("Новий рік"),
    CHRISTMAS("Різдво"),
    CHARITY("Charity Gala"),
    ANNIVERSARY("Ювілей"),
    OTHER("Інше");

    private final String name;

    EventType(String name) {
        this.name = name;
    }
}
