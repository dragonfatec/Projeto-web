const url = "http://localhost:8080/sendtime/getClients";

const selectClient = document.getElementById("clients");

export default async function getClient(eventClient){
    eventClient.preventDefault();

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