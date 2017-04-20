<?php

$CONFIG['environment'] = "dev";
$CONFIG['defaultTimeZone'] = "Europe/Brussels";

switch( $CONFIG['environment'] ){
	case "dev":	
		$CONFIG['SQL']['host'] = "localhost";
		$CONFIG['SQL']['user'] = "root";
		$CONFIG['SQL']['pass'] = "";
		$CONFIG['SQL']['database'] = "tedagen";
		$CONFIG['detailErrors'] = true;
		break;
}


/*
	Do not modify below this line
*/
date_default_timezone_set($CONFIG['defaultTimeZone']);



?>