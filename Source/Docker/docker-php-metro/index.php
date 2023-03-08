<?php
	if(isset ($_GET['kupovina'])){
	$outcome=rand(1,3);
	if($outcome==1)
		echo "studentska";
	else if($outcome==2)
		echo "regularna";
	else if($outcome==3)
		echo "penzionerska";
	else{
		echo "Invalid";
	}
}	
?>