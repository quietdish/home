// ============================================
// ❌ 상속 없이 짜면 이렇게 됨 (코드 중복 발생!)
// ============================================

class Student {
    String name;
    int age;
    String studentId;
    
    // 공통 메서드 1
    public void introduce() {
        System.out.println("이름: " + name);
        System.out.println("나이: " + age);
    }
    
    // 공통 메서드 2
    public void printInfo() {
        System.out.println("=== 학생 정보 ===");
        System.out.println("이름: " + name);
        System.out.println("나이: " + age);
        System.out.println("학번: " + studentId);
    }
}

class Teacher {
    String name;      // ⚠️ Student와 동일
    int age;         // ⚠️ Student와 동일
    String teacherId;
    
    // 공통 메서드 1 - 복사 & 붙여넣기
    public void introduce() {
        System.out.println("이름: " + name);
        System.out.println("나이: " + age);
    }
    
    // 공통 메서드 2 - 복사 & 붙여넣기 (조금만 수정)
    public void printInfo() {
        System.out.println("=== 교사 정보 ===");
        System.out.println("이름: " + name);
        System.out.println("나이: " + age);
        System.out.println("교사ID: " + teacherId);
    }
}

class Parent {
    String name;      // ⚠️ Student, Teacher와 동일
    int age;         // ⚠️ Student, Teacher와 동일
    
    // 공통 메서드 1 - 또 복사 & 붙여넣기
    public void introduce() {
        System.out.println("이름: " + name);
        System.out.println("나이: " + age);
    }
}

// 문제점:
// 1. introduce() 메서드가 3개 클래스에 동일하게 존재
// 2. name, age 필드가 3개 클래스에 중복
// 3. 나중에 introduce()를 수정하면 3곳 모두 수정해야 함
// 4. 버그가 생기기 쉬움


// ============================================
// ✅ 상속을 사용하면 이렇게 됨 (코드 중복 제거!)
// ============================================

// 1단계: 공통 부분을 부모 클래스로 추출
class Person {
    String name;
    int age;
    
    // 공통 메서드 - 한 번만 작성!
    public void introduce() {
        System.out.println("이름: " + name);
        System.out.println("나이: " + age);
    }
    
    // 전체 정보 출력 (자식 클래스에서 구체화할 수 있음)
    public void printInfo() {
        System.out.println("이름: " + name);
        System.out.println("나이: " + age);
    }
}

// 2단계: 자식 클래스는 고유한 부분만 작성
class Student extends Person {
    String studentId;  // Student만 가진 속성
    
    // 부모의 printInfo()를 오버라이드 (재사용하되, 추가 정보 포함)
    @Override
    public void printInfo() {
        super.printInfo();  // 부모의 코드 재사용!
        System.out.println("학번: " + studentId);
    }
}

class Teacher extends Person {
    String teacherId;  // Teacher만 가진 속성
    
    @Override
    public void printInfo() {
        super.printInfo();  // 부모의 코드 재사용!
        System.out.println("교사ID: " + teacherId);
    }
}

class Parent extends Person {
    // Parent는 고유한 속성이 없으면 그냥 상속만 사용
    // introduce()와 printInfo()를 그대로 사용!
}


// ============================================
// 🎯 실제 사용 예제
// ============================================

public class InheritanceExample {
    public static void main(String[] args) {
        // Student 객체 생성
        Student student = new Student();
        student.name = "김철수";
        student.age = 20;
        student.studentId = "2024001";
        
        // Teacher 객체 생성
        Teacher teacher = new Teacher();
        teacher.name = "이선생";
        teacher.age = 35;
        teacher.teacherId = "T001";
        
        // 모두 동일하게 introduce() 사용 가능
        // (부모 클래스에서 한 번만 정의됨)
        student.introduce();
        teacher.introduce();
        
        System.out.println();
        
        // printInfo()는 각자 다르게 출력됨
        student.printInfo();
        System.out.println();
        teacher.printInfo();
    }
}

// 출력:
// 이름: 김철수
// 나이: 20
// 이름: 이선생
// 나이: 35
//
// === 학생 정보 ===
// 이름: 김철수
// 나이: 20
// 학번: 2024001
//
// === 교사 정보 ===
// 이름: 이선생
// 나이: 35
// 교사ID: T001


// ============================================
// 📊 장점 비교 (수정이 필요할 때)
// ============================================

/*
❌ 상속 없음:
- introduce() 메서드를 수정해야 함
- Student, Teacher, Parent 3곳 모두 수정 필요
- 한 곳만 빠뜨리면 버그 발생
- 코드 유지보수 어려움

✅ 상속 사용:
- introduce() 메서드를 Person 클래스에서만 수정
- 모든 자식 클래스가 자동으로 최신 코드 사용
- 버그 위험 최소화
- 코드 유지보수 쉬움
*/


// ============================================
// 💡 좀 더 복잡한 예제 (실전)
// ============================================

// 좋은 예: 공통 메서드를 부모에서 한 번만 구현
class Vehicle {
    String brand;
    int speed;
    
    public void start() {
        System.out.println(brand + "가 시동을 겁니다");
    }
    
    public void stop() {
        System.out.println(brand + "가 멈춥니다");
    }
    
    public void printInfo() {
        System.out.println("브랜드: " + brand);
        System.out.println("속도: " + speed + "km/h");
    }
}

class Car extends Vehicle {
    int numberOfDoors;
    
    @Override
    public void printInfo() {
        super.printInfo();  // start(), stop(), printInfo()는 부모에서 자동 상속
        System.out.println("문의 개수: " + numberOfDoors);
    }
}

class Motorcycle extends Vehicle {
    boolean hasWindshield;
    
    @Override
    public void printInfo() {
        super.printInfo();  // start(), stop()는 자동 상속
        System.out.println("방풍막: " + (hasWindshield ? "있음" : "없음"));
    }
}

// 코드 중복이 거의 없음!
// Vehicle.start(), Vehicle.stop()은 한 번만 정의됨
