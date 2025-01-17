package com.example.level5;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    private String category;
    private List<MenuItem> menuItems = new ArrayList<>();

    public Menu(String category){
        this.category = category;
    }

    public String getCategory() { return category; }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void addMenuItem(MenuItem menuItem) {
        this.menuItems.add(menuItem);
    }

    public void showMenus(){
        while(true) {
            try {
                System.out.println("[ " + category.toUpperCase() + " MENU ]");
                int num = 1;
                for (MenuItem item : menuItems) {
                    System.out.println(num + ". " + item.getName() + "\t| W" + item.getPrice() + " | " + item.getDesc());
                    num++;
                }
                System.out.println("0. 뒤로가기");
                int n = sc.nextInt();

                if (n == 0) break;
                else if (n > menuItems.size()){
                    System.out.println("INVALID INPUT\n");
                    continue;
                }
                printSelectedMenu(n-1);
                return;
            } catch (InputMismatchException e) {
                System.out.println("INVALID INPUT. INPUT THE NUMBER\n");
                sc.nextLine(); // 잘못된 입력 제거
            }
        }
    }

    public void printSelectedMenu(int idx){
        System.out.println("선택한 메뉴: " + menuItems.get(idx).getName() + "\t| W" + menuItems.get(idx).getPrice() + " | " + menuItems.get(idx).getDesc() + "\n");
    }
}
