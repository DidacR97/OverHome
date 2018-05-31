<?php

session_start();

	$server = "localhost";
	$id = $_POST["id"];
	$port = 12000;
	$user = "didac";

if (!extension_loaded('sockets')) {
    die('The sockets extension is not loaded.');
}

	if(!($sock = socket_create(AF_INET, SOCK_DGRAM, 0))){
   		 $errorcode = socket_last_error();
   		 $errormsg = socket_strerror($errorcode);
   		  
   		 die("Couldn't create socket: [$errorcode] $errormsg \n");
	}
 
echo "Socket created \n";
 
//Communication loop

    //Take some input to send
    $input = $id.";".$user.",";
     
    //Send the message to the server
    if( ! socket_sendto($sock, $input , strlen($input) , 0 , $server , $port))
    {
        $errorcode = socket_last_error();
        $errormsg = socket_strerror($errorcode);
         
        die("Could not send data: [$errorcode] $errormsg \n");
    }

         
    //Now receive reply from server and print it
    /*if(socket_recv ( $sock , $reply , 2045 , MSG_WAITALL ) === FALSE)
    {
        $errorcode = socket_last_error();
        $errormsg = socket_strerror($errorcode);
         
        die("Could not receive data: [$errorcode] $errormsg \n");
    }
    
    echo "Reply : $reply";*/


	/*$conexion = new mysqli($host_db, $user_db, $pass_db, $db_name);

	

	echo $id;


	$sql = "SELECT VALUE FROM $tbl_value WHERE OBJECT_ID = '$id'";

	$result = $conexion->query($sql);

	if(!$result){
		echo "true";
	}

	if ($result->num_rows > 0) {
		$row =  mysqli_fetch_assoc($result);
		if($row['VALUE'] == 0){
			$sql = "UPDATE $tbl_value
					SET VALUE = 1
					WHERE OBJECT_ID=$id";
		}else{
			$sql = "UPDATE $tbl_value
					SET VALUE = 0
					WHERE OBJECT_ID=$id";
		}
		$conexion->query($sql);
	}*/


	
	

?>