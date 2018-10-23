<?php

	ini_set("soap.wsdl_cache_enabled","0");
	try{
		$client = new SoapClient("Lecture.wsdl");
	} catch(Exception $e){
		echo 'Caught exception: ',  $e->getMessage(), "\n";
	}
	


	$studInfo = $client->fnGetStudQuery('syiera');
	echo $studInfo['strFirstName'];
	echo $studInfo['strLastName'];
	echo $studInfo['strUserLvl'];
	echo $studInfo['strLastLogin'];
?>