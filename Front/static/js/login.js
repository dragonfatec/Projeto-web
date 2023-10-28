const url = "http://localhost:8080/login";

const form = document.getElementById("form_login");

async function save(email, password){

    const response = await fetch(url, 
        {
        method: "POST",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            email:email,
            password: password
        })
    })

    if(response.ok){
        const json = await response.json();
        const token = json.token;
        const jobrole = json.jobrole;
       
        localStorage.setItem('token', token);
        localStorage.setItem('jobrole', jobrole);

        const tokenHeader = await fetch(url, 
            {
            method: "POST",
            headers: {
                'Authorization': 'Bearer ' + token
            }
        });

        return window.location.href = "../../templates/home/home.html";
    }else{
        window.alert("Error to login, verify all informations!")
    }
}

async function getAttributes(eventLogin){
    eventLogin.preventDefault();

    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    console.log(email, password);
    
    save(email, password).catch(error => console.log(error));
}

form.addEventListener("submit", eventLogin => getAttributes(eventLogin));