const url = "http://localhost:8080/rc/consult";



export default async function getResultCenter(eventRc, selectId){
    eventRc.preventDefault();

    const selectRC = document.getElementById(selectId);

    const response = await fetch(url, 
        {
        headers: {
            'Authorization': 'Bearer ' + localStorage.getItem('token')
        }
    });
    
    const data = await response.json();

    data.map((resp) => {
        const rc = document.createElement("option");
        rc.innerText = resp.rc;
        rc.value = resp.codeRc;
        selectRC.appendChild(rc);
    })
}