const urlRC = "http://localhost:8080/sendtime/getRCByClients";

export default async function getRCByClient(eventRc, cnpj){
    eventRc.preventDefault();

    const response = await fetch(urlRC,{
        method: "POST",
        headers: {
            "Authorization": `Bearer ${localStorage.getItem("token")}`
        },
        body: cnpj
    })
}