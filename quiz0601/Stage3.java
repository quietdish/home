package be_study.quiz.quiz0601;
//🔹 3단계: 객체배열 + 생성 메서드 + 다양한 조합 (21~30)
public class Stage3 {

//21. 길이를 입력받아 Person 배열을 생성해 리턴하는 메서드를 작성하라.
	static Person[] createPeopleArray(int length) {
		return new Person[length];		// 메서드 매개변수로 길이 받는 거..
	}

//22. Person 배열에 대해 모든 사람의 나이를 합산하는 메서드를 작성하라.
	static int totalAge(Person[] people) {
		int sum = 0;
		for (Person p : people) sum += p.age;
		return sum;
	}
	
//23. Person 배열을 전달하면, 모든 나이를 10으로 초기화하는 메서드를 만들어라.
	static void resetAge(Person[] people) {
		for (Person p : people)
			p.age = 10;
	}
	
//24. Person 배열의 name만 따로 String[] 에 담아 리턴하는 메서드를 작성하라.	
	static String[] getNames(Person[] people) {
		String[] names = new String[people.length];
		for (int i = 0; i < people.length; i++)
			names[i] = people[i].name;
		return names;		
	}

//27. 이름으로 Person을 검색하여 해당 객체를 리턴하는 메서드를 작성하라.
	static Person findName(Person[] people, String name) {
		for (Person p : people) {
			
			// *핵심*
				//방이 비어있으면 && 뒷부분은 무시하고 다음 방으로..
			if (p != null && p.name.equals(name))
							// 
				return p;		//문자 비교는 equals로.. == 말고.
		}							
		return null;	//없으면 null
	}

	//29.
	static Person copyName(Person origin) {
		
		if (origin == null)	
			return null;	// null 객체 복사 때 오류.. 실무에서 씀..
							// 미리 null 체크하고 튕겨내는 거..
		Person copy = new Person();
		copy.name = origin.name;
		return copy;
				// copyName {} 끝나는 순간, copy 이름표 소멸...
	}
		
//30. Person 배열을 전달받아, age가 30 이상인 사람만 새로운 배열로 리턴하라.
	static Person[] filterAge(Person[] people) {
		int count = 0;
		for (Person p : people)
			if (p != null && p.age >= 30) count++;
		
		Person[] result = new Person[count];
		int idx = 0;
		for (Person p : people)
			if (p != null && p.age >= 30) result[idx++] = p;
		return result;
	}
	
	
	
	
	
//메인(메소드)
	public static void main(String[] args) {

//21.
		Person[] arr = createPeopleArray(3);
	//(21.) 출력 추가..
		System.out.println("배열 길이 : " + arr.length);
		
		System.out.println();

//(25번) Person을 생성해서 배열 인덱스 0에 넣는 방법을 코드로 작성하라.
		Person p = new Person();
		
		p.name = "karina";
		p.age = 26;
		arr[0] = p;
		
		arr[1] = new Person();
		arr[1].name = "winter";
		arr[1].age = 25;
		
		arr[2] = new Person();
		arr[2].name = "giselle";
		arr[2].age = 25;

//22.
		System.out.println("totalAge : " + totalAge(arr));
		
		System.out.println();
//23.
		resetAge(arr);
		for (Person person : arr)
			System.out.print(person.age + " ");
			
		System.out.println();
		System.out.println();
//24.
		String[] names = getNames(arr);
		for (String n : names)
			System.out.print(n + " ");
		System.out.println();

		System.out.println();
		System.out.print("//25번 코드 - main 21번, 22번 사이에..");
		
		System.out.println();
		System.out.println();
//26. Person 배열 일부 요소는 null일 때, null 검사를 하며 출력하는 코드를 작성하라.
		Person[] withNull = new Person[4];
		
	//임의로 ...
		withNull[0] = arr[0];	
					// arr의 0번 방 사람을 -> withNull의 0번 방에..
		withNull[2] = arr[1];
					// arr의 1번 방 사람을 -> withNull의 2번 방에..
	// -> [1],[3] 은 null
		
		for (Person person : withNull) {
            if (person != null) {
            	System.out.println(person.name);
            } else {
            	System.out.println("(null)");
            }
        }
		
		System.out.println();
	//27.				//findName메서드
		Person found1 = findName(arr, "karina");
		Person found2 = findName(arr, "ningning"); //배열에 없는 이름
		
									//삼항연산자.. if-else문을 1줄로.
		System.out.println("found: " + (found1 != null ? found1.name : "없음"));
		System.out.println("found: " + (found2 != null ? found2.name : "없음"));
									//구조 -> (조건식 ? 참일 때 값 : 거짓일 때 값)
									//	found가 null이 아닌지 조건 확인..
		
		System.out.println();
//28. Person 배열을 생성하되, *짝수* 인덱스에만 객체를 넣고 나머지는 null로 두어라.	
		Person[] sparse = new Person[6];
										// 2씩 늘어남..
        for (int i = 0; i < sparse.length; i += 2) {
            sparse[i] = new Person();
            sparse[i].name = "P" + i;
        }
        
     //(28.) 출력 추가..
        for (Person person : sparse) {
            if (person != null) {
                System.out.print(person.name + " ");
            } else {
                System.out.print("(null) ");
            }
        }
        System.out.println();
        System.out.println();
        
//29. Person을 전달받아 새로운 Person을 만들어 반환하되, name만 복사해라.
        		//새 변수(바구니)... static 에서 copy는 임시이름표..
        Person copyResult = copyName(arr[0]);
        System.out.println("copy name : " + copyResult.name + ", age : " + copyResult.age);
            
		System.out.println();
	//30.
		//나이 다시 세팅
		arr[0].age = 22;
		arr[1].age = 31;
		arr[2].age = 33;
		
		Person[] seniors = filterAge(arr);
	    for (Person s : seniors) {
	    	System.out.println(s.name + " : " + s.age);
	    }
	    	    
	}

}