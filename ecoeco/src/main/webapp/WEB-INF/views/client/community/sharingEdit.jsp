<%@page import="com.friendly.eco.domain.SharingApplicant"%>
<%@page import="com.friendly.eco.domain.SharingCategory"%>
<%@page import="com.friendly.eco.domain.Sharing"%>
<%@page import="java.util.List"%>
<%@page import="com.friendly.eco.util.PageManager"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%
	SharingCategory sharingCategory = (SharingCategory)request.getAttribute("sharingCategory");
	Sharing sharing = (Sharing)request.getAttribute("sharing");
	SharingApplicant sharingApplicant = (SharingApplicant)request.getAttribute("sharingApplicant");
%>
<!DOCTYPE html>
<html lang="en">
<title>에코나눔</title>

<head>
<!-- header_link Start -->
<%@ include file="../inc/header_link.jsp"%>
<!-- header_link End -->

<!-- Latest compiled and minified CSS -->
<!-- 기본 템플릿 설정과 충돌함, 호버 효과는 포기하자!
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	 -->
<!-- jQuery library -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<style type="text/css">

.box-style{
	width:150px;
	height:150px;
	border:1px solid #ccc;
}

.box-style img{
	width:150px;
	height:150px;
}

</style>


</head>

<body>
	<!-- Spinner Start -->
	<%@ include file="../inc/spinner.jsp"%>
	<!-- Spinner End -->

	<!-- Topbar Start -->
	<%@ include file="../inc/topbar.jsp"%>
	<!-- Topbar End -->

	<!-- Navbar Start -->
	<%@ include file="../inc/navbar.jsp"%>
	<!-- Navbar End -->

	<!-- Page Header Start -->
	<div class="container-fluid page-header py-5 mb-5 wow fadeIn"
		data-wow-delay="0.1s">
		<div class="container text-center py-5">
			<h1 class="display-3 text-white mb-4 animated slideInDown">에코나눔</h1>
			<nav aria-label="breadcrumb animated slideInDown">
					<h5 class="text-white">더 가치 있는 곳으로 나눔을 실천하는 공간입니다. 원하는
						상품을 신청하면 랜덤으로 당첨됩니다.</h5>
			</nav>
		</div>
	</div>
	<!-- Page Header End -->

	<div class="container-fluid">
		<form id="form1">
		<div class="container">
			<h3 class="card-title " style="padding: 50px 0 50px 0">나눔글수정</h3>
			
			<div class="row" style="float: none; margin: 0 auto; padding: 0 0 25px 0">
				<div class="col-1"  style="vertical-align: middle;"><h5>나눔품목</h5></div>
				<div class="col-11">
				<!-- 카테고리 -->
				<div class="contanier"  >
				<select class="form-control" name="sharing_idx" >
				<option selected="">나눔 품목을 선택하세요</option>
					<!-- 카테고리 한 줄 -->
					<template v-for="json in sharingCategoryList">
					 	<row :key="json.sharingcategory_idx" :obj="json"/>
	                </template>
					<!-- 카테고리 한 줄 -->
			      </select>
			      </div>
				<!-- 카테고리 -->
			</div>
			</div>
			
			<div class="row" style="float: none; margin: 0 auto; padding: 0 0 25px 0">
				<div class="col-1"  style="vertical-align: middle;"><h5>모집인원</h5></div>
				<div class="col-11">
				<!-- 모집인원 -->
				    <div class="form-check form-check-inline">
				      <label class="form-check-label">
				        <input type="radio" class="form-check-input" name="sharing_random_range" value="1">1명
				      </label>
				    </div>
				    <div class="form-check form-check-inline">
				      <label class="form-check-label">
				        <input type="radio" class="form-check-input" name="sharing_random_range" value="5">5명
				      </label>
				    </div>
				    <div class="form-check form-check-inline">
				      <label class="form-check-label">
				        <input type="radio" class="form-check-input" name="sharing_random_range" value="10">10명
				      </label>
				    </div>
				    <div class="form-check form-check-inline">
				      <label class="form-check-label">
				        <input type="radio" class="form-check-input" name="sharing_random_range" value="30">30명
				      </label>
				    </div>
				    <div class="form-check form-check-inline">
				      <label class="form-check-label">
				        <input type="radio" class="form-check-input" name="sharing_random_range" value="50">50명
				      </label>
				    </div>
				<!-- 모집인원 -->
				</div>
			</div>
			
			<div class="row" style="float: none; margin: 0 auto; padding: 0 0 0 0">
				<div class="col-1" style="vertical-align: middle;"><h5>상품이름</h5></div>
				<div class="col-11">
				<!-- 제목 -->
				<input type="hidden" name="sharing_idx" value="<%=sharing.getSharing_idx() %>">
				<input type="hidden" name="mem_idx" value="로그인시확인되는아이디!!!!!!!!!!!!!!!!!">
				<div class="row" style="float: none; margin: 0 auto; padding: 0 0 25px 0">
					<div class="col-lg-12" style="float: none; margin: 0 auto">	
						<div class="form-group">
		                	<input type="text" class="form-control input-default " value="<%=sharing.getSharing_productname() %>" name="sharing_productname">
		                </div>
					</div>
				</div>
				<!-- 제목 -->
				</div>
			</div>
			
			<!-- 써머노트 -->
				<div class="row">
			    <div class="col-xl-12 col-xxl-12" style="float: none; margin: 0 auto; padding: 0 0 25px 0">
			    	<textarea type="text" class="form-comtrol" name="sharing_detail"></textarea> 
			    </div>
			</div>
			<!-- 써머노트 -->
			
			<!-- 파일탐색기 -->
			<div class="row form-group" style="padding: 0 0 25px 0">
					<div class="col">
						<input type="file" class="form-control" id="sharing_flie" name="sharing_flie">
						<!-- DTO 파라미터명과 일치해야함 -->
					</div>
			</div>
			<!-- 파일탐색기 -->	
			
			<div class="row" style="padding: 0 0 50px 0">
				<!-- 파일미리보기 -->
				<div class="col" align="left">
					<div class="box-style">
						<img id="sharing_thumbnail" name="sharing_thumbnail">
						<!-- DTO 파라미터명과 일치해야함 -->
					</div>
				</div>
				<!-- 파일미리보기 -->
				
				<!-- 버튼 -->
				<div class="col " align="right">	
					<div class="btn-group" role="group" aria-label="기본 예">
		            	<button type="button" class="btn btn-secondary" id="bt_edit"><font style="vertical-align: inherit;">수정</font></button>
		            	<button type="button" class="btn btn-secondary" id="bt_delete"><font style="vertical-align: inherit;">삭제</font></button>
		                <button type="button" class="btn btn-secondary" id="bt_list"><font style="vertical-align: inherit;">목록</font></button>
		             </div>
				</div>
				<!-- 버튼 -->
			</div>
			</div>
		</form>
	</div>
	


	<!-- Footer Start -->
	<%@ include file="../inc/footer.jsp"%>
	<!-- Footer End -->


	<!-- Copyright Start -->
	<%@ include file="../inc/capyright.jsp"%>
	<!-- Copyright End -->


	<!-- Back to Start -->
	<%@ include file="../inc/back_to_top.jsp"%>
	<!-- Back to End -->


	<!-- Footer link Start -->
	<%@ include file="../inc/footer_link.jsp"%>
	<!-- Footer link End -->
	
	<!-- -------------------------------------------------------------------------------- -->

	<script type="text/javascript">
	
	let form1;
	let fileObj;
	
	// template으로 반복문 처리함
	const row={
			template:`
				<option :value="sharingCategory.sharingcategory_idx" name="sharingcategory_idx">{{sharingCategory.sharingcategory_categoryname}}</option>
			`,
			//row 인스턴스 생성 시 외부에서 전달되는 파라미터를 받아옴
			props:['obj'],
			data(){
				return{
					sharingCategory:this.obj
				};
			}
	}
	
	form1 = new Vue({
		el:'#form1',
		components:{
			row
		},
		data:{
			sharingCategoryList:[]
		}
	});
	
	//카테고리 가져오기
	function scList(){
		
		$.ajax({
			url : "/rest/community/sharingCategory",
			type: "GET",
			success:function(result, status, xhr){
				form1.sharingCategoryList=result;
			},
			error:function(xhr, status, result){
				console.log("xhr : ", xhr);
				console.log("status : ", status);
				console.log("result : ", result);
			}
		});
	}
		
	//썸네일 미리보기
	function preview(file){
		
		//선택한 첫번째 파일[0]을 file로 끌어옴
		fileObj = file;
		console.log("fileObj 정보 : ",fileObj); //[object File]
		
		let reader = new FileReader(); //스트림 생성
		//로드되면 가동됨
		reader.onload=(e)=>{
			console.log("선택한 파일의 바이너리 정보 : ", e.target.result); 
			
			//key++;
			
			let json=[];
			//json['key']=key; //기준값(다른 예제에서 이미지 삭제할 때 썼던 값인데 일단 넣어놓음)
			json['binary']=e.target.result; //바이너리 정보
			json['file']=file;
			$("img[name='sharing_thumbnail']").attr("src",json.binary);
			
			console.log("넘겨받은 json : ", json);
		}
		reader.readAsDataURL(file);  //URL로 파일 읽어서 미리보여줌
	}
	
	//수정하기
	function edit(){
		
		/*let json ={};
		json['sharing_idx']=$("option[name='sharing_idx']").val();
		json['sharingCategory.sharingcategory_idx']=$("input[name='sharingcategory_idx']").val()
		json['sharing_productname']=$("input[name='sharing_productname']").val();
		json['sharing_detail']=$("textarea[name='sharing_detail']").val();
		json['sharing_thumbnail']=$("img[name='sharing_thumbnail']").val();
		json['sharing_flie']=fileObj;
		로 하면 안됨! 전송 대상에 이미지가 포함되기 때문임! 
		*/
		
		
		//입력값 formData로 담기(전송 대상에 이미지가 포함되기 때문)
		let formData = new FormData();
		
		formData.append("sharing_idx", $("input[name='sharing_idx']").val());
		formData.append("sharingCategory.sharingcategory_idx", $("option[name='sharingcategory_idx']").val());
		formData.append("sharing_productname", $("input[name='sharing_productname']").val());
		formData.append("sharing_detail", $("textarea[name='sharing_detail']").val());
		formData.append("sharing_thumbnail", $("img[name='sharing_thumbnail']").val()); //파일 이름
		formData.append("sharing_flie", fileObj); //파일 자체
		
		console.log("sharing_idx", $("input[name='sharing_idx']").val());
		console.log("sharingCategory.sharingcategory_idx", $("option[name='sharingcategory_idx']").val());
		console.log("sharing_productname", $("input[name='sharing_productname']").val());
		console.log("sharing_detail", $("textarea[name='sharing_detail']").val());
		console.log("sharing_thumbnail", $("img[name='sharing_thumbnail']").val()); //파일 이름
		console.log("sharing_flie", fileObj); 
 		 
		// 안나오면 개발자모드에서 직접 쳐봄 $("option[name='sharing_idx']").val()
		
		$.ajax({
			url:"/rest/community/sharing/edit", 
			type:"POST", 
			//data:'json', 
			contentType:false,
			processData:false,
			data:formData,
			success:function(result, status, xhr){
				console.log("입력정보", result.msg);
				alert("수정 완료 :)");
				location.href="/community/sharingList" //목록으로 돌아가기
			},
			error:function(xhr, status, err){
				console.log("xhr", xhr);
				alert("수정 실패");
			}
		});
	}
	
	//삭제하기
	function del() {

		console.log("선택한 글번호 : ", <%=sharing.getSharing_idx()%>);

		//삭제 확인하기
		if (!confirm("삭제하시겠습니까?")) {
			return;
		}

		$.ajax({
			url : "/community/sharing/del/"+ <%=sharing.getSharing_idx()%>,
			type : "POST",
			success : function(result, status, xhr) {
				alert("삭제 완료 :)");
				location.href = "/community/sharingList"
			},
			error : function(xhr, status, result) {
				console.log("xhr : ", xhr);
				console.log("status : ", status);
				console.log("result : ", result);
			}
		});
		
		//목록으로 이동
		location.href = "/community/sharingList" 
	}
	

	
	//init
	$(function(){
		//로드 시 카테고리목록 가져오기
		//scList에서 로드 시 가져온 카테고리목록을 sharingCategoryList에 담음
		//form1에서 sharingCategoryList에 담긴 목록 수만큼 row를 생성함
		scList();
		
		//서머노트 적용
 		$("textarea[name='sharing_detail']").summernote({
 			placeholder: '<%=sharing.getSharing_detail()%>',
			height: 300
		}); 
		
		//파일편집기에 이벤트 연결
		$("input[name='sharing_flie']").change(function(){
			//alert("파일 선택했어!");
			console.log("선택한 파일 정보 : "+this.files); //[object FileList]
			preview(this.files[0]); //썸네일 미리보기
			//배열로 나오는 결과물 중 첫번째 파일 하나만 필요하니 순서를 [0]으로 명시함
		});
		
 		//수정버튼 이벤트 연결
		$("#bt_edit").click(function(){
			edit();
		});
 		
 		//삭제버튼 이벤트 연결
		$("#bt_delete").click(function(){
			del();
		});
		
		//목록버튼 이벤트 연결
		$("#bt_list").click(function(){
			location.href="/community/sharingList"
		});
		
	});
	
	</script>
</body>
</html>