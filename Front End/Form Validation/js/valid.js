function validation() {
	
	var fname = document.getElementById('Fname').value;
	var lname = document.getElementById('Lname').value;
	var address = document.getElementById('Address').value;
	var password = document.getElementById('Password').value;
	var cpassword = document.getElementById('Cpassword').value;
	var email = document.getElementById('Email').value;
	var contact = document.getElementById('Contact').value;

	// if ((fname == "") || (lname == "") || (address == "") || (password == "") || (cpassword == "") || (email == "") || (contact == "")) {
	// 	document.getElementById('FnameError').innerHTML = "* Required Field!!!";
	// 	document.getElementById('LnameError').innerHTML = "* Required Field!!!";
	// 	document.getElementById('AddressError').innerHTML = "* Required Field!!!";
	// 	document.getElementById('PasswordError').innerHTML = "* Required Field!!!";
	// 	document.getElementById('CpasswordError').innerHTML = "* Required Field!!!";
	// 	document.getElementById('EmailError').innerHTML = "* Required Field!!!";
	// 	document.getElementById('ContactError').innerHTML = "* Required Field!!!";
	// 	return false;
	// }
	if (fname == "") 
	{
		document.getElementById('FnameError').innerHTML = "* Required Field!!!";
		return false;
	}
	if (fname != "") 
	{
		document.getElementById('FnameError').innerHTML = "";
		return false;
	}
	if (lname == "") 
	{
		document.getElementById('LnameError').innerHTML = "* Required Field!!!";
		return false;
	}
	if (lname != "") 
	{
		document.getElementById('LnameError').innerHTML = "";
		return false;
	}
	if (address == "") 
	{
		document.getElementById('AddressError').innerHTML = "* Required Field!!!";
		return false;
	}
	if (address != "") 
	{
		document.getElementById('AddressError').innerHTML = "";
		return false;
	}
	if (password = "") 
	{
		document.getElementById('PasswordError').innerHTML = "* Required Field!!!";
		return false;
	}
	if (password != "") 
	{
		document.getElementById('PasswordError').innerHTML = "";
		return false;
	}
	if (cpassword == "") 
	{
		document.getElementById('CpasswordError').innerHTML = "* Required Field!!!";
		return false;
	}
	if (cpassword != "") 
	{
		document.getElementById('CpasswordError').innerHTML = "";
		return false;
	}
	if (email == "") 
	{
		document.getElementById('EmailError').innerHTML = "* Required Field!!!";
		return false;
	}
	if (email != "") 
	{
		document.getElementById('EmailError').innerHTML = "";
		return false;
	}
	if (contact == "") 
	{
		document.getElementById('ContactError').innerHTML = "* Required Field!!!";
		return false;
	}
	if (contact != "") 
	{
		document.getElementById('ContactError').innerHTML = "";
		return false;
	}
}

function FnameValidate() {
	var fname = document.getElementById('Fname').value;

	var v = fname.trim();

	var number = false;
	var specialcaseLetter = false;

	for (var i = 0; i < v.length; i++) 
    	{
      var charCode = v.charCodeAt(i);

      if(charCode > 47 && charCode < 58)
        number = true;

      if((charCode > 32 && charCode < 48) || (charCode > 57 && charCode < 65) || (charCode > 90 && charCode < 97) || (charCode > 122 && charCode <= 126) || charCode == 64)
        specialcaseLetter   = true;
	}

	
	if ((v.length <= 2) || (v.length > 20)) {
		document.getElementById('FnameError').innerHTML = "* Length should be 2 to 20 character !!!";
		return false;
	}
	if(v.split(' ').length > 1)
	{
		document.getElementById('FnameError').innerHTML="* Invalid : Space between name";
		return false;
	}
	if (number) {
		document.getElementById('FnameError').innerHTML="* Number Not Allowed..!!!";
		return false;
	}
	if (specialcaseLetter) {
		document.getElementById('FnameError').innerHTML="* Character input only..!!!";
		return false;
	}
	else
	{
		document.getElementById('FnameError').innerHTML = "";
		return false;
	}
}

