import getRCs from "../resultCenter/getRCs.js";
import getUsers from "../user/getUsers.js";
import addRelation from "./addRelation.js";

const url = "http://localhost:8080/addRelation/user-resultcenter";
const urlDelete = "http://localhost:8080/user";

const selectUser = document.getElementById("users");
selectUser.addEventListener("click", eventUser => getUsers(eventUser,"users"), {once: true});

const selectRC = document.getElementById("resultCenters");
selectRC.addEventListener("click", eventRC => getRCs(eventRC, "resultCenters"), {once: true});

const form = document.getElementById("form");
form.addEventListener("submit", eventAdd => addRelation(eventAdd, url, selectUser.value, selectRC.value));


// CONSULTAR

const selectRCConsult = document.getElementById("resultCentersConsult");
selectRCConsult.addEventListener("click", eventRCConsult => getRCs(eventRCConsult, "resultCentersConsult"), {once: true});

const button = document.getElementById("consult");
const tbody = document.getElementById("tbody");
const urlConsult = "http://localhost:8080/addRelation/user-rc";

async function getValues(eventConsult, codeRc){
    eventConsult.preventDefault();

    const response = await fetch(urlConsult,{
        method: "POST",
        headers:{
            "Content-type": "application/json",
            "Authorization": `Bearer ${localStorage.getItem("token")}`
        },
        body: codeRc
    });
    const data = await response.json();

    console.log(data);

    data.map(resp =>{
        const tr = document.createElement("tr");
        const codeRc = document.createElement("td");
        const registration = document.createElement("td");
        const userName = document.createElement("td");
        const editar = document.createElement("td");
        const img = document.createElement("img");

        codeRc.innerText = resp.resultCentersCodeRc;
        registration.innerText = resp.userRegistration;
        userName.innerText = resp.userName;
        img.src = "../../static/image/lixeira.png"
        img.style = "width: 50px; height: 50px;";
        img.classList.add("img-fluid");
        img.classList.add("img-thumbnail");
        img.onclick = function(){
            relationDelete(resp.resultCentersCodeRc, resp.userRegistration);
        };


        tr.appendChild(codeRc);
        tr.appendChild(registration);
        tr.appendChild(userName);
        editar.appendChild(img);
        tr.appendChild(editar);

        tbody.appendChild(tr);
    })
}
button.addEventListener("click", eventConsult => {
    while(tbody.childElementCount > 0){
        tbody.deleteRow(0);
    }
    getValues(eventConsult, selectRCConsult.value)
});

async function relationDelete(codeRc, registration){
    const response = await fetch(urlDelete, {
        method: "DELETE",
        headers: {
            "Content-type": "application/json",
            "Authorization": `Bearer ${localStorage.getItem("token")}`
        },
        body: JSON.stringify({
            registration: registration,
            codeRc: codeRc
        })
    });
    if(response.ok){
        window.alert(`Relacionamento foi excluido com sucesso!`);
    }else{
        window.alert(`Erro ao excluir: ${response.status}`);
    }
}