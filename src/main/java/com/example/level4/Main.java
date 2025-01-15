package com.example.level4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // menu objects
        Menu burgers = new Menu("Burgers");
        Menu drinks = new Menu("Drinks");
        Menu desserts = new Menu("Desserts");

        List<MenuItem> burgerItem = new ArrayList<>();
        burgerItem.add(new MenuItem("ShackBurger", 6.9, "토마도, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgerItem.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgerItem.add(new MenuItem("CheeseBurger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgerItem.add(new MenuItem("HamBurger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
        burgers.setMenuItems(burgerItem);

        List<MenuItem> drinkItem = new ArrayList<>();
        drinkItem.add(new MenuItem("Lemonade", 5.2, "매장에서 직접 만드는 상큼한 레몬에이드"));
        drinkItem.add(new MenuItem("Fountain Soda", 3.6, "코카콜라, 코카콜라 제로, 스프라이트, 환타 오렌지, 환타 그레이프, 환타 파인애플"));
        drinkItem.add(new MenuItem("Abita Root Beer", 5.0, "청량감 있는 독특한 미국식 무알콜 탄산음료"));
        drinkItem.add(new MenuItem("Shack Latte", 4.5, "쉑 블렌드 원두로 내린 에스프레소에 부드러운 우유를 더한 라떼"));
        drinks.setMenuItems(drinkItem);

        List<MenuItem> dessertItem = new ArrayList<>();
        dessertItem.add(new MenuItem("Float", 6.8, "부드러운 바닐라 커스터드와 톡톡 터지는 탄산이 만나 탄생한 색다른 음료(루트 비어/퍼플 카우/크림시클)"));
        dessertItem.add(new MenuItem("Shack Attack", 6.2, "진한 초콜릿 커스터드에 퍼지 소스와 세 가지 초콜릿 토핑이 블렌딩된 쉐이크쉑의 대표 콘크리트"));
        dessertItem.add(new MenuItem("Cups&Con", 5.7, "매일 점포에서 신선하게 제조하는 쫀득하고 진한 아이스크림 (바닐라/초콜릿)"));
        dessertItem.add(new MenuItem("Honey Butter Crunch", 5.4, "바닐라 커스터드에 허니 버터 소스와 슈가 콘이 달콤하게 블렌딩된 콘크리트"));
        desserts.setMenuItems(dessertItem);

        // put menus in kiosk
        List<Menu> menuList = new ArrayList<>();
        menuList.add(burgers);
        menuList.add(drinks);
        menuList.add(desserts);

        // kiosk
        Kiosk kiosk = new Kiosk(menuList);

        kiosk.start();
    }
}