function LnameValidate() {
	var name = document.getElementById('Lname').value;

	var v = name.trim();

	var number = false;
	var specialcaseLetter = false;

	for (var i = 0; i < v.length; i++) 
    	{
      var charCode = v.charCodeAt(i);

      if(charCode > 47 && charCode < 58)
        number = true;

      if((charCode > 32 && charCode < 48) || (charCode > 57 && charCode < 65) || (charCode > 90 && charCode < 97) || (charCode > 122 && charCode <= 126) || charCode == 64)
        specialcaseLetter   = true;
	}

	if (v == "") {
		document.getElementById('LnameError').innerHTML = "* Required Field !!!";
		// return false;
	}
	if ((v.length <= 2) || (v.length > 20)) {
		document.getElementById('LnameError').innerHTML = "* Length should be 2 to 20 character !!!";
		return false;
	}
	if(v.split(' ').length > 1)
	{
		document.getElementById('LnameError').innerHTML="* Invalid : Space between name";
		return false;
	}
	if (number) 
	{
		document.getElementById('LnameError').innerHTML="* Number Not Allowed..!!!";
		return false;
	}
	if (specialcaseLetter) 
	{
		document.getElementById('LnameError').innerHTML="* Character input only..!!!";
		return false;
	}
	else
	{
		document.getElementById('LnameError').innerHTML = "";
		return false;
	}
}

function AddValidate() {
	var name = document.getElementById('Address').value;

	var v = name.trim();

	if (v == "") {
		document.getElementById('AddressError').innerHTML = "* Required Field !!!";
	}
	else if ((v.length <= 20) ) {
		document.getElementById('AddressError').innerHTML = "* Length should be 20 to 200 character !!!";
		return false;
	}
	else
	{
		document.getElementById('AddressError').innerHTML = "";
		return false;
	}
	
}

function pwdValidate() {
	var name = document.getElementById('Password').value;

	var v = name.trim();

	// window.onload = function() {
	// 	const myInput = document.getElementById('Password');
	// 	myInput.onpaste = function(e) {
	// 		e.preventDefault();
	// 	}
	// }

	var capital = true;
	var small = true;
	var number = true;
	var specialcaseLetter = true;

    for (var i = 0; i < v.length; i++) 
    {
      var charCode = v.charCodeAt(i);

      if(charCode > 47 && charCode < 58)
        number = false;

      if(charCode > 64 && charCode < 91)
        capital = false;

      if(charCode > 96 && charCode < 123)
        small = false;

      if((charCode > 32 && charCode < 48) || (charCode > 57 && charCode < 65) || (charCode > 90 && charCode < 97) || (charCode > 122 && charCode <= 126) || charCode == 64)
        specialcaseLetter   = false;
	}
	if(v =="")
	{
		document.getElementById("PasswordError").innerHTML="* Required Field !!!";
		return false;
	}
	else if((v.length <8) || (v.length >= 13))
	{
		document.getElementById('PasswordError').innerHTML="**Please enter the password between 8 to 13";
		return false;
	}
	else if(capital){
		document.getElementById('PasswordError').innerHTML="**Please At least 1 capital ";
		return false;
	}
	else if(small){
		document.getElementById('PasswordError').innerHTML="**Please At least 1 smallcap";
		return false;
	}
	else if(number){
		document.getElementById('PasswordError').innerHTML="**Please At least 1 numerical";
		return false;
	}
	else if(specialcaseLetter){
		document.getElementById('PasswordError').innerHTML="**Please At least 1 specialcaseLetter";
		return false;
	}
	else
	{
		document.getElementById('PasswordError').innerHTML = "";
		return false;
	}
}

