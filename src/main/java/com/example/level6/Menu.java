package com.example.level6;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    private String category;
    private List<MenuItem> menuItems;

    public Menu(String category) {
        this.category = category;
    }

    public String getCategory() { return category; }

    public void setCategory(String category) { this.category = category; }

    public List<MenuItem> getMenuItems() { return menuItems; }

    public void setMenuItems(List<MenuItem> menuItems) { this.menuItems = menuItems; }

    public Optional<MenuItem> selectMenu(){
        while(true) {
            try {
                System.out.println("[ " + category.toUpperCase() + " MENU ]");
                int num = 1;
                for (MenuItem item : menuItems) {
                    System.out.print(num + ". ");
                    item.printMenuItem();
                    num++;
                }
                System.out.println("0. 뒤로가기");
                int n = sc.nextInt();

                if (n == 0) break;
                else if (n > menuItems.size()){
                    System.out.println("INVALID INPUT\n");
                    continue;
                }
                int idx = n-1;
                System.out.print("선택한 메뉴: ");
                menuItems.get(idx).printMenuItem();

                // select order or not
                System.out.println("\n위 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인       2. 취소");
                n = sc.nextInt();

                if (n == 1) return Optional.of(menuItems.get(idx));
                else if (n == 2) return Optional.empty();
                else System.out.println("INVALID INPUT\n");

            } catch (InputMismatchException e) {
                System.out.println("INVALID INPUT. INPUT THE NUMBER\n");
                sc.nextLine(); // 잘못된 입력 제거
            }
        }
        return null;
    }
}
