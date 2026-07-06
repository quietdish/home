package be_study.quiz.quiz0601;
//🔹 1단계: 기본 배열 연습 (1~10)
	//대괄호 안의 숫자 : 배열의 칸 번호(인덱스)
	//arr[0] : arr 배열의 첫번째칸에 있는 데이터 (핀포인트 주소)
public class Stage1 {
//메인은 밑에 있음..
	
//정적 ..method (class 안 메인메서드와 동일선상에 나란히)
	
	// 6. int 배열을 매개변수로 받아 평균을 구하는 메서드를 만들어라.
	static double average(int[] arr) { 	
		int sum = 0;			//arr → 매개변수(껍데기변수)
		for (int n : arr)		//고정변수X (임시이름표)
			sum += n; 	
		// sum = sum + n;
		return (double) sum / arr.length;
	}

	// 7. 배열을 전달받아 가장 큰 값을 리턴하는 메서드를 만들어라.
	static int max(int[] arr) {
		int max = arr[0];
		for (int n : arr)
			if (n > max)
				max = n;
		return max;
	}

	// 8. 배열을 전달받아 모든 요소를 1 증가시키는 메서드를 작성하라. (원본 변경 확인)
	static void addOne(int[] arr) {
		for (int i =0; i < arr.length; i++) arr[i]++;
	}
	
	// 9. 배열을 생성하는 메서드를 만들어라(길이를 받아서 0으로 채워진 배열 리턴).
	static int[] makeArray(int length) {
		return new int[length];		// 기본값 0으로 자동 초기화
	}
	
	// 10. 배열을 전달하면 역순으로 뒤집어주는 메서드를 만들어라.
	static void reverse1(int[] arr) {
		int left = 0, right = arr.length -1;
		while (left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}
	
	//10-1. 일반 메서드 O (static 메서드 X)
	void reverse2(int[] arr) {
		int left = 0, right = arr.length -1;
		while (left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}
	
	

	//main(메서드) 	main	{ ...실행(조건/반복 등) } ...종료
		//호출문은 실행문;의 한 종류(포함 관계)
		//메서드에 명령(호출)

		//출력(println)..
		// ↳ 일반메서드 안에서도 사용 가능
		
		//✔ (프린트메서드)호출문과 *동시*에 실행문..
			//System.out.println(n);
		//✔ (메서드)호출문과 *동시*에 실행문..
			//result = max(nums);
		//✔ 그냥 실행문.. (!뒤에괄호없음)
		// ↳ 변수 선언 및 초기화
			//int[] nums = {1, 2, 3, 4, 5};
			//int result = 0;

	
		//void(메인으로 돌려줄 결과값을 return 하지 않음. '출력'만 담당.)
		//일반메서드 메인메서드 둘다 void 가능
			// 값 얻는 것이 목적(리턴 필수) - double 이나 int 메서드
			// 출력, 수정 등 행동이 목적(리턴X) - void 메서드
	

//메인 ..method
	public static void main(String[] args) {

	// 1. 정수 배열을 만들어 모든 요소를 출력하라.
		int[] arr1 = { 100, 200, 300, 400 };
		// 향상된 for 문
		for (int i : arr1)
			System.out.print(i + " ");
		System.out.println("\n");

	// 2. 길이 5짜리 int 배열을 만들고 2번 인덱스에 50을 넣어라.
		int[] arr2 = new int[5];
		arr2[2] = 50;
		System.out.println("arr2[2] : " + arr2[2]);

		System.out.println();
	// 3. 배열의 길이를 출력하라.
		System.out.println("1번 length : " + arr1.length);

		System.out.println();
	// 4. 배열 요소들의 합계를 구해라.
		int sum = 0;
		for (int i : arr1)
			sum = sum + i;
		System.out.println("sum : " + sum);
		System.out.println();
		
		//	일반 for 문
			//	for ( 1. 시작점; 2. 도착지(조건); 3. 보폭 ) {
			//		.. 반복할 행동 ..
			//	}
		
	// 5. 	for 문으로 배열 요소들을 출력하라. 	
		for (int i = 0; i < arr1.length; i++)
			System.out.print(arr1[i] + " ");
		System.out.println();

		String[] names = { "karina", "winter", "ningning" };
		for (String n : names)
			System.out.print(n + " ");

		System.out.println();
		System.out.println();
		
	// 6. 평균
		System.out.println("1번 avg = " + average(arr1));
								//메서드이름(인자) 형태
								//인자 : 실제 data *진짜* 값
								//괄호 안 데이터를 던져줌..
		
		System.out.println();
	// 7. 최대값
		System.out.println("max = " + max(arr1));

		System.out.println();
	// 8. 1 증가 후 확인
		addOne(arr1);
		System.out.print("+1 : ");
		for (int i : arr1)
			System.out.print(i + " ");
		
		System.out.println();
		System.out.println();
	// 9. 배열 생성
		int[] zeros = makeArray(7);
		for (int i : zeros)
			System.out.print(i + " ");

		System.out.println();
		System.out.println();
	// 10. 배열 역순 / static 메서드..
		int[] arr10 = { 1, 2, 3, 4, 5 };
		reverse1(arr10);
		for (int i : arr10)
			System.out.print(i + " ");
		
		System.out.println();
	// 10-1. 배열 역순 / 일반 메서드 호출..
		int[] arr11 = { 11, 22, 33, 44, 55 };
		
		// 인스턴스 객체 생성
		Stage1 s = new Stage1();
		// 객체의 일반 메서드 호출
		s.reverse2(arr11);
		
		for (int i : arr11) {
			System.out.print(i + " ");
		}
		
	}
		
		
			
	

}
