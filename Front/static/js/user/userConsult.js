const url = "http://localhost:8080/user/consult";

const table = document.getElementById("tr");

async function getUsers(){

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
        const name = document.createElement("td");
        const jobrole = document.createElement("td");
        const email = document.createElement("td");
        const status = document.createElement("td");

        name.innerText = resp.name;
        jobrole.innerText = resp.jobrole;
        email.innerText = resp.email;
        status.innerText = resp.status;

        tr.appendChild(name);
        tr.appendChild(jobrole);
        tr.appendChild(email);
        tr.appendChild(status);
        
        table.appendChild(tr);
    })
}

getUsers();