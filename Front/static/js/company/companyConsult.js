const url = "http://localhost:8080/company/consult";

const table = document.getElementById("tr");

async function getCompanys(){
    
    const response = await fetch(url, 
        {
        headers: {
            'Authorization': 'Bearer ' + localStorage.getItem('token')
        }
    });
    
    const data = await response.json();

    console.log(data);

    data.map((resp) => {
        const tr = document.createElement("tr");
        const nameCompany = document.createElement("td");
        const officialName = document.createElement("td");
        const cnpj = document.createElement("td");
        const status = document.createElement("td");
        const editar = document.createElement("td");
        const img = document.createElement("img");

        nameCompany.innerText = resp.nameCompany;
        officialName.innerText = resp.officialName;
        cnpj.innerText = resp.cnpj;
        status.innerText = resp.status;
        img.src = "../../static/image/lapisEditar.png"
        img.style = "width: 50px; height: 50px;";
        img.classList.add("img-fluid");
        img.classList.add("img-thumbnail");
        img.onclick = function(){
            getDataToEdit(resp.cnpj, resp.officialName, resp.nameCompany, resp.status);
            $('#modal').modal('show');
        };

        tr.appendChild(nameCompany);
        tr.appendChild(officialName);
        tr.appendChild(cnpj);
        tr.appendChild(status);
        editar.appendChild(img);
        tr.appendChild(editar);
        
        table.appendChild(tr);
    })
}
getCompanys();


// EDITAR CLIENTE
const urlToEdit = "http://localhost:8080/company";
const form = document.getElementById("formulario");
const edit_cnpj = document.getElementById("cnpj");
const edit_officialName = document.getElementById("officialName");
const edit_nameCompany = document.getElementById("nameCompany");
const edit_status = document.getElementById("status");

function getDataToEdit(cnpj, officialName, nameCompany, status){
    edit_cnpj.value = cnpj;
    edit_officialName.value = officialName;
    edit_nameCompany.value = nameCompany;

    while(edit_status.childElementCount > 0){
        edit_status.remove(0);
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

async function toEdit(eventToEdit, cnpj, officialName, nameCompany, status){
    eventToEdit.preventDefault();

    const response = await fetch(urlToEdit, {
        method: "PUT",
        headers:{
            "Content-type": "application/json",
            "Authorization": `Bearer ${localStorage.getItem('token')}`
        },
        body: JSON.stringify({
            cnpj: cnpj, 
            officialName: officialName, 
            nameCompany: nameCompany, 
            status: status 
        })
    })
    if(response.ok){
        window.alert(`Cliente ${officialName}, foi editado com sucesso!`);
        window.location.href = "../../../templates/consult/consultCompany.html";
    }
}
form.addEventListener("submit", eventToEdit => {
    
    toEdit(eventToEdit, edit_cnpj.value, edit_officialName.value, edit_nameCompany.value, edit_status.value);
});