import getClient from "../timeApontament/getClients.js";
import getRCs from "../resultCenter/getRCs.js";
import addRelation from "./addRelation.js";

const selectClient = document.getElementById("clients");
selectClient.addEventListener("click", eventClient => getClient(eventClient, "clients"), {once: true});

const selectRC = document.getElementById("resultCenters");
selectRC.addEventListener("click", eventRC => getRCs(eventRC, "resultCenters"), {once: true});

const form = document.getElementById("form");
const url = "http://localhost:8080/addRelation/client-resultcenter";
form.addEventListener("submit", eventAddRelation => {
    addRelation(eventAddRelation, url, selectClient.value, selectRC.value);
});

// CONSULTAR

const selectClientConsult = document.getElementById("selectClientConsult");
selectClientConsult.addEventListener("click", eventClient => getClient(eventClient, "selectClientConsult"), {once: true});

const button = document.getElementById("consult");
const tbody = document.getElementById("tbody");
const urlConsult = "http://localhost:8080/addRelation/client-rc";
const urlDelete = "http://localhost:8080/company";

async function getValues(eventConsult, cnpj){
    eventConsult.preventDefault();

    const response = await fetch(urlConsult,{
        method: "POST",
        headers:{
            "Content-type": "application/json",
            "Authorization": `Bearer ${localStorage.getItem("token")}`
        },
        body: cnpj
    });
    const data = await response.json();

    console.log(data);

    data.map(resp =>{
        const tr = document.createElement("tr");
        const cnpj = document.createElement("td");
        const codeRc = document.createElement("td");
        const rc = document.createElement("td");
        const editar = document.createElement("td");
        const img = document.createElement("img");

        cnpj.innerText = resp.cnpj;
        codeRc.innerText = resp.codeRc;
        rc.innerText = resp.rc;

        img.src = "../../static/image/lixeira.png"
        img.style = "width: 50px; height: 50px;";
        img.classList.add("img-fluid");
        img.classList.add("img-thumbnail");
        img.onclick = function(){
            relationDelete(resp.cnpj, resp.codeRc);
        };

        tr.appendChild(cnpj);
        tr.appendChild(codeRc);
        tr.appendChild(rc);
        editar.appendChild(img);
        tr.appendChild(editar);

        tbody.appendChild(tr);
    })
}
button.addEventListener("click", eventConsult => {
    while(tbody.childElementCount > 0){
        tbody.deleteRow(0);
    }
    getValues(eventConsult, selectClientConsult.value);
});

async function relationDelete(cnpj, codeRc){
    const response = await fetch(urlDelete, {
        method: "DELETE",
        headers: {
            "Content-type": "application/json",
            "Authorization": `Bearer ${localStorage.getItem("token")}`
        },
        body: JSON.stringify({
            cnpj: cnpj,
            codeRc: codeRc
        })
    });
    if(response.ok){
        window.alert(`Relacionamento foi excluido com sucesso!`);
    }else{
        window.alert(`Erro ao excluir: ${response.status}`);
    }
}