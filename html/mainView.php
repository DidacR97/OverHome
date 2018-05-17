<html>

	<link rel="stylesheet" type="text/css" href="../styles/estilo.css">
	<header>
		<img src="../images/overtakenOH_logo.svg" id="imgHeader"/>
		<div id="pageTitle_name">
			<h1 id="title_Name">Bed 1</h1>
		</div>
		<div id="pageTitle_hour">
			<h1 id="text_Time">00:00:00</h1>
			<script type="text/javascript">
				setInterval(function(){ 
				   	momentoActual = new Date(); 
				   	hora = momentoActual.getHours() 
				   	minuto = momentoActual.getMinutes(); 
				   	segundo = momentoActual.getSeconds(); 

				   	horaImprimible = hora + ":" + minuto + ":" + segundo; 
				   	console.log(horaImprimible);

				   	document.getElementById("text_Time").textContent = horaImprimible;},1000);
				
		</script>
		</div>
	</header>
	<body>
		<div class="sidenav_left">
		  <a href="#">About</a>
		  <a href="#">Services</a>
		  <a href="#">Clients</a>
		  <a href="#">Contact</a>
		</div>

		<div class="main_svg">
			
			<img src="../svgsrc/OverHome_Bed1.svg" id="imgs" class="imagen"/>

			<script>

				setInterval(function() {
					document.getElementById("imgs").src = "../svgsrc/OverHome_Bed1.svg?time=" + new Date().getTime();
				}, 1000);

	  		</script>
		</div>

		<!--<nav class="sidenav_right">
			<a href="#">About</a>
			<a href="#">Services</a>
			<a href="#">Clients</a>
			<a href="#">Contact</a>
		</nav>-->
	</body>
</html>