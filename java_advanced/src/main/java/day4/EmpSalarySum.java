package day4;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import day3.emp.Employee;

// 사원급여 합계 계산
/*
 클래스 
 data(필드) 
 	List
 	filename 
 
 기능(메서드)
 	List 초기화
 	급여 계산
 	정렬
 	출력
 */
public class EmpSalarySum {
	public static void main(String[] args) throws IOException{
		
		// emp.txt
		// 1. Scanner로 파일 열기 
		Scanner scanner = new Scanner(new File("c:/Temp/emp.txt"));
		
		List<Employee> list = new ArrayList<Employee>();  // Employee Class에 담음
		
		int sum = 0;
		
		
		// 급여순으로 정렬 (내림차순)	
		Comparator<Employee> compare = (o1,o2) -> (int)(o2.getSalary() - o1.getSalary());
		list.sort(compare);
		for(Employee emp :list) {
			System.out.println(emp);
		}
		
		System.out.println("--------------------------------------------------------------");
		
		// list.stream().sorted().foreach() (오름차순)
		list.stream()
		    .sorted(compare)
		    .forEach(System.out::println);
		    //.forEach(e -> System.out.println(e));
		
	}
}
