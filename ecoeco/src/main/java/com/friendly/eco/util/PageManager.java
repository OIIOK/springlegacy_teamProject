package com.friendly.eco.util;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
public class PageManager {
	private int totalRecord; // 총 게시글 수
	private int pageSize = 10; // 한 페이지 당 보여줄 게시글 수
	private int totalPage; // 총 페이지 수
	private int currentPage; // 현재 보고 있는 페이지
	private int blockSize = 5; // 한 블럭 당 보여줄 페이지 수
	private int fistPage; // 현재 보고 있는 블럭의 페이지 첫 번호
	private int lastPage; // 현재 보고 있는 블럭의 페이지 끝 번호
	private int curPos; // 한 페이지 당 ArrayList의 시작 index
	private int firstRecord; // 현재 보고 있는 페이지의 게시글 첫 번호

	// 페이징 처리 하기
	// 메소드 호출 시점 : 게시판 입장 시, 다른 페이지로 이동 시
	// list, currentPage는 HttpServletRequest로 받을 예정
	public void init(List list, HttpServletRequest request) {

		// 총 게시글 수 구하기
		totalRecord = list.size();
		// totalRecord = 78;

		// 총 페이지 수 구하기
		totalPage = (int) Math.ceil((double) totalRecord / pageSize); // 소수점 나올 수 있도록 double, 소수점 올림하기 위해 ceil

		// 현재 보고 있는 페이지
		if (request.getParameter("currentPage") != null) { // 넘어온 페이지 값이 있다면
			currentPage = Integer.parseInt(request.getParameter("currentPage")); // String으로 반환되니 형변환 필요함
		}

		// 현재 보고 있는 블럭의 페이지 첫 번호 구하기
		fistPage = currentPage - (currentPage - 1) % blockSize; // n번째 블럭의 페이지 첫 번호가 (n-1)*blockSize + 1 이 되게 하는 공식

		// 현재 보고 있는 블럭의 페이지 끝 번호 구하기
		lastPage = fistPage + (blockSize - 1);

		// 한 페이지 당 ArrayList의 시작 index 구하기
		curPos = (currentPage - 1) * pageSize;

		// 현재 보고 있는 페이지의 게시글 첫 번호 구하기
		firstRecord = totalRecord - curPos;

		// ------------------------------------------------------------------------

		System.out.println("총 게시글 수 : " + totalRecord);
		System.out.println("한 페이지 당 보여줄 게시글 수 : " + pageSize);
		System.out.println("총 페이지 수 : " + totalPage);
		System.out.println("한 블럭 당 보여줄 페이지 수 : " + blockSize);
		System.out.println("현재 보고 있는 페이지 : " + currentPage);
		System.out.println("현재 보고 있는 블럭의 페이지 첫 번호 : " + fistPage);
		System.out.println("현재 보고 있는 블럭의 페이지 끝 번호 : " + lastPage);
		System.out.println("한 페이지 당 ArrayList의 시작 index : " + curPos);
		System.out.println("현재 보고 있는 페이지의 게시글 첫 번호 : " + firstRecord);

		// totalRecord가 78라면
		// 총 게시글 수 : 78
		// 한 페이지 당 보여줄 게시글 수 : 10
		// 총 페이지 수 : 8
		// 현재 보고 있는 블럭의 페이지 첫 번호 : 6
		// 한 블럭 당 보여줄 페이지 수 : 5
		// 현재 보고 있는 페이지 : 6
		// 현재 보고 있는 블럭의 페이지 첫 번호 : 6
		// 현재 보고 있는 블럭의 페이지 끝 번호 : 10
		// 한 페이지 당 ArrayList의 시작 index : 50 (-> 6페이지는 게시글이 50~59번이 나와야 함)
		// 현재 보고 있는 페이지의 게시글 첫 번호 : 28

		// 실제 보이는 화면
		// 1p(78-69), 2p(68-59), 3p(58-49), 4p(48-39), 5p(38-29)
		// 6p(28-19), 7p(18-9), 8p(8-1) => 끝 페이지와 레코드는 부족한 채로 끝남
	}
}
