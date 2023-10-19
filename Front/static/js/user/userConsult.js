const url = "http://localhost:8080/user/consult";

const table = document.getElementById("tr");

async function getUsers(){
    const response = await fetch(url);
    const data = await response.json();

    data.map((resp) => {
        const name = document.createElement("td");
        const jobrole = document.createElement("td");
        const email = document.createElement("td");
        const status = document.createElement("td");

        name.innerText = resp.name;
        jobrole.innerText = resp.jobrole;
        email.innerText = resp.email;
        status.innerText = resp.status;

        table.appendChild(name);
        table.appendChild(jobrole);
        table.appendChild(email);
        table.appendChild(status);

    })
}

getUsers();