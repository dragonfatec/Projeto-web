export default async function addRelation(eventAddRelation, url, idOne, idTwo){
    eventAddRelation.preventDefault();

    const response = await fetch(url,{
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            "Authorization": `Bearer ${localStorage.getItem("token")}`
        },
        body: JSON.stringify({
            idOne: idOne,
            idTwo: idTwo
        })
    })
}