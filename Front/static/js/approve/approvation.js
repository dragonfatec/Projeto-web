const urlApproved = "http://localhost:8080/sendtime/approved/admin";
const urlGetSendTime = "http://localhost:8080/sendtime/consult";
const urlGetRC = "http://localhost:8080/rc/consult/by-id";

const selectRC = document.getElementById("selectRC");
const buttonConsult = document.getElementById("consult");
const tbody = document.getElementById("tr");
const buttonApprove = document.getElementById("aprovar");
const buttonReprove = document.getElementById("reprove");
const justifyText = document.getElementById("justifyText");
const buttonJustify = document.getElementById("justify");


// SALVA A APROVACAO OU REPROVACAO
async function approvation(eventSave, id, justification){
    eventSave.preventDefault();
  
    const response = await fetch(urlApproved, {
        method: "POST",
        headers: {
            "Content-type": "application/json",
            "Authorization": `Bearer ${localStorage.getItem("token")}`
        },
        body: JSON.stringify({
            id: id,
            approvedStatus: "WAITING_FOR_APPROVAL",
            justification: justification
        })
    });
    if(response.ok){
        window.location.href = "../../../templates/approve/approve.html";
    }
}
// ABRE O MODAL E PEGA OS DADOS PARA APROVAR OU REPROVAR
function getContent(action){
    
    var checkboxesSelected = [];

    var identify = "";
    var justify = "";
    var checkboxes = document.querySelectorAll(".check_sendtime");

    checkboxes.forEach(function(check){
        
        if(check.checked){

            checkboxesSelected.push(check.parentElement.parentElement);
            var row = check.parentNode.parentNode;
            identify = row.cells[0].textContent;
            $('#modal').modal('show');

            if(action == "APPROVE"){
                buttonJustify.addEventListener("click", eventSave => {

                    justify = justifyText.value;

                    if(justify == ""){
                        justify="-";
                    }
                    
                    approvation(eventSave, identify, justify);
                    window.alert("Enviado com sucesso!");
                }); 
            }else{
                buttonJustify.addEventListener("click", eventSave => {
                    justify = justifyText.value;
                    if(justify == "" || justify == "-" || justify == null){
                        window.alert("Informe a justificativa de sua reprovação!");
                    }else{
                        approvation(eventSave, identify, justify);
                        window.alert("Enviado com sucesso!");
                    }
                }); 
            
                
            }
        }
    });
}
buttonApprove.addEventListener("click", () => getContent("APPROVE"));
buttonReprove.addEventListener("click", () => getContent("REPROVE"));
// POPULA A TABELA
async function getSendTime(eventGetTime, codeRc){
    eventGetTime.preventDefault();

    // DELETA AS LINHAS CASO A TABELA JÁ TENHA CONTEÚDO
    var rows = tbody.rows.length;
    if(rows > 0){
        var checkboxes = document.querySelectorAll(".check_sendtime");
        checkboxes.forEach(function(rows){
            tbody.deleteRow(rows.rowIndex);
        })
    }

    const response = await fetch(urlGetSendTime, {
        method: "POST",
        headers: {
            "Content-type": "application/json",
            "Authorization": `Bearer ${localStorage.getItem("token")}`
        },
        body: JSON.stringify({
            codeRc: codeRc,
            jobrole: localStorage.getItem("jobrole"),
            registration: localStorage.getItem("registration")
        })
    })

    // POPULA A TABELA CASO O RESPONSE FOR OK
    if(response.ok){
        const data = await response.json();
        data.map(e => {
            const tr = document.createElement("tr");
            const id = document.createElement("td");
            const user = document.createElement("td");
            const startDate = document.createElement("td");
            const finishDate = document.createElement("td");
            const typeSend = document.createElement("td");
            const status = document.createElement("td");

            const check = document.createElement("td");
            const input = document.createElement("input");
            input.type = "checkbox";
            input.classList.add("check_sendtime");
            check.appendChild(input);

            id.innerText = e.id;
            user.innerText = e.user.name;

            var start = new Date(e.startDate);
            startDate.innerText = start.toLocaleString('pt-BR', { timezone: 'UTC' });

            var finish = new Date(e.finishDate);
            finishDate.innerText = finish.toLocaleString('pt-BR', { timezone: 'UTC' });

            typeSend.innerText = e.typeSend;

            var statusTraduzido = "";
            if(e.approvedStatus == "WAITING_FOR_APPROVAL"){
                statusTraduzido = "Aguardando Aprovação";
            }else if(e.approvedStatus == "DENIED_ADMINISTRADOR"){
                statusTraduzido = "Reprovado pelo Admin";
            }else if(e.approvedStatus == "APPROVED_ADMINISTRADOR"){
                statusTraduzido = "Aprovado pelo Admin";
            }else if(e.approvedStatus == "DENIED_MANAGER"){
                statusTraduzido = "Reprovado pelo Gerente";
            }else if(e.approvedStatus == "APPROVED_MANAGER"){
                statusTraduzido = "Aprovado pelo Gerente";
            }

            status.innerText = statusTraduzido;

            tr.appendChild(id);
            tr.appendChild(user);
            tr.appendChild(startDate);
            tr.appendChild(finishDate);
            tr.appendChild(typeSend);
            tr.appendChild(status);
            tr.appendChild(check);

            tbody.appendChild(tr);
        })
    }
}
buttonConsult.addEventListener("click", eventGetTime => getSendTime(eventGetTime, selectRC.value));

// POPULA O SELECT
async function getRC(){
    try{
    
        const response = await fetch(urlGetRC, {
            method: "POST",
            headers: {
                "Content-type": "application/json",
                "Authorization": `Bearer ${localStorage.getItem("token")}`
            },
            body: JSON.stringify({
                registration: localStorage.getItem("registration")
            })
        });

        if(!response.ok){
            throw new Error(`Error in request: ${response.status}`);
        }

        const data = await response.json();

        data.map(resp => {
            const option = document.createElement("option");
            option.innerText = resp.rc;
            option.value = resp.codeRc;
            selectRC.appendChild(option);
        })
    }catch(error){
        console.log("Error to get data: ", error);
    }
}
getRC();