const url = "http://localhost:8080/sendtime/consult";
const urlAdmin = "http://localhost:8080/rc/consult";
const urlById = "http://localhost:8080/rc/consult/by-id";
const urlExportExcel = "http://localhost:8080/sendtime/export";


const table = document.getElementById("tr");
const select = document.getElementById("select");
const button = document.getElementById("consult");
const buttonExport = document.getElementById("exportExcel");


async function getTime(eventGet){
    eventGet.preventDefault();
    console.log(localStorage.getItem("jobrole"))

    const response = await fetch(url, 
        {
        method: "POST",
        headers: {
            'Content-type': 'application/json',
            'Authorization': 'Bearer ' + localStorage.getItem('token')
        },
        body: JSON.stringify({
            codeRc: select.value,
            jobrole: localStorage.getItem("jobrole"),
            registration: localStorage.getItem("registration")
        })
    });
    
    const data = await response.json();
    console.log(data);
    data.map((resp) => {
        const tr = document.createElement("tr");
        const user = document.createElement("td");
        const startDate = document.createElement("td");
        const finishDate = document.createElement("td");
        const typeSend = document.createElement("td");
        const status = document.createElement("td");
        const approved = document.createElement("td");
        const justification = document.createElement("td");

        user.innerText = resp.user.name;

        var start = new Date(resp.startDate);
        startDate.innerText = start.toLocaleString('pt-BR', { timezone: 'UTC' });

        var finish = new Date(resp.finishDate);
        finishDate.innerText = finish.toLocaleString('pt-BR', { timezone: 'UTC' });

        typeSend.innerText = resp.typeSend;
        status.innerText = resp.status;
        approved.innerText = resp.approvedStatus;
        justification.innerText = resp.justification;

        tr.appendChild(user);
        tr.appendChild(startDate);
        tr.appendChild(finishDate);
        tr.appendChild(typeSend);
        tr.appendChild(status);
        tr.appendChild(approved);
        tr.appendChild(justification);

        table.appendChild(tr);
    })
}
button.addEventListener("click", eventGet => {
    while(table.childElementCount > 0){
        table.deleteRow(0);
    }
    getTime(eventGet);
});


//  METODO DE LISTAR AS HORAS DE ACORDO COM O CARGO

async function getResultCenter(eventoSelect){
    eventoSelect.preventDefault();

    var response = "";

    if(localStorage.getItem("jobrole") == "ADMINISTRATOR"){
        response = await fetch(urlAdmin, {
            headers:{
                "Authorization": `Bearer ${localStorage.getItem('token')}`
            }
        })    
    } else{
        response = await fetch(urlById, {
            method: "POST",
            headers:{
                "Content-type": "application/json",
                "Authorization": `Bearer ${localStorage.getItem('token')}`
            },
            body: JSON.stringify({
                registration: localStorage.getItem("registration")
            })
        })
    }

    const data = await response.json();

    console.log(data)
    data.map(resp => {
        const option = document.createElement("option");
        option.innerText = resp.rc;
        option.value = resp.codeRc;
        select.appendChild(option);
    });

}
select.addEventListener("click", eventoSelect => getResultCenter(eventoSelect), { once: true})

// METODO DE EXPORTAR

async function exportExcel(eventExport){
    eventExport.preventDefault();

    const response = await fetch(urlExportExcel, {
        method: "POST",
        headers: {
            'Content-type': 'application/json',
            'Authorization': 'Bearer ' + localStorage.getItem('token')
        },
        body: JSON.stringify({
            codeRc: select.value,
            jobrole: localStorage.getItem("jobrole"),
            registration: localStorage.getItem("registration")
        })
    })
    if(response.ok){
        window.alert("Arquivo exportado com sucesso!");
    }else{
        window.alert(`Erro ao exportar o arquivo: ${response.status}`);
    }
}
buttonExport.addEventListener("click", eventExport => exportExcel(eventExport));