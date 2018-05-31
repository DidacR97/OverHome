<?php

	$host_db = "localhost";
	$user_db = "root";
	$pass_db = "admin";
	$db_name = "overhome";
	$tbl_name = "oh_zone";
	$tbl_items = "oh_object";
	$tbl_values = "oh_value";
	$zones = array();
	$items = array();
	$err = -1;

	$conexion = new mysqli($host_db, $user_db, $pass_db, $db_name);

	if ($conexion->connect_error) {
	 file_put_contents ("phpLog.txt" , "Error" );// [ $flags = FILE_APPEND [$context ]]
	}


	$n= "general_0001";


	try{
		$n_temp = $_GET["param"];
	}catch(Exception $e){}

	if(!is_null($n_temp)){
		$n = $n_temp;
	}

	//$nombre = $_GET["onclick"];

	$sql = "SELECT * FROM $tbl_name WHERE NAME = '$n'";
	
	$result = $conexion->query($sql);
	if ($result->num_rows > 0) {
		$name = $result->fetch_assoc();
		$svg = $name['SVG_NAME'];
		$zone_name = $name['DESCRIPTION'];
	}else{
		$n= "general_0001";
		$sql = "SELECT * FROM $tbl_name WHERE NAME = '$n'";
		$result = $conexion->query($sql);
		$name = $result->fetch_assoc();
		$svg = $name['SVG_NAME'];
		$zone_name = $name['DESCRIPTION'];
		$err = 1;
	}

	$sql = "SELECT * FROM $tbl_name";
	$result = $conexion->query($sql);

	while(($row =  mysqli_fetch_assoc($result))) {
			$inf = array();
			$inf["name"] = $row['NAME'];
			$inf["desc"] = $row['DESCRIPTION'];
	    	array_push($zones,$inf);		
	}

	if($n == "general_0001"){
		$sql = "SELECT I.id,I.DESCRIPTION,Z.NAME,V.VALUE FROM $tbl_items I 
				JOIN $tbl_name as Z ON I.ZONE_ID = Z.ID 
				JOIN $tbl_values as V ON I.id = V.OBJECT_ID ORDER BY I.ID";
	}else {
		$sql = "SELECT I.id,I.DESCRIPTION,Z.NAME,V.VALUE FROM $tbl_items I 
				JOIN $tbl_name as Z ON I.ZONE_ID = Z.ID 
				JOIN $tbl_values as V ON I.id = V.OBJECT_ID
				WHERE Z.NAME LIKE '$n'";
	}

	$result = $conexion->query($sql);

	while(($row =  mysqli_fetch_assoc($result))) {
			$inf = array();	
			$inf["id"] = $row['id'];
			$inf["desc"] = $row['DESCRIPTION'];
			$inf["zone"] = $row['NAME'];
			$inf["val"] = $row['VALUE'];
	    	array_push($items,$inf);
	}

	date_default_timezone_set('Europe/Madrid');
	$date = date('H:i:s ');

	
/*

SELECT I.id,Z.NAME,V.VALUE FROM oh_object I 
JOIN oh_zone as Z ON I.ZONE_ID = Z.ID 
JOIN oh_value as V ON I.id = V.OBJECT_ID

*/
	
	
    


echo'
<html>
	<head>
		<title>Overhome</title>
		<link rel="stylesheet" type="text/css" href="../styles/estilo.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script>
            function updateValues(idObject){
                $.post("chargeItems.php",{
                	id : idObject
                },
                function(data, status){
        			//alert("Data: " + data + "\nStatus: " + status);
    			}
                );
            };
            </script>
            ';
		if($err == 1){
			echo'
			<script>
				function() {
				    alert("URL Changed");
				}
			</script>';
		}

    echo'
	</head>
	<body>
		<header>
			<img src="../images/overtakenOH_logo.svg" id="imgHeader"/>
			<div id="pageTitle_name">
				<h1 id="title_Name">'.$zone_name.'</h1>
			</div>
			<div id="pageTitle_hour">
				<h1 id="text_Time">'.$date.'</h1>
				<script type="text/javascript">
					setInterval(function(){ 
					   	momentoActual = new Date(); 
					   	hora = momentoActual.getHours() 
					   	minuto = momentoActual.getMinutes(); 
					   	segundo = momentoActual.getSeconds();

					   	if(hora < 10){
							hora = "0"+hora;
						} 
						if(minuto < 10){
							minuto = "0"+minuto;
						}
						if(segundo < 10){
							segundo = "0"+segundo;
						} 

					   	horaImprimible = hora + ":" + minuto + ":" + segundo;

					   	document.getElementById("text_Time").textContent = horaImprimible;},1000);					
			</script>
			</div>
		</header>'
		
		.'
		<nav class="sidenav_left">';
		foreach($zones as $zone){
			$name = $zone['name'];
			$desc = $zone['desc'];
			echo "<a href=\"http://35.204.23.49/overhome/html/mainView.php?param=$name\">$desc</a></br>";
		}
		echo'
		</nav>

		<div class="main_svg">
			
			<img src="../svgsrc/'. $svg
			.'" id="imgs" class="imagen"/>

				setInterval(function() {
					document.getElementById("imgs").src = "../svgsrc/'.$svg
					.'?time=" + new Date().getTime();
				}, 1000);

	  		</script>
		</div>

		<aside class="sidenav_right">';
		foreach($items as $item){
			$idObject = $item['id'];
			$zname = $item['zone'];
			$val = $item['val'];
			$desc = $item['desc'];
			if($val == 0){
				echo "<button id=\"$idObject\" onclick=\"updateValues('$idObject')\" type=\"submit\" class=\"redButton\">$desc</button>";
			}elseif($val == 1){
				echo "<button id=\"$idObject\" onclick=\"updateValues('$idObject')\" type=\"submit\" class=\"greenButton\">$desc</button>";
			}else{
				echo "<button id=\"$idObject\" onclick=\"updateValues('$idObject')\" type=\"submit\" class=\"yellowButton\">$desc</button>";
			}
		}
		echo'
		</aside>
	</body>
</html>';

header("Refresh: 1.5; URL='http://35.204.23.49/overhome/html/mainView.php?param=$n'");

?>