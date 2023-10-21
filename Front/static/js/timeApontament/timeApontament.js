const url = "http://localhost:8080/sendtime";

const selectUser = document.getElementById("idUser");
const selectRC =document.getElementById("codeRc");


async function getObjects(eventUser){
    eventUser.preventDefault();

    const response = await fetch(url);
    const data = await response.json();

    data.user.map((obj) =>{
        const optionUser = document.createElement("option");

        optionUser.innerText = obj.name
        optionUser.value = obj.id

        selectUser.appendChild(optionUser);
    });

    data.rcs.map((obj) =>{
       
        const optionRC = document.createElement("option");
        optionRC.innerText = obj.rc;
        optionRC.value = obj.codeRc;

        selectRC.appendChild(optionRC);
    });
}

selectUser.addEventListener("click", eventUser => getObjects(eventUser), { once: true });

const form = document.getElementById("form_time");

async function save(idUser, startDate, finishDate, typeSend, codeRc){
    const response = await fetch(url, {
        method: "POST",
        headers: {
            "Content-type": "application/json"
        },
        body: JSON.stringify({
            idUser: idUser,
            startDate: startDate,
            finishDate: finishDate,
            typeSend: typeSend,
            codeRc: codeRc
        })
    }).then(resp => console.log(resp)).catch(error => console.log(error))
    $('#modal').modal('show');
};

async function getForm(eventSave){
    eventSave.preventDefault();

    const idUser = document.getElementById("idUser").value;
    const startDate = document.getElementById("startDate").value;
    const finishDate = document.getElementById("finishDate").value;
    const typeSend = document.getElementById("typeSend").value;
    const codeRc = document.getElementById("codeRc").value;

    await save(idUser, startDate,finishDate,typeSend,codeRc);
    console.log(idUser, startDate,finishDate,typeSend,codeRc,);
}

form.addEventListener("submit", eventSave => getForm(eventSave));