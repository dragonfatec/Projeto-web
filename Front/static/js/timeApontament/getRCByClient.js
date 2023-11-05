const urlRC = "http://localhost:8080/sendtime/getRCByClients";

export default async function getRCByClient(eventRc, cnpj, selectId){
    eventRc.preventDefault();

    const select = document.getElementById(selectId);

    const response = await fetch(urlRC,{
        method: "POST",
        headers: {
            "Content-type": "application/json",
            "Authorization": `Bearer ${localStorage.getItem("token")}`
        },
        body: cnpj
    })

    if(response.ok){
        const data = await response.json();
        console.log(data)
        data.map((resp) => {
            const option = document.createElement("option");
            option.innerText = resp.rc;
            option.value = resp.codeRc;

            select.appendChild(option);
        })
    }
    
}