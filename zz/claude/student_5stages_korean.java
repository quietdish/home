// ============================================
// 학생 클래스로 배우는 객체지향 5단계
// 한글로 정리한 버전
// ============================================


// ============================================
// 1단계: 기본 클래스 (클래스, 객체)
// ============================================
// 개념: "틀을 만들고, 그 틀로 실제 것(객체)을 만든다"

class 학생_버전1 {
    // 속성들 (데이터)
    String 이름;
    int 나이;
    String 학번;
    
    // 생성자 (객체를 만들 때 초기값을 설정)
    public 학생_버전1(String 이름, int 나이, String 학번) {
        this.이름 = 이름;
        this.나이 = 나이;
        this.학번 = 학번;
    }
    
    // 메서드들 (행동)
    public void 공부하기() {
        System.out.println(이름 + "이(가) 공부 중입니다");
    }
    
    public void 정보출력() {
        System.out.println("=== 학생 정보 ===");
        System.out.println("이름: " + 이름);
        System.out.println("나이: " + 나이);
        System.out.println("학번: " + 학번);
    }
}

public class 단계1_기본클래스 {
    public static void main(String[] args) {
        // 객체 생성 (틀로 실제 것을 만듦)
        학생_버전1 학생1 = new 학생_버전1("김철수", 20, "2024001");
        학생_버전1 학생2 = new 학생_버전1("이영희", 21, "2024002");
        
        // 객체 사용
        학생1.공부하기();
        학생1.정보출력();
        
        System.out.println();
        
        학생2.공부하기();
        학생2.정보출력();
    }
}

// 출력:
// 김철수이(가) 공부 중입니다
// === 학생 정보 ===
// 이름: 김철수
// 나이: 20
// 학번: 2024001
//
// 이영희이(가) 공부 중입니다
// === 학생 정보 ===
// 이름: 이영희
// 나이: 21
// 학번: 2024002


// ============================================
// 2단계: private/public 추가 (캡슐화)
// ============================================
// 개념: "중요한 데이터는 보호하고, 규칙을 정해서만 변경하게 한다"

class 학생_버전2 {
    // private: 외부에서 직접 접근 불가 (보호됨)
    private String 이름;
    private int 나이;
    private String 학번;
    private double 학점;  // 나중에 추가
    
    // 생성자
    public 학생_버전2(String 이름, int 나이, String 학번) {
        this.이름 = 이름;
        this.나이 = 나이;
        this.학번 = 학번;
        this.학점 = 0.0;
    }
    
    // getter: 읽기만 허용 (데이터를 꺼낼 수 있음)
    public String 이름_가져오기() {
        return 이름;
    }
    
    public int 나이_가져오기() {
        return 나이;
    }
    
    public String 학번_가져오기() {
        return 학번;
    }
    
    public double 학점_가져오기() {
        return 학점;
    }
    
    // setter: 유효성 검사 후 변경 허용 (규칙을 정해서만 변경)
    public void 학점_설정(double 새학점) {
        // 유효성 검사: 학점은 0.0 ~ 4.5 사이만 가능
        if (새학점 < 0.0 || 새학점 > 4.5) {
            System.out.println("❌ 잘못된 학점입니다");
            return;
        }
        this.학점 = 새학점;
        System.out.println("✅ 학점이 설정되었습니다");
    }
    
    public void 나이_증가() {
        this.나이 = this.나이 + 1;
        System.out.println(이름 + "의 나이가 1살 증가했습니다");
    }
    
    // 메서드들
    public void 공부하기() {
        System.out.println(이름 + "이(가) 공부 중입니다");
    }
    
    public void 정보출력() {
        System.out.println("=== 학생 정보 ===");
        System.out.println("이름: " + 이름);
        System.out.println("나이: " + 나이);
        System.out.println("학번: " + 학번);
        System.out.println("학점: " + 학점);
    }
}

