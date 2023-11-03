const url = "http://localhost:8080/rc/consult";

const selectRC = document.getElementById("resultCenters");

export default async function getResultCenter(eventRc){
    eventRc.preventDefault();

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