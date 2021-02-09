const username = document.getElementById('username')
const regnum = document.getElementById('regnum')
const year = document.getElementById('year')
const gender = document.getElementById('gender')
const batch = document.getElementById('batch')
const dept = document.getElementById('dept')
const section = document.getElementById('section')
const form = document.getElementById('form')
const error_ele = document.getElementById('error')
const btn = document.querySelector('.button')
const password = document.querySelector("#password");
const re_password = document.querySelector("#re_password");

username.addEventListener('change', (e) => {
	if (e.target.value === "")
		setErrorFor(username, "Username connot be blank");
	else
		setSuccessFor(username);
})

regnum.addEventListener('change', (e) => {
	if (e.target.value === "")
		setErrorFor(regnum, "Register number connot be blank");
	else
		setSuccessFor(regnum);
})

password.addEventListener('change', (e) => {
	console.log("sda");
	if (e.target.value === "")
		setErrorFor(password, "Password connot be blank");
	else
		setSuccessFor(password);
})

re_password.addEventListener('change', (e) => {
	if (e.target.value === "")
		setErrorFor(re_password, "Password connot be blank");
	else
		setSuccessFor(re_password);
})

function setErrorFor(input, message) {
	const form_comp = input.parentElement;
    const small = form_comp.querySelector('small');
    
	form_comp.className = 'form_comp error';
	small.innerText = message;
}

function setSuccessFor(input) {
	const form_comp = input.parentElement;
	form_comp.className = 'form_comp success';
}