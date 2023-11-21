const url = "http://localhost:8080/rc/consult";

const table = document.getElementById("tr");

async function getResultCenter(){

    const response = await fetch(url, 
        {
        headers: {
            'Authorization': 'Bearer ' + localStorage.getItem('token')
        }
    });
    
    const data = await response.json();

    data.map((resp) => {
        const tr = document.createElement("tr")
        const codeRc = document.createElement("td");
        const rc = document.createElement("td");
        const acronym = document.createElement("td");
        const status = document.createElement("td");
        const editar = document.createElement("td");
        const img = document.createElement("img");

        codeRc.innerText = resp.codeRc;
        rc.innerText = resp.rc;
        acronym.innerText = resp.acronym;
        status.innerText = resp.status;
        img.src = "../../static/image/lapisEditar.png"
        img.style = "width: 50px; height: 50px;";
        img.classList.add("img-fluid");
        img.classList.add("img-thumbnail");
        img.onclick = function(){
            getDataToEdit(resp.codeRc, resp.rc, resp.acronym, resp.status);
            $('#modal').modal('show');
        };

        tr.appendChild(codeRc);
        tr.appendChild(rc);
        tr.appendChild(acronym);
        tr.appendChild(status);
        editar.appendChild(img);
        tr.appendChild(editar);

        table.appendChild(tr);
    })
}
getResultCenter();


// EDITAR CR
const urlToEdit = "http://localhost:8080/rc";
const form = document.getElementById("formulario");
const edit_codeRc = document.getElementById("codeRc");
const edit_rc = document.getElementById("rc");
const edit_acronym = document.getElementById("acronym");
const edit_status = document.getElementById("status");

function getDataToEdit(codeRc , rc, acronym, status){
    
    edit_codeRc.value = codeRc;
    edit_rc.value = rc;
    edit_acronym.value = acronym;

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

async function toEdit(eventToEdit, codeRc , rc, acronym, status){
    eventToEdit.preventDefault();

    const response = await fetch(urlToEdit,{
        method: "PUT",
        headers: {
            "Content-type": "application/json",
            "Authorization": `Bearer ${localStorage.getItem('token')}`
        },
        body: JSON.stringify({
            codeRc: codeRc,
            rc: rc, 
            acronym: acronym,
            status: status
        })
    })
    if(response.ok){
        window.alert(`O Centro de Resultado ${rc}, foi editado com sucesso!`);
        window.location.href = "../../../templates/consult/consultResultCenter.html";
    }
}
form.addEventListener("submit", eventToEdit => {
    toEdit(eventToEdit, edit_codeRc.value, edit_rc.value, edit_acronym.value, edit_status.value);
});