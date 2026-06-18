// ============================================
// 다형성이란?
// ============================================
// "같은 이름의 메서드인데, 객체마다 다르게 동작한다"
// 그게 전부야!


// ============================================
// 예제 1: 가장 간단한 예 (동물들의 울음소리)
// ============================================

// 부모 클래스
class Animal {
    String name;
    
    public void sound() {
        System.out.println("동물이 소리를 냅니다");
    }
}

// Dog 클래스 - sound()를 "개 방식"으로 구현
class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println(name + ": 멍멍! 🐕");
    }
}

// Cat 클래스 - sound()를 "고양이 방식"으로 구현
class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println(name + ": 야옹! 🐱");
    }
}

// Cow 클래스 - sound()를 "소 방식"으로 구현
class Cow extends Animal {
    @Override
    public void sound() {
        System.out.println(name + ": 음매! 🐄");
    }
}

public class PolymorphismExample1 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.name = "뽀삐";
        
        Cat cat = new Cat();
        cat.name = "야옹이";
        
        Cow cow = new Cow();
        cow.name = "소니";
        
        // 여기가 다형성!
        // 같은 sound() 메서드를 호출했는데
        // 각자 다르게 출력됨!
        System.out.println("=== 같은 메서드 호출, 다른 결과 ===");
        dog.sound();   // 멍멍!
        cat.sound();   // 야옹!
        cow.sound();   // 음매!
        
        // 이게 다형성이야!
        // sound()라는 메서드 이름은 같지만
        // 객체에 따라 다르게 동작한다
    }
}

// 출력:
// === 같은 메서드 호출, 다른 결과 ===
// 뽀삐: 멍멍! 🐕
// 야옹이: 야옹! 🐱
// 소니: 음매! 🐄


// ============================================
// 예제 2: 실생활 예 (버튼 누르기)
// ============================================

// 모든 버튼의 부모 클래스
class Button {
    String name;
    
    public void click() {
        System.out.println(name + " 버튼을 눌렀습니다");
    }
}

// 전원 버튼 - click()을 "전원 끄기"로 구현
class PowerButton extends Button {
    @Override
    public void click() {
        System.out.println("⚫ 전원이 꺼집니다");
    }
}

// 음량 버튼 - click()을 "음량 올리기"로 구현
class VolumeButton extends Button {
    @Override
    public void click() {
        System.out.println("🔊 음량이 올라갑니다");
    }
}

// 홈 버튼 - click()을 "홈 화면 가기"로 구현
class HomeButton extends Button {
    @Override
    public void click() {
        System.out.println("🏠 홈 화면으로 이동합니다");
    }
}

public class PolymorphismExample2 {
    public static void main(String[] args) {
        Button powerBtn = new PowerButton();
        powerBtn.name = "전원";
        
        Button volumeBtn = new VolumeButton();
        volumeBtn.name = "음량";
        
        Button homeBtn = new HomeButton();
        homeBtn.name = "홈";
        
        // 다형성!
        // 모두 click() 메서드인데 다르게 동작
        System.out.println("=== 버튼들을 눌러보자 ===");
        powerBtn.click();
        volumeBtn.click();
        homeBtn.click();
    }
}

// 출력:
// === 버튼들을 눌러보자 ===
// ⚫ 전원이 꺼집니다
// 🔊 음량이 올라갑니다
// 🏠 홈 화면으로 이동합니다


// ============================================
// 예제 3: 왜 다형성이 유용한가? (배열 사용)
// ============================================

public class PolymorphismExample3 {
    public static void main(String[] args) {
        // 다형성 없이 하려면
        // Dog dog = new Dog();
        // Cat cat = new Cat();
        // Cow cow = new Cow();
        // dog.sound();
        // cat.sound();
        // cow.sound();
        // 이렇게 일일이 해야 함...
        
        // 다형성을 사용하면!
        // 부모 타입의 배열에 모든 자식 객체를 담을 수 있음
        Animal[] animals = {
            new Dog(),
            new Cat(),
            new Cow()
        };
        
        animals[0].name = "뽀삐";
        animals[1].name = "야옹이";
        animals[2].name = "소니";
        
        // for 루프 한 번으로 모든 동물의 울음소리를 출력!
        System.out.println("=== 모든 동물이 울어요 ===");
        for (int i = 0; i < animals.length; i++) {
            animals[i].sound();  // 같은 메서드인데 다르게 동작!
        }
        
        // 또는 향상된 for 루프
        System.out.println();
        System.out.println("=== 다시 울어요 ===");
        for (Animal animal : animals) {
            animal.sound();  // 다형성 때문에 가능!
        }
    }
}

// 출력:
// === 모든 동물이 울어요 ===
// 뽀삐: 멍멍! 🐕
// 야옹이: 야옹! 🐱
// 소니: 음매! 🐄
//
// === 다시 울어요 ===
// 뽀삐: 멍멍! 🐕
// 야옹이: 야옹! 🐱
// 소니: 음매! 🐄


// ============================================
// 예제 4: 메서드에 넘겨주기
// ============================================

public class PolymorphismExample4 {
    
    // 이 메서드는 Animal 타입을 받음
    // 하지만 Animal의 자식이면 뭐든 됨!
    public static void makeAnimalSound(Animal animal) {
        animal.sound();  // 어떤 동물이든 자기 방식으로 울음
    }
    
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.name = "뽀삐";
        
        Cat cat = new Cat();
        cat.name = "야옹이";
        
        Cow cow = new Cow();
        cow.name = "소니";
        
        // 같은 메서드에 다른 객체를 넘길 수 있음!
        // 다형성 덕분에 이게 가능
        System.out.println("=== 같은 메서드, 다른 결과 ===");
        makeAnimalSound(dog);    // 멍멍!
        makeAnimalSound(cat);    // 야옹!
        makeAnimalSound(cow);    // 음매!
    }
}

// 출력:
// === 같은 메서드, 다른 결과 ===
// 뽀삐: 멍멍! 🐕
// 야옹이: 야옹! 🐱
// 소니: 음매! 🐄


// ============================================
// 💡 다형성의 핵심 (3줄 요약)
// ============================================

/*
1. 부모 클래스의 메서드를 자식 클래스에서 다르게 구현
2. 같은 메서드 이름인데 객체마다 다르게 동작
3. 덕분에 코드를 유연하게 작성할 수 있음

= 다형성!
*/
