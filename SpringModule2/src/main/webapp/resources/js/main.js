/**
 * 
 */

function isNumber(id){
	var value=document.getElementById(id).value;
	if(isNaN(value)){
		alert("'"+value+"' is not a valid number. Please enter a valid number.");
		return false;
	}else{
		return true;
	}
}