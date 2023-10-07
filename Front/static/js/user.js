const url = "http://localhost:8080/user";

const select = document.getElementById("resultCenter");

async function getResultCenter(event){
    event.preventDefault();

    const response = await fetch(url);
    const data = await response.json();

    data.map((rc)=>{
        const option = document.createElement("option");

        option.innerText = rc.rc;
        option.value = rc.codeRc;

        select.appendChild(option);
    })

}

select.addEventListener("click", event => getResultCenter(event),{ once: true });



async function save(name, jobrole,resultCenter){
    const response = await fetch(url,{
        method: "POST",
        headers:{
            "Content-type": "application/json"
        },
        body: JSON.stringify({
            name:name,
            jobrole:jobrole,
            resultCenter:resultCenter
        })
    }).then(response => console.log(response)).catch(error => console.log(error));
}

const form = document.getElementById("form_user");

async function getAttributes(eventSave){
    eventSave.preventDefault();
    
    const name = document.getElementById("name").value;
    const jobrole = document.getElementById("jobrole").value;
    const resultCenter = document.getElementById("resultCenter").value;
    console.log(name, jobrole, resultCenter);

    save(name, jobrole, resultCenter);
    window.alert(name);
}

form.addEventListener("submit", eventSave => getAttributes(eventSave));