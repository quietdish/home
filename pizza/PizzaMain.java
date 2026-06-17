package be_study.temp;

import java.util.ArrayList;

public class PizzaMain {

	public static void main(String[] args) {
		Pizza p1 = new Pizza();
		p1.type = "페퍼로니";
		p1.size = "M";
		
		Pizza p2 = new Pizza("콤비네이션", "L");		
		Pizza p3 = new Pizza("고구마", "S");
		Pizza p4 = new Pizza("치즈", "M");
		
		System.out.println(p1.type);
		System.out.println(p2.type);
		System.out.println(p3.type);
		System.out.println(p4.type);
		
		
		Order o1 = new Order();
		o1.orderNum = 1;
		//초기화 바구니.. 필수...!
		
		o1.pizzaList = new ArrayList<Pizza>();
		// ArrayList	add();
		
		o1.pizzaList.add(p2);
		o1.pizzaList.add(p4);
		
		
		Customer c1 = new Customer();
		c1.Name = "이과장";
		c1.Address = "박스빌딩 7층";
		c1.Phone = "010-1234-4567";
		
		
		o1.customer = c1;
		
		
		
		Delivery d1 = new Delivery();
		d1.name = "나배달";
		d1.company = "빠름전달";
		d1.isDelivering = false;
		
		
		
		
		if(d1.isDelivering == false) {
			d1.order = o1;
			
			o1.delivery = d1;
//웨엑 			
			DeliveryMatch dm1 = new DeliveryMatch();
			dm1.order = o1;
			dm1.delivery = d1;
		}
		
		
		
	}

}
