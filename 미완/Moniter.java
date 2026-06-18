package be_study.quiz.Quiz25;

public class Moniter {

	//필드
	String brand;
	
	//생성자
	Moniter(){
		
	}
	
	
	Moniter(String brand, String model){
		System.out.println("Moniter(String _brand, String model) ");
		
		this.brand = brand;
		this.model = model;
	}
	
	
	//메소드
	
	int inch() {
		return 65;
	}
	
	void modelInfo() {
		System.out.print("제조사:" + brand);
		System.out.print("모델명:" + model);
		System.out.print("인치:" + inch() + "인치");
		
		System.out.println();
		
		System.out.print("제조사:" + brand);
		System.out.print("모델명:" + model);
		System.out.print("인치:" + inch + "인치");
	}
	
	
	
	
}
