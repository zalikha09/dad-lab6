<?php

	ini_set("soap.wsdl_cache_enabled","0");
	$client = new SoapClient("Lecture.wsdl");

	
	echo $client->fnGetHelloClass('S1G2')."<br>";
	$studInfo = $client->fnGetStudInfo('B03123123');
	echo $studInfo['strStudName']."<br>";
	echo $studInfo['strStudGender']."<br>";
	//" ".$studInfo['strStudGroup']." ".$studInfo['StudYearBirth']." "$studInfo['fltStudCGPA'];
?>