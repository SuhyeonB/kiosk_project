package com.example.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // declare List and initialize
        List<MenuItem> menu = new ArrayList<>();

        menu.add(new MenuItem("ShackBurger", 6.9, "토마도, 양상추, 쉑소스가 토핑된 치즈버거"));
        menu.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menu.add(new MenuItem("CheeseBurger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menu.add(new MenuItem("HamBurger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        while(true) {
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
            System.out.println(m + ". " + menu.get(m-1).getName() + "\t| W" + menu.get(m-1).getPrice() + " | " + menu.get(m-1).getDesc()+"\n");
        }
    }
}
