const url = "http://localhost:8080/user/consult";

export default async function getUser(event,selectId){
    event.preventDefault();
    const selectUser = document.getElementById(selectId);

    const resp = await fetch(url, {
        headers: {
            "Authorization": `Bearer ${localStorage.getItem("token")}`
        }
    })

    const data = await resp.json();
    data.map((r) => {
        const option = document.createElement("option");
        option.innerText = r.name;
        option.value = r.registration;
        selectUser.appendChild(option);
    })
}