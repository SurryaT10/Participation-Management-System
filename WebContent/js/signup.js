const username = document.getElementById('username')
const regnum = document.getElementById('regnum')
const email = document.getElementById("email");
const year = document.getElementById('year')
const form = document.getElementById('form')
const error_ele = document.getElementById('error')
const btn = document.querySelector('.button')
const password = document.querySelector("#password");

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

email.addEventListener('change', (e) => {
	if (e.target.value === "")
		setErrorFor(email, "Email id connot be blank");
	else
		setSuccessFor(email);
	
	ValidateEmail(e.target);
})

password.addEventListener('change', (e) => {
	if (e.target.value === "")
		setErrorFor(password, "Password connot be blank");
	else
		setSuccessFor(password);
	ValidatePassword(e.target);
})

function ValidateEmail(inputText)
{
	var mailformat = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@(skct|skcet).edu.in$/;
	if(inputText.value.match(mailformat))
		return true;
	else
	{
		setErrorFor(email, "Email id is not valid");
		email.focus();
		return false;
	}
}

function ValidatePassword(inputText) {
	var passformat = /^[A-Za-z0-9]{8,20}$/;
	if (inputText.value.match(passformat)) {
		setSuccessFor(inputText);
		return true;
	}
	else {
		setErrorFor(password, "Password should contain 1u, 1l, 1num and upto 8 to 20 characters");
		password.focus();
		return false;
	}
}

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