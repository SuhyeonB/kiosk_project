package com.example.level4;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    Scanner sc = new Scanner(System.in);

    private List<Menu> menu;

    public Kiosk(List<Menu> menus) {
        this.menu = menus;
    }

    public List<Menu> getMenus() {
        return menu;
    }

    public void setMenus(List<Menu> menus) {
        this.menu = menus;
    }

    public void start(){
        while(true) {
            try {
                System.out.println("[ MAIN MENU ]");
                int num = 1;
                for (Menu m : menu) {
                    System.out.println(num + ". " + m.getCategory());
                    num++;
                }
                System.out.println("0. 종료      | 종료");
                int n = sc.nextInt();

                if (n == 0) break;
                else if (n > menu.size()){
                    System.out.println("INVALID INPUT\n");
                    continue;
                }
                menu.get(n-1).showMenus();
            } catch (InputMismatchException e) {
                System.out.println("INVALID INPUT. INPUT THE NUMBER");
                sc.nextLine(); // 잘못된 입력 제거
            }
        }
    }
}
