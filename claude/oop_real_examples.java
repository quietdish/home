// ============================================
// 실생활 예제 1: 동물 분류 (상속의 원리)
// ============================================

// 일반적인 특징들을 부모 클래스에 모음
class Animal {
    String name;
    int age;
    
    // 모든 동물이 공통으로 하는 행동
    public void eat() {
        System.out.println(name + "이(가) 먹이를 먹습니다");
    }
    
    public void sleep() {
        System.out.println(name + "이(가) 자고 있습니다");
    }
    
    public void move() {
        System.out.println(name + "이(가) 움직입니다");
    }
}

// 개는 동물의 특성을 모두 상속받음
class Dog extends Animal {
    String breed;  // 개만의 특성
    
    // 개만의 특별한 행동 (오버라이드)
    @Override
    public void move() {
        System.out.println(name + "이(가) 네 발로 뛰어다닙니다");
    }
    
    // 개만의 고유한 행동
    public void bark() {
        System.out.println(name + ": 멍멍! 🐕");
    }
}

// 새는 동물의 특성을 모두 상속받음
class Bird extends Animal {
    boolean canFly;  // 새만의 특성
    
    // 새만의 특별한 행동 (오버라이드)
    @Override
    public void move() {
        System.out.println(name + "이(가) 날아다닙니다 ✈️");
    }
    
    // 새만의 고유한 행동
    public void chirp() {
        System.out.println(name + ": 짹짹! 🐦");
    }
}

// 물고기는 동물의 특성을 모두 상속받음
class Fish extends Animal {
    int depthLimit;  // 물고기만의 특성
    
    // 물고기만의 특별한 행동 (오버라이드)
    @Override
    public void move() {
        System.out.println(name + "이(가) 헤엄칩니다 🐠");
    }
}

public class AnimalExample {
    public static void main(String[] args) {
        // 각 동물 생성
        Dog dog = new Dog();
        dog.name = "뽀삐";
        dog.age = 3;
        dog.breed = "푸들";
        
        Bird bird = new Bird();
        bird.name = "짹짹이";
        bird.age = 1;
        bird.canFly = true;
        
        Fish fish = new Fish();
        fish.name = "금붕어";
        fish.age = 2;
        fish.depthLimit = 10;
        
        // 모든 동물이 공통으로 할 수 있는 행동 (부모 클래스에서 정의)
        System.out.println("=== 모든 동물의 공통 행동 ===");
        dog.eat();      // Animal 클래스에서 한 번 정의
        bird.eat();     // 모든 자식이 자동으로 사용!
        fish.eat();
        
        System.out.println();
        
        // 각 동물의 특별한 움직임 (오버라이드된 메서드)
        System.out.println("=== 각 동물의 고유한 움직임 ===");
        dog.move();     // 다르게 구현됨 (다형성!)
        bird.move();    // 다르게 구현됨
        fish.move();    // 다르게 구현됨
        
        System.out.println();
        
        // 각 동물만의 고유한 행동
        System.out.println("=== 각 동물만의 고유 행동 ===");
        dog.bark();
        bird.chirp();
    }
}

// 출력:
// === 모든 동물의 공통 행동 ===
// 뽀삐이(가) 먹이를 먹습니다
// 짹짹이이(가) 먹이를 먹습니다
// 금붕어이(가) 먹이를 먹습니다
//
// === 각 동물의 고유한 움직임 ===
// 뽀삐이(가) 네 발로 뛰어다닙니다
// 짹짹이이(가) 날아다닙니다 ✈️
// 금붕어이(가) 헤엄칩니다 🐠
//
// === 각 동물만의 고유 행동 ===
// 뽀삐: 멍멍! 🐕
// 짹짹이: 짹짹! 🐦


// ============================================
// 실생활 예제 2: 휴대폰 종류 (다형성과 상속)
// ============================================

// 모든 휴대폰의 공통 기능
class Phone {
    String model;
    
    public void call(String number) {
        System.out.println(model + "로 " + number + "에 전화 중...");
    }
    
    public void sendMessage(String number, String text) {
        System.out.println(model + "로 메시지 전송: " + text);
    }
}

// 스마트폰 - 추가 기능
class SmartPhone extends Phone {
    @Override
    public void call(String number) {
        System.out.println("화상통화로 " + number + "와 연결...");
    }
    
    public void installApp(String appName) {
        System.out.println(model + "에 " + appName + " 설치됨");
    }
    
    public void playMusic(String song) {
        System.out.println("🎵 " + song + " 재생 중");
    }
}

// 기본폰 - 제한된 기능
class BasicPhone extends Phone {
    // Phone의 call(), sendMessage() 그대로 사용
    // 추가 기능 없음
}

