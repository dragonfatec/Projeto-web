const url = "http://localhost:8080/client/consult";

const table = document.getElementById("tr");

async function getCompanys(){
    const response = await fetch(url);
    const data = await response.json();

    console.log(data);

    data.map((resp) => {
        const nameCompany = document.createElement("td");
        const razaoSocial = document.createElement("td");
        const cnpj = document.createElement("td");
        const status = document.createElement("td");

        nameCompany.innerText = resp.nameCompany;
        razaoSocial.innerText = resp.razaoSocial;
        cnpj.innerText = resp.cnpj;
        status.innerText = resp.status;

        table.appendChild(nameCompany);
        table.appendChild(razaoSocial);
        table.appendChild(cnpj);
        table.appendChild(status);
    })
}

getCompanys();