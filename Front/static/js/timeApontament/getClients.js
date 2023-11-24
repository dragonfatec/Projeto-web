const url = "http://localhost:8080/sendtime/getClients";

export default async function getClient(eventClient, idSelect){
    eventClient.preventDefault();

    const selectClient = document.getElementById(idSelect);

    const response = await fetch(url,{
        headers: {
            "Authorization" : `Bearer ${localStorage.getItem("token")}`
        }
    });
    const data = await response.json();

    data.map((obj) =>{
       
        const optionRC = document.createElement("option");
        optionRC.innerText = obj.officialName;
        optionRC.value = obj.cnpj;

        selectClient.appendChild(optionRC);
    });
}