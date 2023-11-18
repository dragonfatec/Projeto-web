const url = "http://localhost:8080/company";

const form = document.getElementById("form_client");

async function save(cnpj, razaoSocial, nameCompany){
    const response = await fetch(url,{
        method: "POST",
        headers:{
            "Content-type": "application/json",
            "Authorization": `Bearer ` + localStorage.getItem('token')
        },
        body: JSON.stringify({
            cnpj: cnpj,
            razaoSocial: razaoSocial,
            nameCompany: nameCompany
        })
    }).then(resp => {
        if(resp.status == 200){
            $('#modal').modal('show');
        }else{
            window.alert(`Error to save: ${resp.status}`)
        }
    })
    .catch(error => console.log(error));
    
}

async function getAttributes(eventSave){
    eventSave.preventDefault();
    
    const cnpj = document.getElementById("cnpj").value;
    const razaoSocial = document.getElementById("razaoSocial").value;
    const nameCompany = document.getElementById("nameCompany").value;

    save(cnpj, razaoSocial, nameCompany);
}

form.addEventListener("submit", eventSave => getAttributes(eventSave));