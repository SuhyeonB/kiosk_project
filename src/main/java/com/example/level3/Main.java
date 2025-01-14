package com.example.level3;

public class Main { // 사용자 시점
    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk();

        MenuItem menu1 = new MenuItem("Burger", 1.5, "description");

        kiosk.addMenu(menu1);

        kiosk.start();
    }
}
