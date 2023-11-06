export default async function addRelation(eventAddRelation, url, idOne, idTwo){
    eventAddRelation.preventDefault();

    const response = await fetch(url,{
        method: "POST",
        headers: {
            "Content-type": "application/json",
            "Authorization": `Bearer ${localStorage.getItem("token")}`
        },
        body: JSON.stringify({
            idOne: idOne,
            idTwo: idTwo
        })
    }).then(resp => {
        if(resp.status == 200){
            window.alert("OK");
        }else{
            window.alert(`Erro: ${resp.status}`);
        }
    })
}