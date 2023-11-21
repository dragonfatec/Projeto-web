const url = "http://localhost:8080/user/consult";

const table = document.getElementById("tr");

async function getUsers(){

    const response = await fetch(url, 
        {
        headers: {
            'Authorization': 'Bearer ' + localStorage.getItem('token')
        }
    });

    const data = await response.json();

    data.map((resp) => {
        const tr = document.createElement("tr");
        const registration = document.createElement("td");
        const name = document.createElement("td");
        const jobrole = document.createElement("td");
        const email = document.createElement("td");
        const status = document.createElement("td");


        const editar = document.createElement("td");
        const img = document.createElement("img");
        
        registration.innerText = resp.registration;
        name.innerText = resp.name;
        jobrole.innerText = resp.jobrole;
        email.innerText = resp.email;
        status.innerText = resp.status;
        img.src = "../../static/image/lapisEditar.png"
        img.style = "width: 50px; height: 50px;";
        img.classList.add("img-fluid");
        img.classList.add("img-thumbnail");
        img.onclick = function(){
            getDataToEdit(resp.registration , resp.name, resp.jobrole, resp.email, resp.status);
            $('#modal').modal('show');
        };

        tr.appendChild(registration);
        tr.appendChild(name);
        tr.appendChild(jobrole);
        tr.appendChild(email);
        tr.appendChild(status);
        editar.appendChild(img);
        tr.appendChild(editar);
        
        table.appendChild(tr);
    })
}
getUsers();


// EDITAR USUARIO
const urlToEdit = "http://localhost:8080/user";
const form = document.getElementById("formulario");
const edit_registration = document.getElementById("registration");
const edit_name = document.getElementById("name");
const edit_jobrole = document.getElementById("jobrole");
const edit_email = document.getElementById("email");
const edit_status = document.getElementById("status");

function getDataToEdit(registration, name, jobrole, email, status){

    edit_registration.value = registration;
    edit_name.value = name;
    edit_email.value = email;
    
    while(edit_jobrole.childElementCount > 0){
        edit_jobrole.remove(0);
    }
    while(edit_status.childElementCount > 0){
        edit_status.remove(0);
    }

    if(jobrole == "ADMINISTRATOR"){
        const option = document.createElement("option");
        option.value = jobrole;
        option.innerText = jobrole;

        const option1 = document.createElement("option");
        option1.value = "EMPLOYEE";
        option1.innerText = "EMPLOYEE";

        const option2 = document.createElement("option");
        option2.value = "MANAGER";
        option2.innerText = "MANAGER";

        edit_jobrole.appendChild(option);
        edit_jobrole.appendChild(option1);
        edit_jobrole.appendChild(option2);
    }else if(jobrole == "MANAGER"){
        const option = document.createElement("option");
        option.value = jobrole;
        option.innerText = jobrole;

        const option1 = document.createElement("option");
        option1.value = "EMPLOYEE";
        option1.innerText =  "EMPLOYEE";

        const option2 = document.createElement("option");
        option2.value = "ADMINISTRATOR";
        option2.innerText = "ADMINISTRATOR";

        edit_jobrole.appendChild(option);
        edit_jobrole.appendChild(option1);
        edit_jobrole.appendChild(option2);
    }else{
        const option = document.createElement("option");
        option.value = jobrole;
        option.innerText = jobrole;

        const option1 = document.createElement("option");
        option1.value = "MANAGER";
        option1.innerText = "MANAGER";

        const option2 = document.createElement("option");
        option2.value = "ADMINISTRATOR";
        option2.innerText = "ADMINISTRATOR";

        edit_jobrole.appendChild(option);
        edit_jobrole.appendChild(option1);
        edit_jobrole.appendChild(option2);
    }

    if(status == "ACTIVE"){
        const option = document.createElement("option");
        option.value = status;
        option.innerText = status;

        const option1 = document.createElement("option");
        option1.value = "INACTIVE";
        option1.innerText = "INACTIVE";

        edit_status.appendChild(option);
        edit_status.appendChild(option1);
    }else{
        const option = document.createElement("option");
        option.value = status;
        option.innerText = status;

        const option1 = document.createElement("option");
        option1.value = "ACTIVE";
        option1.innerText = "ACTIVE";

        edit_status.appendChild(option);
        edit_status.appendChild(option1);
    }
    
}

async function toEdit(eventToEdit, registration, jobrole, status, name, email){
    eventToEdit.preventDefault();

    const response = await fetch(urlToEdit, {
        method: "PUT",
        headers:{
            "Content-type": "application/json",
            "Authorization": `Bearer ${localStorage.getItem('token')}`
        },
        body: JSON.stringify({
            registration: registration,
            jobrole: jobrole,
            status: status,
            name: name,
            email: email
        })
    })
    if(response.ok){
        window.alert(`Colaborador ${name}, foi editado com sucesso!`);
        window.location.href = "../../../templates/consult/consultUser.html";
    }
}
form.addEventListener("submit", eventToEdit => {
    console.log("chamou");
    toEdit(eventToEdit, edit_registration.value, edit_jobrole.value, edit_status.value, edit_name.value, edit_email.value);
});