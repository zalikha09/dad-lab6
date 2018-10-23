<?php
	require_once("redmineDb.php");
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
	
	function fnGetStudQuery($strStudId){
		$hostAddr = "localhost";
		$dbName = "mockDB";
		$dbUser = "root";
		$dbPwd = "";
		$dbPort = 3306;

		$dbPDO = new PDO("mysql:host=$hostAddr;dbname=$dbName",$dbUser,$dbPwd);
		$strQry = "select * from `users`  where login = :login";
		$stmt   = $dbPDO->prepare($strQry);
		$stmt->execute(array('login' => $strStudId));
		$recordSetObj = $stmt->fetch();
		return array('strFirstName'=>$recordSetObj['firstname'],'strLastName'=>$recordSetObj['lastname'],
			'strUserLvl'=>$recordSetObj['type'],'strLastLogin'=>$recordSetObj['last_login_on']);
	}
	
	ini_set("soap.wsdl_cache_enabled","0");
	$server = new SoapServer("http://localhost/webServiceSOAP/Lecture.wsdl");
	$server->addFunction("fnGetHelloClass");
	$server->addFunction("fnGetNumStudents");
	$server->addFunction("fnGetStudInfo");
	$server->addFunction("fnGetStudQuery");
	$server->handle();
?>