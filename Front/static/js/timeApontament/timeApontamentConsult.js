const url = "http://localhost:8080/sendtime/consult";

const table = document.getElementById("tr");

async function getTime(){
    const response = await fetch(url);
    const data = await response.json();

    console.log(data);

    data.map((resp) => {
        const user = document.createElement("td");
        const startDate = document.createElement("td");
        const finishDate = document.createElement("td");
        const typeSend = document.createElement("td");

        user.innerText = resp.user.name;
        startDate.innerText = resp.startDate;
        finishDate.innerText = resp.finishDate;
        typeSend.innerText = resp.typeSend;

        table.appendChild(user);
        table.appendChild(startDate);
        table.appendChild(finishDate);
        table.appendChild(typeSend);
    })
}

getTime();