public class 단계2_캡슐화 {
    public static void main(String[] args) {
        학생_버전2 학생1 = new 학생_버전2("김철수", 20, "2024001");
        
        // private이므로 이렇게 할 수 없음:
        // 학생1.이름 = "박영수";  // ❌ 불가능
        // 학생1.학점 = 5.0;      // ❌ 불가능
        
        // 대신 getter/setter를 사용:
        System.out.println("학생 이름: " + 학생1.이름_가져오기());
        
        // 유효성 검사와 함께 설정
        학생1.학점_설정(3.8);      // ✅ 가능 (유효한 값)
        학생1.학점_설정(5.0);      // ❌ 불가능 (유효하지 않은 값)
        
        학생1.나이_증가();
        학생1.정보출력();
    }
}

// 출력:
// 학생 이름: 김철수
// ✅ 학점이 설정되었습니다
// ❌ 잘못된 학점입니다
// 김철수의 나이가 1살 증가했습니다
// === 학생 정보 ===
// 이름: 김철수
// 나이: 21
// 학번: 2024001
// 학점: 3.8


// ============================================
// 3단계: Person 상속받기 (상속)
// ============================================
// 개념: "공통 부분은 부모에서 정의하고, 고유한 부분은 자식에서 정의한다"

// 부모 클래스: 모든 사람이 공통으로 가진 것
class 사람 {
    protected String 이름;      // protected: 자식 클래스는 접근 가능
    protected int 나이;
    
    public 사람(String 이름, int 나이) {
        this.이름 = 이름;
        this.나이 = 나이;
    }
    
    // 공통 메서드
    public void 소개하기() {
        System.out.println("안녕하세요, 저는 " + 이름 + "입니다");
    }
    
    public void 나이_증가() {
        this.나이 = this.나이 + 1;
    }
}

// 자식 클래스: 학생만의 고유한 것
class 학생_버전3 extends 사람 {
    // 학생만의 속성
    private String 학번;
    private double 학점;
    
    // 생성자
    public 학생_버전3(String 이름, int 나이, String 학번) {
        super(이름, 나이);  // 부모의 생성자 호출
        this.학번 = 학번;
        this.학점 = 0.0;
    }
    
    // 학생만의 메서드
    public void 공부하기() {
        System.out.println(이름 + "이(가) 공부 중입니다");
    }
    
    public void 학점_설정(double 새학점) {
        if (새학점 < 0.0 || 새학점 > 4.5) {
            System.out.println("❌ 잘못된 학점입니다");
            return;
        }
        this.학점 = 새학점;
    }
    
    public void 정보출력() {
        System.out.println("=== 학생 정보 ===");
        System.out.println("이름: " + 이름);
        System.out.println("나이: " + 나이);
        System.out.println("학번: " + 학번);
        System.out.println("학점: " + 학점);
    }
}

// 다른 자식 클래스
class 교사 extends 사람 {
    // 교사만의 속성
    private String 교사ID;
    private String 담당과목;
    
    public 교사(String 이름, int 나이, String 교사ID, String 담당과목) {
        super(이름, 나이);  // 부모의 생성자 호출
        this.교사ID = 교사ID;
        this.담당과목 = 담당과목;
    }
    
    public void 수업하기() {
        System.out.println(이름 + "이(가) " + 담당과목 + " 수업을 진행 중입니다");
    }
    
    public void 정보출력() {
        System.out.println("=== 교사 정보 ===");
        System.out.println("이름: " + 이름);
        System.out.println("나이: " + 나이);
        System.out.println("교사ID: " + 교사ID);
        System.out.println("담당과목: " + 담당과목);
    }
}

