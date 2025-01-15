package com.example.level3;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Kiosk {
    Scanner sc = new Scanner(System.in);

    private List<MenuItem> menu = new ArrayList<>();

    public Kiosk() {
        menu.add(new MenuItem("ShackBurger", 6.9, "토마도, 양상추, 쉑소스가 토핑된 치즈버거"));
        menu.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menu.add(new MenuItem("CheeseBurger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menu.add(new MenuItem("HamBurger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public void setMenu(List<MenuItem> menu) {
        this.menu = menu;
    }

    public void start(){
         while(true) {
             try {
                 System.out.println("[ SHAKESHACK MENU ]");
                 int num = 1;
                 for (MenuItem item : menu) {
                     System.out.println(num + ". " + item.getName() + "\t| W" + item.getPrice() + " | " + item.getDesc());
                     num++;
                 }
                 System.out.println("0. 종료      | 종료");
                 int m = sc.nextInt();

                 if (m == 0) break;
                 else if (m > menu.size()){
                     System.out.println("INVALID INPUT");
                     continue;
                 }
                 printSelectedMenu(m);
             } catch (InputMismatchException e) {
                 System.out.println("INVALID INPUT. INPUT THE NUMBER");
                 sc.nextLine(); // 잘못된 입력 제거
             }
        }
    }

    public void printSelectedMenu(int idx){
        System.out.println(idx + ". " + menu.get(idx-1).getName() + "\t| W" + menu.get(idx-1).getPrice() + " | " + menu.get(idx-1).getDesc()+"\n");
    }
}
