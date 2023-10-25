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
        const razaoSocial = document.createElement("td");
        const cnpj = document.createElement("td");
        const status = document.createElement("td");

        nameCompany.innerText = resp.nameCompany;
        razaoSocial.innerText = resp.razaoSocial;
        cnpj.innerText = resp.cnpj;
        status.innerText = resp.status;

        tr.appendChild(nameCompany);
        tr.appendChild(razaoSocial);
        tr.appendChild(cnpj);
        tr.appendChild(status);
        
        table.appendChild(tr);
    })
}

getCompanys();