public class 단계3_상속 {
    public static void main(String[] args) {
        학생_버전3 학생 = new 학생_버전3("김철수", 20, "2024001");
        교사 교사1 = new 교사("이선생", 35, "T001", "수학");
        
        // 부모 클래스의 메서드를 사용 (상속받음)
        학생.소개하기();  // 부모의 메서드
        교사1.소개하기();  // 부모의 메서드
        
        System.out.println();
        
        // 자식 클래스의 메서드를 사용
        학생.공부하기();
        교사1.수업하기();
        
        System.out.println();
        
        학생.정보출력();
        System.out.println();
        교사1.정보출력();
    }
}

// 출력:
// 안녕하세요, 저는 김철수입니다
// 안녕하세요, 저는 이선생입니다
//
// 김철수이(가) 공부 중입니다
// 이선생이(가) 수학 수업을 진행 중입니다
//
// === 학생 정보 ===
// 이름: 김철수
// 나이: 20
// 학번: 2024001
// 학점: 0.0
//
// === 교사 정보 ===
// 이름: 이선생
// 나이: 35
// 교사ID: T001
// 담당과목: 수학


// ============================================
// 4단계: printInfo() 오버라이드 (다형성)
// ============================================
// 개념: "같은 메서드 이름인데 객체에 따라 다르게 구현한다"

class 사람2 {
    protected String 이름;
    protected int 나이;
    
    public 사람2(String 이름, int 나이) {
        this.이름 = 이름;
        this.나이 = 나이;
    }
    
    // 이 메서드를 자식 클래스에서 다르게 구현할 예정
    public void 정보출력() {
        System.out.println("이름: " + 이름);
        System.out.println("나이: " + 나이);
    }
}

class 학생_버전4 extends 사람2 {
    private String 학번;
    private double 학점;
    
    public 학생_버전4(String 이름, int 나이, String 학번) {
        super(이름, 나이);
        this.학번 = 학번;
        this.학점 = 0.0;
    }
    
    // 부모의 정보출력()을 오버라이드 (다르게 구현)
    @Override
    public void 정보출력() {
        System.out.println("=== 학생 정보 ===");
        super.정보출력();  // 부모의 기본 정보 출력
        System.out.println("학번: " + 학번);
        System.out.println("학점: " + 학점);
    }
}

class 교사2 extends 사람2 {
    private String 교사ID;
    private String 담당과목;
    
    public 교사2(String 이름, int 나이, String 교사ID, String 담당과목) {
        super(이름, 나이);
        this.교사ID = 교사ID;
        this.담당과목 = 담당과목;
    }
    
    // 부모의 정보출력()을 오버라이드 (다르게 구현)
    @Override
    public void 정보출력() {
        System.out.println("=== 교사 정보 ===");
        super.정보출력();  // 부모의 기본 정보 출력
        System.out.println("교사ID: " + 교사ID);
        System.out.println("담당과목: " + 담당과목);
    }
}

public class 단계4_다형성 {
    public static void main(String[] args) {
        학생_버전4 학생 = new 학생_버전4("김철수", 20, "2024001");
        교사2 교사 = new 교사2("이선생", 35, "T001", "수학");
        
        // 다형성!
        // 같은 메서드 이름인데 다르게 출력됨
        System.out.println("=== 다형성 예제 ===");
        학생.정보출력();  // 학생만의 방식으로 출력
        System.out.println();
        교사.정보출력();  // 교사만의 방식으로 출력
    }
}

// 출력:
// === 다형성 예제 ===
// === 학생 정보 ===
// 이름: 김철수
// 나이: 20
// 학번: 2024001
// 학점: 0.0
//
// === 교사 정보 ===
// 이름: 이선생
// 나이: 35
// 교사ID: T001
// 담당과목: 수학


// ============================================
// 5단계: 추상클래스/인터페이스 적용 (추상화)
// ============================================
// 개념: "반드시 구현해야 할 메서드를 정해서 강제한다"

// 추상 클래스 (완성되지 않은 클래스)
abstract class 학교인물 {
    protected String 이름;
    protected int 나이;
    
