<?php

require('config.php');
require('class.mysqli.php');


$db = new db($CONFIG['SQL']);

$core = getCoreFunctions();
$functions = getFunctions();// Function_Usage
$parameters = getParameters();
$seeAlso = getSeeAlso();


echo "<pre>";

foreach($functions as $key => $f){
	$out[$key][] = "\r\n";
	$out[$key][] = "/**";
	$out[$key][] = "\t* ". cleanup($f['desc_long']);
	$out[$key][] = "\t*";
	
	foreach($parameters as $p){
		if($p[function_id] == $f[function_id]){
			$out[$key][] = "\t* @param " . $p['parameter'] . " " . cleanup($p['description']);
		}
	}
	$out[$key][] = "\t* @return " . $f[return_value];
	foreach($seeAlso as $sa){
		if($sa[function_id] == $f[function_id]){
			$out[$key][] = "\t* @see get" . ucfirst($core[$sa[sibling]][name]) . "()";
		}
	}
	
	$out[$key][] = "\t*";
	$out[$key][] = "\t*/";
	$out[$key][] = "\tpublic static String get" . ucfirst(cleanup($f['usage'])) ." {";
	$out[$key][] = "\t\treturn " . $f[name] . ";";
	$out[$key][] = "\t}\r\n";
	$out[$key][] = "\r\n";
	echo implode("\r\n", $out[$key]);
}

function cleanup($string){
	$cleanup = array("\r","\n","<p>","</p>","<br>", "<i>", "</i>", "<b>", "</b>");
	return str_replace($cleanup, "", $string);
}


/*
echo "<pre>";
print_r($parameters);
echo "</pre>";

echo "<pre>";
print_r($functions);
echo "</pre>";
*/
function getFunctions(){
	global $db;
	$qry = "
		SELECT * FROM core_f_usage AS fu
		LEFT JOIN core_function AS f ON f.id = fu.function_id
	";
	return $db->qry($qry);
}

function getCoreFunctions(){
	global $db;
	$db->setIndex("id");
	$qry = "SELECT * FROM core_function";
	return $db->qry($qry);
}

function getParameters(){
	global $db;
	$qry = "SELECT * FROM core_f_parameter";
	return $db->qry($qry);
}

function getSeeAlso(){
	global $db;
	$qry = "SELECT * FROM core_f_see_also";
	return $db->qry($qry);
}



?>