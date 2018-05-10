var lastIdSubmenu = "";
var timer;


function initHeader(title){
    if (document.getElementById('text_Header_title')) {
        initTime();

        if (!title) {
            title = ""
        }
        setDataById('text_Header_title', title);
    } 
}

function initTime(option){
	actDateTime(option);
	setInterval('actDateTime(' + option + ')', 1000);
}

function setDataById(id, value) {
	document.getElementById(id).firstChild.data = value;
}

/**
 * Function to set date and time
 * @param {*} option 
 */
function actDateTime(option) {
	var opt = option;
    var now = new Date();
    var day = now.getDate();
    var dayDisp = ((day < 10) ? "0" + day : day);
    var month = now.getMonth() + 1;
    var year = now.getFullYear();
    var monthDisp = ((month < 10) ? "0" + month : month);

    var weekday = now.getDay();
    var aryWeekday = new Array("Domingo", "Lunes", "Martes", "Miercoles",
                    "Jueves", "Viernes", "Sabado");

    var aryMonth = new Array('Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Sept.', 'Octubre', 'Noviembre', 'Diciembre');
    var hour = now.getHours();
    var minute = now.getMinutes();
    var second = now.getSeconds();
    var hourDisp = ((hour < 10) ? "0" + hour : hour);
    var minuteDisp = ((minute < 10) ? "0" + minute : minute);
    var secondDisp = ((second < 10) ? "0" + second : second);

    var dateVal = aryWeekday[weekday] + ', ' + dayDisp + '.' + monthDisp + '.'
                    + year;
    var timeVal = hourDisp + ':' + minuteDisp + ':' + secondDisp;

    if(opt == 1){
    	//console.log('day+month 1: ' + dayDisp + ', ' + aryMonth[month - 1] + ', ' + timeVal);
    	setEleData("text_Date_day", dayDisp);
    	setEleData("text_Date_month", aryMonth[month - 1]);
    	setEleData("text_Time", timeVal);
    }else{
    	//console.log('day+month 0: ' + dateVal + ', ' + timeVal);
    	setEleData("text_Date", dateVal);
    	setEleData("text_Time", timeVal);	
    }

    function setEleData(id, value) {
    document.getElementById(id).firstChild.data = value;
}

}