public class PhoneExample {
    public static void main(String[] args) {
        Phone basicPhone = new BasicPhone();
        basicPhone.model = "3310";
        
        Phone smartPhone = new SmartPhone();
        smartPhone.model = "iPhone 15";
        
        // 다형성! 같은 메서드를 호출했지만 다르게 동작
        System.out.println("=== 전화 기능 비교 ===");
        basicPhone.call("010-1234-5678");      // 일반 전화
        smartPhone.call("010-1234-5678");      // 화상통화 (오버라이드)
        
        System.out.println();
        
        // 스마트폰만의 기능
        System.out.println("=== 스마트폰만의 기능 ===");
        SmartPhone myPhone = (SmartPhone) smartPhone;
        myPhone.installApp("Instagram");
        myPhone.playMusic("Dynamite - BTS");
    }
}

// 출력:
// === 전화 기능 비교 ===
// 3310로 010-1234-5678에 전화 중...
// 화상통화로 010-1234-5678와 연결...
//
// === 스마트폰만의 기능 ===
// iPhone 15에 Instagram 설치됨
// 🎵 Dynamite - BTS 재생 중


// ============================================
// 실생활 예제 3: 통장 (캡슐화의 중요성)
// ============================================

// ❌ 캡슐화 없음 - 문제 발생!
class BadBankAccount {
    public String accountNumber;
    public int balance;  // 누구나 마음대로 수정 가능!
    
    public void withdraw(int amount) {
        balance = balance - amount;
    }
}

// 문제 상황
BadBankAccount bad = new BadBankAccount();
bad.balance = 1000000;
bad.balance = bad.balance - 900000;  // 불법으로 돈을 빼감
System.out.println("불법 출금: " + bad.balance);  // 100000


// ✅ 캡슐화 - 안전함
class GoodBankAccount {
    private String accountNumber;  // private: 외부에서 직접 접근 불가
    private int balance;           // private: 외부에서 직접 접근 불가
    
    // 생성자
    public GoodBankAccount(String accountNumber, int initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    
    // getter: 읽기만 허용
    public int getBalance() {
        return balance;
    }
    
    // setter: 유효성 검사 후에만 변경 허용
    public void deposit(int amount) {
        if (amount <= 0) {
            System.out.println("❌ 양수만 입금 가능합니다");
            return;
        }
        balance = balance + amount;
        System.out.println("✅ " + amount + "원 입금됨. 잔액: " + balance);
    }
    
    public void withdraw(int amount) {
        if (amount <= 0) {
            System.out.println("❌ 양수만 출금 가능합니다");
            return;
        }
        if (amount > balance) {
            System.out.println("❌ 잔액이 부족합니다");
            return;
        }
        balance = balance - amount;
        System.out.println("✅ " + amount + "원 출금됨. 잔액: " + balance);
    }
}

public class BankAccountExample {
    public static void main(String[] args) {
        GoodBankAccount account = new GoodBankAccount("123-456", 1000000);
        
        System.out.println("초기 잔액: " + account.getBalance());
        
        // 정상 거래
        account.deposit(50000);
        account.withdraw(100000);
        
        // 부정한 시도
        System.out.println();
        System.out.println("=== 부정한 시도 ===");
        account.withdraw(-500000);    // ❌ 음수는 안됨
        account.withdraw(2000000);    // ❌ 잔액 부족
        account.deposit(-100000);     // ❌ 음수는 안됨
        
        // account.balance = 999999999;  // ❌ 불가능! private이므로 접근 불가
    }
}

// 출력:
// 초기 잔액: 1000000
// ✅ 50000원 입금됨. 잔액: 1050000
// ✅ 100000원 출금됨. 잔액: 950000
//
// === 부정한 시도 ===
// ❌ 양수만 출금 가능합니다
// ❌ 잔액이 부족합니다
// ❌ 양수만 입금 가능합니다


// ============================================
// 💡 요약: OOP의 3가지 개념
// ============================================

/*
1. 상속 (Inheritance)
   - 공통 특징을 부모 클래스로 묶기
   - 중복 코드 제거
   - Animal 클래스에서 eat(), sleep() 한 번 정의
   → Dog, Bird, Fish 모두 자동으로 사용

2. 다형성 (Polymorphism)
   - 같은 메서드를 다르게 구현
   - 각 클래스의 특성에 맞게 오버라이드
   - Dog.move() vs Bird.move() vs Fish.move() 다르게 동작

3. 캡슐화 (Encapsulation)
   - 중요한 데이터를 private으로 보호
   - getter/setter로 유효성 검사
   - 은행 통장처럼 규칙을 강제할 수 있음
*/
