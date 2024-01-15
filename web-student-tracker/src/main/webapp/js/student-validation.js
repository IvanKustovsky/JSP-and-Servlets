function validateForm() {

    // error fields
    let theErrorFields = [];

    // student form
    let studentForm = document.forms["studentForm"];

    // check first name
    let firstName = studentForm["firstName"].value.trim();;
    if (firstName === "") {
        theErrorFields.push("First name");
    }

    // check last name
    let lastName = studentForm["lastName"].value.trim();;
    if (lastName === "") {
        theErrorFields.push("Last name");
    }

    // check email
    let email = studentForm["email"].value.trim();;
    if (email === "") {
        theErrorFields.push("Email");
    }

    if (theErrorFields.length > 0) {
        alert("Form validation failed. Please add data for following fields: " + theErrorFields);
        return false;
    }
}