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

        codeRc.innerText = resp.codeRc;
        rc.innerText = resp.rc;
        acronym.innerText = resp.acronym;
        status.innerText = resp.status;

        tr.appendChild(codeRc);
        tr.appendChild(rc);
        tr.appendChild(acronym);
        tr.appendChild(status);

        table.appendChild(tr);
    })
}

getResultCenter();