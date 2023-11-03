const url = "http://localhost:8080/company/consult";

const table = document.getElementById("tr");

async function getCompanys(){
    
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
        const nameCompany = document.createElement("td");
        const officialName = document.createElement("td");
        const cnpj = document.createElement("td");
        const status = document.createElement("td");

        nameCompany.innerText = resp.nameCompany;
        officialName.innerText = resp.officialName;
        cnpj.innerText = resp.cnpj;
        status.innerText = resp.status;

        tr.appendChild(nameCompany);
        tr.appendChild(officialName);
        tr.appendChild(cnpj);
        tr.appendChild(status);
        
        table.appendChild(tr);
    })
}

getCompanys();