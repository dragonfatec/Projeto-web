const url = "http://localhost:8080/client";

async function save(cnpj, razaoSocial, nameCompany){
   const response = await fetch(url,{
       method: "POST",
       headers:{
           "Content-type": "application/json"
       },
       body: JSON.stringify({
           cnpj: cnpj,
           razaoSocial: razaoSocial,
           nameCompany: nameCompany
       })
   }).then(resposta => console.log(resposta)).catch(error => console.log(error));
   console.log(response);
}

const form = document.getElementById("form_client");

async function getAttributes(evento){
   evento.preventDefault();

   const cnpj = document.getElementById("cnpj").value;
   const razaoSocial = document.getElementById("razaoSocial").value;
   const nameCompany = document.getElementById("nameCompany").value;
   
   console.log(cnpj, razaoSocial, nameCompany);
   await save(cnpj, razaoSocial, nameCompany);
   
   window.alert(cnpj);
}
form.addEventListener("submit", evento => getAttributes(evento));