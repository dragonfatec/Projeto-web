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
    });
    
    // .then(data => {
    //     console.log(data);
        
    //     // if(data.status === 200){
    //     //     return window.location.href = "../../templates/home/home.html";
    //     // }else{
    //     //     window.alert("Email or Password are wrong !");
    //     //     throw new Error("Email or Password are wrong !")
    //     // }
    // }).catch(error => console.log(error));

    if(response.ok){
        const json = await response.json();
        const token = json.token;
        console.log(token);
        //localStorage.setItem('token', token);

        const tokenHeader = await fetch(url, 
            {
            method: "POST",
            headers: {
                'Authorization': 'Bearer ' + token
            }
        });



        return window.location.href = "../../templates/home/home.html";
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