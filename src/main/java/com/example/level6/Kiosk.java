package com.example.level6;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Kiosk {
    Scanner sc = new Scanner(System.in);

    private List<Menu> menu;
    private Order order = new Order();

    public Kiosk(List<Menu> menu) { this.menu = menu; }

    public List<Menu> getMenu() { return menu; }

    public void setMenu(List<Menu> menu) { this.menu = menu; }

    public Order getOrder() { return order; }

    public void setOrder(Order order) { this.order = order; }

    public void start() {
        while(true) {
            try {
                // home: main menu
                System.out.println("[ MAIN MENU ]");
                int num = 1;
                for (Menu m : menu) {
                    System.out.println(num + ". " + m.getCategory());
                    num++;
                }
                System.out.println("0. 종료      | 종료");

                //first input -> show menus
                int n1 = sc.nextInt();

                if (n1 == 0) break;
                else if (n1 > menu.size()){
                    System.out.println("INVALID INPUT\n");
                    continue;
                }

                // select menu from each category
                Optional<MenuItem> selected = menu.get(n1-1).selectMenu();
                if (selected.isPresent())  addToOrder( selected.get().getName(), selected.get().getPrice());
                else continue;

                if (!order.getOrderItems().isEmpty()) {
                    System.out.println("[ ORDER MENU ]");
                    System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.");
                    System.out.println("5. Cancel       | 진행중인 주문을 취소합니다.");
                }
                // second input -> go to order
                int n2 = sc.nextInt();
                if (n2 == 5) {
                    order.removeOrder();
                } else if (n2 == 4) {
                     if(calculateTotal()) {
                         System.out.println("\n **** 결제 되었습니다! ****");
                         break;
                     }
                }

            } catch (InputMismatchException e) {
                System.out.println("INVALID INPUT. INPUT THE NUMBER");
                sc.nextLine(); // 잘못된 입력 제거
            }
        }
    }

    public void addToOrder(String name, Double price){
        order.addOrderItem(name, price);
        System.out.println(name + " 이 장바구니에 추가되었습니다.\n");
    }

    public boolean calculateTotal() {
        try{
            while(true) {
                System.out.println("아래와 같이 주문하시겠습니까?\n");

                System.out.println("[ Orders ]");
                // 주문한 메뉴들 출력하기
                // 가지고 있는 정보 : 메뉴들의 이름 (HashMap)
                // 출력함수 위치 : MenuItem
                // 즉, 위의 menu 처럼 전 메뉴를 다 순회하는데, Order에 존재하는 애들만 출력
                for (int i=0; i<menu.size(); i++) {
                    for (MenuItem item : menu.get(i).getMenuItems()) {
                        if (order.getOrderItems().containsKey(item.getName())) item.printMenuItem();
                    }
                }

                System.out.println("\n[ Totals ]");
                System.out.println("W " + order.getTotal() + "\n");

                System.out.println("1. 주문       2. 메뉴판");
                int isOrdered = sc.nextInt();
                if (isOrdered == 1) return true;
                else if (isOrdered == 2) return false;
            }
        } catch (InputMismatchException e) {
            System.out.println("INVALID INPUT. INPUT THE NUMBER");
            sc.nextLine();
        }
        return false;
    }
}
