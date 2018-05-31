<?php


?>

<?php

	$host_db = "localhost";
	$user_db = "root";
	$pass_db = "admin";
	$db_name = "overhome";
	$tbl_name = "oh_user";

	$conexion = new mysqli($host_db, $user_db, $pass_db, $db_name);

	if ($conexion->connect_error) {
	 file_put_contents ("phpLog.txt" , "Error" );// [ $flags = FILE_APPEND [$context ]]
	}


	$nombre= $_POST["uname"];
	$pass= $_POST["psw"];

	$sql = "SELECT * FROM $tbl_name WHERE NAME = '$nombre' AND PASSWORD ='$pass'";

	$result = $conexion->query($sql);

	if ($result == false || $result->num_rows == 0) {
		header('Location: http://35.204.23.49');
		
	}elseif($result->num_rows > 0){
		header('Location: http://35.204.23.49/overhome/html/mainView.php?param=general_0001');
		session_start();
	}

 	mysqli_close($conexion);
 ?>