function cpwdValidate() {
	var name1 = document.getElementById('Password').value;
	var name2 = document.getElementById('Cpassword').value;

	var v1 = name1.trim();
	var v2 = name2.trim();

	if (v1 != v2) {
		document.getElementById('CpasswordError').innerHTML = "* Password doesn't Match...!!!";
	}
	else
	{
		document.getElementById('CpasswordError').innerHTML = "";
		return false;
	}
}

function emailValidate() {
	var name = document.getElementById('Email').value;

	var v = name.trim();

	var number = false;
	var specialcaseLetter = false;

	for (var i = 0; i < v.length; i++) 
    	{
      var charCode = v.charCodeAt(i);

      if(charCode > 47 && charCode < 58)
        number = true;
      
      if((charCode > 32 && charCode < 46) || (charCode > 57 && charCode < 64) || (charCode > 90 && charCode < 97) || (charCode > 122 && charCode <= 126) || charCode == 47)
        specialcaseLetter   = true;
	}
	
	if(v =="")
	{
		document.getElementById('EmailError').innerHTML="* Required Field !!!";
		return false;
	}
	var res = v.split('@');

	if(v.split('@').length != 2)
	{
		document.getElementById('EmailError').innerHTML="**Please enter the valid number of @..!!!";
		return false;
	}

	var part1=res[0];
	var part2=res[1];

	 if(part1.length < 3)
	{
		document.getElementById('EmailError').innerHTML="* Three character before the '@' required...!!!";
		return false;
	}
	 if(part1.split(' ').length>1)
	{
		document.getElementById('EmailError').innerHTML="* Invalid : Space before @";
		return false;
	}

	var dotsplt=part2.split(".");  //alert(“After @ :”+part2);

	 if(part2.split('.').length<2)
	{
		document.getElementById('EmailError').innerHTML="* '.' Missing..!!!";
		return false;
	}
	 if(dotsplt[0].length < 3 )
	{
		console.log('demo',v);
		document.getElementById('EmailError').innerHTML="* Three character before the '.' required...!!!";
		return false;
	}
	 if(dotsplt[0].split(' ').length>1)
	{
		document.getElementById('EmailError').innerHTML="* Invalid : Space before '.'...!!!!";
		return false;
	}
	 if(dotsplt[1].length<2 ||dotsplt[1].length>3)
	{
		document.getElementById('EmailError').innerHTML="* character aftr '.' must be in between 2 to 3 ...!!!";
		return false;
	}
	if(dotsplt[1].split('specialcaseLetter')>1)
	{
		document.getElementById('EmailError').innerHTML="* Number aftr '.' Not Allowed ...!!!";
		return false;
	}
	if (specialcaseLetter) 
	{
		document.getElementById('EmailError').innerHTML="* Special Character Not Allowed...!!!";
		return false;
	}
	if (true)
	{
		document.getElementById('EmailError').innerHTML="";
		return false;
	}
}

function conValidate() {

	var name = document.getElementById('Contact').value;

	var v = name.trim();

	if(v =="")
	{
		document.getElementById('ContactError').innerHTML="* Required Field !!!";
		return false;
	}
	else if(v.split(' ').length > 1)
	{
		document.getElementById('ContactError').innerHTML="* Invalid : Space between Number...!!!";
		return false;
	}
	else if ((v.length < 10) ) {
		document.getElementById('ContactError').innerHTML = "* Length must be 10 digits only....!!!";
		return false;
	}
	else if ((v.length > 10)) {
		document.getElementById('ContactError').innerHTML = "* Length should be 10 digits only....!!!";
		return false;
	}
	else if(isNaN(v))
	{
		document.getElementById('ContactError').innerHTML="**Please enter the number only";
		return false;
	}
	else
	{
		document.getElementById('ContactError').innerHTML="";
		return false;
	}
}

function fileValidate(file) {
	var FileSize = file.files[0].size / 1024 / 1024;

	var n = FileSize.toFixed(2);

	document.getElementById('FileError').innerHTML = "This file size is: " + n + "MB";
}