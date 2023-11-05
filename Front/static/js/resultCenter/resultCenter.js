const url = "http://localhost:8080/rc";

async function save(codeRc, rc, acronym){
   const response = await fetch(url,{
       method: "POST",
       headers:{
           "Content-type": "application/json",
           "Authorization": `Bearer ` + localStorage.getItem('token')
       },
       body: JSON.stringify({
            codeRc: codeRc,
            rc: rc,
            acronym: acronym
       })
   }).then(resp => {
    console.log(resp);
    if(resp.status == 200){
        $('#modal').modal('show');
    }else{
        window.alert(`Error to save ${resp.status}`);
    }})
}

const form = document.getElementById("form_rc");

async function getAttributes(evento){
   evento.preventDefault();

   const codeRc = document.getElementById("codeRc").value;
   const rc = document.getElementById("rc").value;
   const acronym = document.getElementById("acronym").value;
   
   console.log(codeRc, rc, acronym);
   await save(codeRc, rc, acronym);
}

form.addEventListener("submit", evento => getAttributes(evento));