    public 학교인물(String 이름, int 나이) {
        this.이름 = 이름;
        this.나이 = 나이;
    }
    
    // 일반 메서드 (구현됨)
    public void 소개하기() {
        System.out.println("안녕하세요, 저는 " + 이름 + "입니다");
    }
    
    // 추상 메서드 (구현 안 됨 - 자식이 반드시 구현해야 함)
    abstract public void 역할수행();
    abstract public void 정보출력();
}

class 학생_버전5 extends 학교인물 {
    private String 학번;
    private double 학점;
    
    public 학생_버전5(String 이름, int 나이, String 학번) {
        super(이름, 나이);
        this.학번 = 학번;
        this.학점 = 0.0;
    }
    
    // 반드시 구현해야 함
    @Override
    public void 역할수행() {
        System.out.println(이름 + "이(가) 공부하고 있습니다");
    }
    
    @Override
    public void 정보출력() {
        System.out.println("=== 학생 정보 ===");
        System.out.println("이름: " + 이름);
        System.out.println("나이: " + 나이);
        System.out.println("학번: " + 학번);
        System.out.println("학점: " + 학점);
    }
}

class 교사_버전5 extends 학교인물 {
    private String 교사ID;
    private String 담당과목;
    
    public 교사_버전5(String 이름, int 나이, String 교사ID, String 담당과목) {
        super(이름, 나이);
        this.교사ID = 교사ID;
        this.담당과목 = 담당과목;
    }
    
    // 반드시 구현해야 함
    @Override
    public void 역할수행() {
        System.out.println(이름 + "이(가) " + 담당과목 + " 수업을 진행 중입니다");
    }
    
    @Override
    public void 정보출력() {
        System.out.println("=== 교사 정보 ===");
        System.out.println("이름: " + 이름);
        System.out.println("나이: " + 나이);
        System.out.println("교사ID: " + 교사ID);
        System.out.println("담당과목: " + 담당과목);
    }
}

public class 단계5_추상화 {
    public static void main(String[] args) {
        학교인물[] 인물들 = {
            new 학생_버전5("김철수", 20, "2024001"),
            new 교사_버전5("이선생", 35, "T001", "수학")
        };
        
        System.out.println("=== 학교 인물들 소개 ===");
        for (학교인물 인물 : 인물들) {
            인물.소개하기();
            인물.역할수행();
            인물.정보출력();
            System.out.println();
        }
    }
}

// 출력:
// === 학교 인물들 소개 ===
// 안녕하세요, 저는 김철수입니다
// 김철수이(가) 공부하고 있습니다
// === 학생 정보 ===
// 이름: 김철수
// 나이: 20
// 학번: 2024001
// 학점: 0.0
//
// 안녕하세요, 저는 이선생입니다
// 이선생이(가) 수학 수업을 진행 중입니다
// === 교사 정보 ===
// 이름: 이선생
// 나이: 35
// 교사ID: T001
// 담당과목: 수학


// ============================================
// 💡 종합 정리: 객체지향의 5가지 개념
// ============================================

/*
1단계 - 클래스와 객체
  → "틀을 만들고, 그 틀로 실제 것을 만든다"
  → 틀(클래스) = 설계도
  → 실제 것(객체) = 쿠키 틀로 찍은 쿠키

2단계 - 캡슐화
  → "중요한 데이터는 보호하고, 규칙을 정해서만 변경한다"
  → private: 보호
  → 메서드: 규칙 정의

3단계 - 상속
  → "공통 부분은 부모에서, 고유한 부분은 자식에서"
  → 코드 중복 제거
  → extends로 상속

4단계 - 다형성
  → "같은 메서드 이름인데 객체에 따라 다르게 구현한다"
  → @Override로 구현
  → 유연한 코드 작성

5단계 - 추상화
  → "반드시 구현해야 할 메서드를 정해서 강제한다"
  → abstract로 표시
  → 일관성 있는 구조
*/
