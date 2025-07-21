package com.yedam;

import java.util.ArrayList;

public class ListExe {
	public static void main(String[] args) {
		//ArrayList 클래스. vs 배열.
		
		// 배열을 만들 때는 아래와 같이 만들었다
		// 배열은 크기가 고정되어 있기 때문에 새로운 값을 넣기 위해서는 새로운 배열을 만들어서 다시 집어넣어주는 과정을 해야해서 불편
		// 그래서 '컬렉션'을 만든다
		
		int[] intAry = {10, 20, 30};                                     //배열
		for(int i=0; i<intAry.length; i++) {        
			System.out.println("["+i+"]번째 값 => "+intAry[i]);
		}
	
		ArrayList<Integer> list = new ArrayList<Integer>();              //컬렉션 
		// ArrayList : 클래스
		// 컬렉션은 클래스를 가져와야하기 때문에 <>로 가져오고
		// 정수타입이라고 int라고 작성x Integer로 가져와야함
		// 배열은 {}해서 값을 넣었다면 이건 add(); 메소드를 이용해 값을 추가함
		
		list.add(10);      //값 추가
		list.add(20);
		list.add(30);
		for(int i=0; i<list.size(); i++) {    //.length라는 속성이 아니라 size();라는 메소드를 이용하여 크기값을 가져옴
			System.out.println("["+i+"]번째 값 => "+list.get(i));       //값을 가져올때는 get(); 메소드를 가져와야함, 이렇게 가져오면 그 값을 반환해줌
		}
		
		
		
		// ArrayList를 가지고 DB를 수정하거나 하지 않는다. (값을 추가하고 지우고 할수는 있지만 실제로는 그렇게 작업X)
		// DB에 가서 데이터 값을 넣고 수정하고 한다!
		// 위의 Integer는 데이터가 너무 간단하니
		// Student 클래스를 만들어서 getter, setter 설정을 해보자.
		
		// 학생정보.
		ArrayList<Student> stdList = new ArrayList<Student>();
		
		Student s1 = new Student();    //인스턴스 선언
		s1.setStdNo(1000);             //학번 : 1000,
		s1.setStdName("김민식");
		s1.setPhone("010-0000-0000");
		s1.setBloodType("O");
		
		Student s2 = new Student(2000, "최민정", "010-0000-1111", "B");
		// 위에 처럼 작성할려니 계속 set, set입력을 하는 것이 불편해서 생성자를 만들자!
		// 클래스에 [Ctrl] 누르고 마우스 호버하면 해당 클래스로 바로 이동할 수 있다.
		// 생성자를 만들면 위와 같이 한번에 값을 집어 넣을 수 있음		
		
		
		stdList.add(s1);               //stdList.add(10); < 이런값은 넣을 수 없음 (에러)
		stdList.add(s2);
		stdList.add(new Student(3000, "최우식", "010-0000-2222", "A")); 
		
		for(int i=0; i<stdList.size(); i++) {
			System.out.println("학번: " + stdList.get(i).getStdNo() + 
					           ", 이름: " + stdList.get(i).getStdName() +
					           ", 연락처: " + stdList.get(i).getPhone() +
					           ", 혈액형: " + stdList.get(i).getBloodType());      
		}
		
		
		
		
		
		System.out.println("end of prog.");   //프로그램 종료를 알림
		
		
		
	}//end of main.

}//end class
