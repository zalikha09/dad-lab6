<?php

	function fnGetHelloClass($strSubjectCode){
		return "Hello and welcome to class ".$strSubjectCode;
	}
	
	function fnGetNumStudents($strSubjectCode){
		$items = array('BIT03123'=>70,'19283'=>100,'23489'=>234);
		return $item[$strSubjectCode];
	}
	
	function fnGetStudInfo($strStudId){
		if($strStudId=="B03123123"){
			return array('strStudName'=>'Shaikh!','strStudGender'=>'Male',
			'strStudGroup'=>'test data 2','StudYearBirth'=>'1958','fltStudCGPA'=>'3.56');
		}
		else{
			return array('strStudName'=>'Stud Not Found!','strStudGender'=>'Stud Not Found!',
			'strStudGroup'=>'Stud Not Found!','StudYearBirth'=>'Stud Not Found!','fltStudCGPA'=>'Stud Not Found!');
		}
	}
	
	ini_set("soap.wsdl_cache_enabled","0");
	$server = new SoapServer("Lecture.wsdl");
	$server->addFunction("fnGetHelloClass");
	$server->addFunction("fnGetNumStudents");
	$server->addFunction("fnGetStudInfo");
	$server->handle();
?>