const url = "http://localhost:8080/rc";

async function save(codeRc, rc, acronym){
   const response = await fetch(url,{
       method: "POST",
       headers:{
           "Content-type": "application/json"
       },
       body: JSON.stringify({
            codeRc: codeRc,
            rc: rc,
            acronym: acronym
       })
   }).then(resposta => console.log(resposta)).catch(error => console.log(error));
}

const form = document.getElementById("form_rc");

async function getAttributes(evento){
   evento.preventDefault();

   const codeRc = document.getElementById("codeRc").value;
   const rc = document.getElementById("rc").value;
   const acronym = document.getElementById("acronym").value;
   
   console.log(codeRc, rc, acronym);
   await save(codeRc, rc, acronym);
   
   window.alert(codeRc);
}
form.addEventListener("submit", evento => getAttributes(evento));