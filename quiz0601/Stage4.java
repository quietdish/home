package be_study.quiz.quiz0601;
//🔹 4단계: 원시타입 배열 + 객체 배열 + 메서드 섞기 (31~40)
//"자바에 존재하는 모든 클래스는 단 하나도 빠짐없이 Object 클래스의 자식이다."
public class Stage4 {

//(정적)메서드

// 31. int 배열과 Person 배열을 모두 출력하는 메서드를 각각 만들어라.
	
	//way01 메서드 내부에 데이터(arr, pArr)가 꽁꽁 숨겨져 있음_
			//메인에 출력없음...
	public static void method31() { //(){ ... }는 메서드 정의(선언)
		 							//();는 호출(실행하라)
		//데이터
		int[] arr = { 1, 2, 3, 4, 5 };
		Person[] pArr = { new Person(), new Person("karina", 26), new Person("winter", 25) };

		// 출력 (toString 해야됨..)
		System.out.println("1메서드.. " + arr); 	//[I@54bedef2
		System.out.println(pArr);	// 메모리주소(주소값)..
		System.out.println();
		
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		System.out.println("ㅡㅡㅡㅡㅡㅡ");
		
		for (int i = 0; i < pArr.length; i++) {
			System.out.println(pArr[i].name + " " + pArr[i].age + " ");
		// toString() 작동..	
			System.out.println(pArr[i]);
		}
		System.out.println();

	}
	
	//way02 외부(메인)에서 재료를 배달(매개변수)받아서 요리(출력)만 하는 메서드_
	public static void method31(int[] arr, Person[] pArr) {
						//method31(arr, pArr); - main..
		System.out.println("2메서드.. " + arr); //[I@776ec8df
		System.out.println();
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		for (int i = 0; i < pArr.length; i++) {
			System.out.println(pArr[i].name + " " + pArr[i].age + " ");
			System.out.println(pArr[i]); // toString() 작동
		}
		System.out.println();
	}

	
//메인(메소드)
	public static void main(String[] args) {
		
	//way01 - 호출.. 메인에 출력내용 없음...
		method31(); //매개변수 없는.. // 이 1줄 없어지면 출력 내용 다 없어짐...
					//데이터 고정식. 재사용 불가...
					//메서드가 데이터까지 다 쥐고 있어서 ()비우고 호출..

		System.out.println("=====================");
	//way02	- 메인에서 데이터를 만들어서 보냄_
		//데이터
		int[] arr = { 1, 2, 3, 4, 5 };
		Person[] pArr = { new Person(), new Person("ningning", 24), new Person("giselle", 23) };
		
		System.out.println("main...");
		System.out.println();
		
		method31(arr, pArr); //매개변수 있는..
							// 이 1줄 없어지면 출력 내용 다 없어짐...

		

// 32. Person 배열과 int 배열을 동시에 매개변수로 받아 조합해 출력하는 메서드를 작성하라.
// 33. Person 배열의 age 값을 int 배열로 변환하는 메서드를 작성하라.
// 34. int 배열을 전달받아 Person 배열로 변환하라(각 age만 채우기).
// 35. Person 객체를 복사(clone 비슷하게)해 새로운 Person을 리턴하는 메서드를 작성하라.
// 36. Person 배열을 전달받아 깊은 복사(deep copy)를 수행해 새 배열을 리턴하라.
// 37. Person 배열을 전달받아 이름이 null인 사람만 출력하라.
// 38. Person 배열과 배열 길이를 전달받아 새 배열을 만들고 기존 내용을 복사해라.
// 39. Person 객체를 전달받아 내부 값을 전부 초기화하는 메서드를 작성하라.
// 40. int 값 하나와 Person 하나를 전달받아 두 값을 비교 출력하는 메서드를 만들라.

// 🔹 5단계: 복잡한 객체 리턴/전달 패턴 연습 (41~45)
// 41. Person 객체를 여러 개 생성해 배열에 담아 리턴하는 메서드 만들기.
// 42. Person 배열을 전달해 모든 사람의 hello()를 호출하는 메서드 작성하기.
// 43. Person과 Person 배열을 동시에 매개변수로 받아 특정 위치에 저장하는 메서드 작성하기.
// 44. Person 배열을 전달받아 age 기준으로 정렬한 뒤 새 배열로 리턴하기.
// 45. Person을 전달받아 내부 필드를 수정한 뒤, 수정 결과를 main에서 확인하는 실험을 해보라.

	}

}