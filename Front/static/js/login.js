const url = "http://localhost:8080/login";

const form = document.getElementById("form_login");

async function save(email, password){
    const response = await fetch(url, 
        {
        method: "POST",
        headers: {
            "Content-type": "application/json",
            "Access-Control-Allow-Origin": "*"
        },
        body: JSON.stringify({
            email:email,
            password: password
        })
    }).then(res => {
        if(res.status === 200){
            return window.location.href = "../../templates/home/home.html";
        }else{
            window.alert("Email or Password are wrong !");
            throw new Error("Email or Password are wrong !")
        }
    }).catch(error => console.log(error));
}

async function getAttributes(eventLogin){
    eventLogin.preventDefault();

    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    console.log(email, password);
    
    save(email, password).catch(error => console.log(error));
    //
}

form.addEventListener("submit", eventLogin => getAttributes(eventLogin));