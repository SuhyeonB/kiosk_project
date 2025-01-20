Kiosk_project
----
kiosk project

intro: 키오스크 과제

<br/>
Level 1: 단순 입출력 키오스크 

메뉴가 출력되고, 제시된 메뉴 중 입력받은 숫자에 따라 다른 로직을 실행

<br/>
Level2: 객체 지향 설계 적용하기 - 메뉴를 클래스로 관리

level2/ <br/>
&emsp;|- Main.java <br/>
&emsp;|- MenuItem.java

이름, 가격, 설명을 갖는 MenuItem 클래스 & Main에서 해당 클래스를 List로 관리

<br/>
Level3: 객체 지향 설계 적용하기 - 순서 제어를 클래스로 관리

level3/ <br/>
&emsp;|- Main.java<br/>
&emsp;|- Kiosk.java<br/>
&emsp;|- MenuItem.java<br/>

main 메서드에서 관리하던 입력&반복문 로직은 Kiosk 내 start메서드가 관리

이름, 가격, 설명을 갖는 MenuItem 클래스 & Main에서 해당 클래스를 List로 관리

<br/>
Level4: 객체 지향 설계 적용하기 - 순서 제어를 클래스로 관리

level4/<br/>
&emsp;|- Main.java<br/>
&emsp;|- Kiosk.java<br/>
&emsp;|- Menu.java<br/>
&emsp;|- MenuItem.java<br/>

Menu클래스는 `category`와 `List<MenuItem> menuItems` 필드를 갖는 클래스로, 각 카테고리(burger, drink, dessert)마다 새로운 Menu를 생성해 구분 및 관리할 수 있도록 했다.
또, showMenus() 메서드로 각 카테고리별 메뉴들을 출력하도록 했다.

<br/>
Level5: 캡슐화 적용하기

level4에서 이미 캡슐화가 되어 있고, getter&setter로 데이터가 관리되고 있으므로 level 4와 동일한 코드이다.

----
Level6: (도전 기능) 장바구니 및 구매하기 기능 & 할인 적용

level6/<br/>
&emsp;|- Main.java<br/>
&emsp;|- Kiosk.java<br/>
&emsp;|- Menu.java<br/>
&emsp;|- MenuItem.java<br/>
&emsp;|- Order.java<br/>
&emsp;|- DiscountType.java<br/>

Main에서는 menuItem과 menu를 추가하고, Kiosk 클래스를 생성해서 start() 메서드를 실행힜다.

Kiosk는 전체 흐름을 관리하는 클래스로 menu와 order을 필드로 갖는다.
또, 전 레벨 기능에서 showMenus()로 각 카테고리별 메뉴들을 출력했는데, 이를 selectMenu()로 수정하며 선택된 메뉴가 반환되도록 했다. (void -> Optional<MenuItem>)
Order 클래스는  주문한 메뉴를 담는 orderItems(HashMap)과 total 필드를 갖고 있고, addOrderItem(), removeOrder(), applyDiscount() 메서드를 갖는다.
DiscountType은 Enum으로 할인 유형과 할인율(%)을 정의하고 있다.

----
구현 화면

![image](https://github.com/user-attachments/assets/24b86c82-aab6-47af-9a6f-dae2e70b8c6f)
![image](https://github.com/user-attachments/assets/9ffbd077-2127-4c91-b7e1-40aae5f01fcf)

