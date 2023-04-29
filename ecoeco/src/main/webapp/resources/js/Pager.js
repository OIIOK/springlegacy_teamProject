/*
 * ES6에서 지원 클래스로 페이징처리 객체를 정의함
 */

class Pager{
	//멤버변수를 반드시 constructor()안에 두어야 함
	constructor(){
		//자바스크립트는 초기값이 자동으로 채워지지 않기 때문에 0이라도 써줘야함
		this.totalRecord=0;//총 레코드수
		this.pageSize=9;//페이지당 보여질 레코드 수(내가 정하는 것)
		this.totalPage=0;//총 페이지수
		
		this.blockSize=10;//블럭당 보여질 페이지수
		this.currentPage=1;//현재 페이지
		this.firstPage=0;//블럭당 반복문의 시작페이지
		this.lastPage=0;//블럭당 반복문의 마지막페이지
		
		this.curPos=0;//페이지당 시작 인덱스(리스트 내에서 or 배열) 0/10/20
		this.num=0;//페이지당 시작 번호 
	}
	
	init(list, currentPage){//currentPage: 링크를 누르는 사람이 결정해야 하기 때문에 매개변수로 받음
		this.totalRecord=list.length;
		this.totalPage=Math.ceil(this.totalRecord/this.pageSize);
		this.currentPage=currentPage;
		this.firstPage=this.currentPage-(this.currentPage-1)%this.blockSize;
		this.lastPage=this.firstPage+(this.blockSize-1);
		this.curPos=(this.currentPage-1)*this.pageSize;
		this.num=this.totalRecord-this.curPos;
	}
}