const url = "http://localhost:8080/user";


async function save(name, email, password, jobrole){
    const response = await fetch(url,{
        method: "POST",
        headers:{
            "Content-type": "application/json",
            "Authorization": `Bearer ${localStorage.getItem('token')}`
        },
        body: JSON.stringify({
            name: name,
            email: email,
            password: password,
            jobrole: jobrole
        })
    }).then(resp => {
        console.log(resp)
        if(resp.status == 200){
            $('#modal').modal('show');
        }else{
            window.alert(`Error to salve: ${resp.status}`);
        }
    })
}

const form = document.getElementById("form_user");

async function getAttributes(eventSave){
    eventSave.preventDefault();
    
    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;
    const jobrole = document.getElementById("jobrole").value;
    
    save(name, email, password, jobrole);
}

form.addEventListener("submit", eventSave => getAttributes(eventSave));