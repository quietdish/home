package be_study.quiz.quiz0601;

public class Person {
    // 필드 (변수)
    public String name;
    public int age;

    // 1. 기본 생성자: new Person() 호출 시 사용
    public Person() {
        this.name = "알수없음";
        this.age = 0;
    }

    // 2. 매개변수 생성자: new Person("이름", 나이) 호출 시 사용
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 3. toString() 오버라이드: 객체를 출력할 때 원하는 형태로 보여줌
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

//package be_study.quiz.quiz0601;
//
//public class Person {
//    String name;
//    int age;
//
//    void hello() {
//        System.out.println(name + " : Hello!");
//    }
//}