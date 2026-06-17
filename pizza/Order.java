package be_study.temp;

import java.util.ArrayList;

public class Order {	// 주문 객체 -> 주문 한 건
	
	//주문번호
	int orderNum; // 1 2 3 .. 99 ..
	
	//피자 주문 여러개
	//Pizza pizza;	//하나밖에 주문 못 함....
	//Pizza[] pizzaArr;		배열 보다 어레이리스트 !
	ArrayList<Pizza> pizzaList;	//주문한 피자 메뉴 목록		//import check
	
	
	//누가 어디로 전화번호
	
//	String customerName;
//	String customerAddress;
//	String customerPhone;
	
	Customer customer;		//한꺼번에..
	
	Delivery delivery;
	
	
}
