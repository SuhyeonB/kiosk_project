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
                MenuItem selected = menu.get(n1-1).selectMenu().orElseGet(
                        ()-> new MenuItem("NONE", "NONE", 0, "")
                );
                if (!selected.getName().equals("NONE"))
                    addToOrder(selected.getName(), selected.getPrice());
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
                     if(calculateTotal()) break;
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
//                for (int i=0; i<menu.size(); i++) {
//                    for (MenuItem item : menu.get(i).getMenuItems()) {
//                        if (order.getOrderItems().containsKey(item.getName())) item.printMenuItem();
//                    }
//                }

                menu.stream()
                        .flatMap(m -> m.getMenuItems().stream()) // 각 메뉴의 MenuItem 스트림 생성
                        .filter(item -> order.getOrderItems().containsKey(item.getName())) // 주문에 포함된 항목 필터링
                        .forEach(MenuItem::printMenuItem); // 각 항목 출력

                System.out.println("\n[ Totals ]");
                System.out.println("W " + order.getTotal() + "\n");

                System.out.println("1. 주문       2. 메뉴판");
                int isOrdered = sc.nextInt();
                if (isOrdered == 1) {
                    System.out.println("할인 정보를 입력해주세요");
                    System.out.println("1. 국가 유공자 : 10%");
                    System.out.println("2. 군인 : 5%");
                    System.out.println("3. 학생 : 3%");
                    System.out.println("4. 일반 : 0%");
                    int discount = sc.nextInt();
                    if (discount == 1) order.applyDiscount(DiscountType.VETERAN);
                    else if (discount == 2) order.applyDiscount(DiscountType.SOLDIER);
                    else if (discount == 3) order.applyDiscount(DiscountType.STUDENT);
                    else if (discount == 4) order.applyDiscount(DiscountType.GENERAL);
                    else return false;

                    System.out.println("주문이 완료되었습니다. 금액은 W " + order.getTotal() + "입니다.");
                    return true;
                }
                else if (isOrdered == 2) return false;
            }
        } catch (InputMismatchException e) {
            System.out.println("INVALID INPUT. INPUT THE NUMBER");
            sc.nextLine();
        }
        return false;
    }
}
