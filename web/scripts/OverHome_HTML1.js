function ActualizarHora(){
	var fecha = new Date();
	var segundos = fecha.getSeconds();
	var minutos = fecha.getMinutes();
	var horas = fecha.getHours();

	var timer.textContent = document.getElementById("text_Time");

	timer.textContent = horas+" "+minutos+" "+segundos;
	console.log("kiadjbf");


}

setInterval(ActualizarHora,1000);