package com.yedam.board;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		boolean run = true;

		System.out.println("[ 대구시청 알림정보 공지사항 게시판 ]\n");

		while (run) {
			menu();
			int guestSelect = Integer.parseInt(sc.nextLine());
			switch (guestSelect) {
			case 1: // 글목록
				postList();
				break;				
			case 2: // 글확인
				postView();
				break;				
			case 3: // 글검색
				// 글검색 >> 배열로 저장해서 나타내거나 ArrayList 사용해야함. 값이 하나로밖에 안나타남
				postSearch();
				break;				
			case 4: // 로그인
				postLogin();
				break;
			default: // 종료
				run = false;
			}
		}
		System.out.println("프로그램 종료");

	}// end of Main.
	
		
	
	
	// 메소드
	
	public static void menu() {
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println("1.목록 | 2.글확인 | 3.검색 | 4.로그인 | 9.종료");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.print("> 번호 선택: ");
	}
	
	public static void postList() {
		PostDAO pdao = new PostDAO();
		ArrayList<Post> list = pdao.findAll();
		System.out.println();
		System.out.println("번호\t제목\t\t\t\t\s\s글쓴이\t\s\s작성일");
		System.out.println("--------------------------------------------------------------");
		for(int i=0; i<list.size(); i++) {
			System.out.printf("%-5d  %-30s %-5s %-10s\n", 
					           list.get(i).getBoardNo(), 
					           list.get(i).getTitle(),
					           list.get(i).getMember().getUserName(),
					           list.get(i).getRedate());
		}
		System.out.println();
	}
	
	public static void postView() {
		Scanner sc = new Scanner(System.in);
		PostDAO pdao = new PostDAO();
		System.out.print("> 글번호 입력: ");
		int bno = Integer.parseInt(sc.nextLine());
		Post postCheck = pdao.postCheck(bno);
		
		if(postCheck != null) {
			System.out.println();
			System.out.printf("번호 : %d\n", postCheck.getBoardNo());
			System.out.printf("제목 : %s\n", postCheck.getTitle());
			System.out.printf("글쓴이 : %s\n", postCheck.getMember().getUserName());
			System.out.printf("작성일 : %s\n", postCheck.getRedate());
			System.out.println("-----------------------------------------------------------");
			System.out.println(postCheck.getContent());
			System.out.println();
		}else {
			System.out.println("해당하는 글이 없습니다.");
		}	
	}
	
	public static void postSearch() {
		Scanner sc = new Scanner(System.in);
		PostDAO pdao = new PostDAO();
		while(true) {
			System.out.println("> 검색할 항목을 선택하세요 (1.제목 / 2.글쓴이)");
			System.out.print("> ");
			int srhNo = Integer.parseInt(sc.nextLine());
			
			if(srhNo == 1) { 
				System.out.print("> 검색어를 입력하세요: ");
				String keyword = sc.nextLine();					
				
				Post searchPost = pdao.searchTitle(keyword);
				if(searchPost != null) {
					System.out.println();
					System.out.println("번호\t제목\t\t\t\t\s\s글쓴이\t\s\s작성일");
					System.out.println("--------------------------------------------------------------");
					System.out.printf("%-5d  %-30s %-5s %-10s\n", 
							           searchPost.getBoardNo(),
							           searchPost.getTitle(),
							           searchPost.getMember().getUserName(),
							           searchPost.getRedate());
					System.out.println();
				}else {
					System.out.println("해당 키워드가 검색되지 않습니다.\n");
				}break;	
				
			}else if(srhNo == 2){
				//글쓴이로 글 검색
				System.out.print("> 글쓴이를 입력하세요: ");
				String userName = sc.nextLine();					
				
				Post searchUser = pdao.searchUser(userName);
				if(searchUser != null) {
					System.out.println();
					System.out.println("번호\t제목\t\t\t\t\s\s글쓴이\t\s\s작성일");
					System.out.println("--------------------------------------------------------------");
					System.out.printf("%-5d  %-30s %-5s %-10s\n", 
							           searchUser.getBoardNo(),
							           searchUser.getTitle(),
							           searchUser.getMember().getUserName(),
							           searchUser.getRedate());
					System.out.println();
				}else {
					System.out.println("해당 글쓴이가 검색되지 않습니다.\n");
				}break;	
			}else {
				System.out.println("검색할 항목은 1번과 2번을 입력해주셔야 합니다.\n");
				continue;
			}					
		}
	}
	
	
	public static void postLogin() {
		Scanner sc = new Scanner(System.in);
		MemberDAO mdao = new MemberDAO();
		System.out.print("> ID: ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.print("> PW: ");
		String pw = sc.nextLine();

		Member login = mdao.login(id, pw);
		
		
		if (login != null) {
			System.out.print("'" + login.getUserName() + "'님 안녕하세요!\n");

			adminMenu();
			
		} else { //로그인 id, pw 값 일치하지 않을시
			System.out.println("등록되지 않은 사용자입니다.\n");
		}
	}
	
	
	public static void adminMenu() {
		Scanner sc = new Scanner(System.in);
		boolean userRun = true;
		while (userRun) {
			System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
			System.out.println("1.목록 | 2.글확인 | 3.검색 | 4.글등록 | 5.글수정 | 6.글삭제 | 9.종료");
			System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
			System.out.print("> 번호 선택: ");
			int userSelect = Integer.parseInt(sc.nextLine());

			switch (userSelect) {
			case 1: // 글목록
				postList();
				break;
			case 2: // 글확인
				postView();
				break;
			case 3: // 검색
				postSearch();
				break;
			case 4: // 글등록
				
			case 5: // 글수정
			case 6: // 글삭제
			default: // 종료
				userRun = false;
			}
		}//end while.
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}//end class


