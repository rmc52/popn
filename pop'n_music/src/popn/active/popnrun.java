package popn.active;

import popn.model.service.popnservice;

public class popnrun {
	public static void main(String[] args) {
		
		popnservice popn = new popnservice();
		
		
		
		System.out.println("리듬게임 pop'n music의 수록곡 및 ");
		System.out.println("채보 데이터를 관리하는 프로그램입니다.");
		System.out.println();
		System.out.println("예시 데이터 참고 링크 : https://namu.wiki/w/%E7%94%9F%E5%91%BD%E3%81%AE%E7%84%94%E7%BA%8F%E3%81%84%E3%81%A6");
		
		
		popn.displayMenu();
		
		
		
	}
}
