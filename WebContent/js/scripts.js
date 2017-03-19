function IsEmpty() {

	if (document.forms['Form1'].command.value === "") {
		document.getElementById('button01').style.display = 'none';
		document.getElementById('button02').style.display = 'none';
		return;
	}
	document.getElementById('button01').style.display = 'block';
	document.getElementById('button02').style.display = 'block';
}
