package be_study.quiz.quiz0601;
//🔹 2단계: 객체 + 기본 필드 연습 (11~20)
public class Stage2 {
//메서드(static)
	
//	13. Person 객체를 매개변수로 받아 name을 출력하는 메서드를 만들어라.
		
	static void printName(Person p) {
		System.out.println("name: " + p.name);
	}
	
//	14. Person 객체를 리턴하는 메서드를 작성하라(name과 age 세팅 후 리턴).	
	static Person createPerson1(String name, int age) {
		Person p = new Person();
		p.name = name;
		p.age = age;
		return p;
	}
	
	//14-1. 일반 메서드
	Person createPerson2(String name, int age) {
		Person p = new Person();
		p.name = name;
		p.age = age;
		return p;
	}
	
//	16. Person 객체를 매개변수로 받아 age를 1 증가시키는 메서드를 작성하라. (원본 확인)	
	static void increaseAge(Person p) {
		p.age++;
	}
	
	//19. 
	static void greetAll(Person[] people) {
		for	(Person p : people) p.hello();	//for 도 메인 아닌 곳에서 사용 가능..!
	}
	
	
//	20. Person 배열을 만들어 가장 나이가 많은 사람을 리턴하는 메서드를 작성하라.	
	static Person oldest(Person[] people) {
		Person oldest = people[0];
		for (Person p : people) {
			if (p.age > oldest.age) oldest = p;
		}
		return oldest;
	}
	
	
//(메서드)메인
	public static void main(String[] args) {
		
//	11. Person 객체 하나를 만들어 name과 age를 설정하고 출력하라.
		Person p1 = new Person();
		p1.name = "giselle";
		p1.age = 25;
		System.out.println(p1.name + ", " + p1.age);
		
		System.out.println();
//	12. Person 객체를 생성해 hello() 메서드를 실행해보라.
		p1.hello();
		
		System.out.println();
	//	13.
		printName(p1);
		
		System.out.println();
	//	14.
		Person p2 = createPerson1("karina", 26);
		System.out.println(p2.name + ", " + p2.age);		
	//	14-1.
		Stage2 st = new Stage2();
		Person p21 = st.createPerson2("winter", 25);
		System.out.println(p21.name + ", " + p21.age);
	
		System.out.println();
//	15. Person 두 명을 만들어 age가 큰 사람을 출력하라.
		Person older = (p1.age > p2.age) ? p1 : p2;
		System.out.println("older: " + older.name);
		
		System.out.println();
	//	16.
		System.out.println("before: " + p1.age);
		increaseAge(p1);
		System.out.println("after: " + p1.age);

		System.out.println();
//	17. Person을 만들고, 그 객체의 참조를 두 변수에 나눠 담은 뒤 값 변경 테스트를 해보라.
		Person a = new Person();
		a.name = "bell";
		Person b = a;
		b.name = "haneul";
		System.out.println(a.name);

		System.out.println();
//	18. Person 배열을 만들어 3명을 채워 넣고 이름을 출력하라.
		Person[] group = new Person[3];
		group[0] = createPerson1("natti", 24);
		group[1] = createPerson1("julie", 26);
		group[2] = createPerson1("belle", 22);
		for (Person p : group)	System.out.println(p.name);
				
		System.out.println();		
//	19. Person 배열을 매개변수로 받아 모든 사람의 hello()를 호출하라.		
		greetAll(group);
		
		System.out.println();
		
	//	20.
		System.out.println("oldest: " + oldest(group).name);
	}
	
	
}









