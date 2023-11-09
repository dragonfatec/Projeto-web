const timeApontament = document.getElementById("timeApontament");
const register = document.getElementById("register");
const addRelation = document.getElementById("addRelation");
const consultUser = document.getElementById("consultUser");
const consultRC = document.getElementById("consultRC");
const consultCompany = document.getElementById("consultCompany");
const consultTimeApontament = document.getElementById("consultTimeApontament");
const approve = document.getElementById("approve");

const job = localStorage.getItem("jobrole");

function displayNone(){
    console.log(job);
    if(job == "ADMINISTRATOR"){
        timeApontament.style.display = "none";
        
    }if(job == "MANAGER"){
        register.style.display = "none";
        addRelation.style.display = "none";
        console.log("manager");
    }if(job == "EMPLOYEE"){
        register.style.display = "none";
        addRelation.style.display = "none";
        consultUser.style.display = "none";
        consultRC.style.display = "none";
        consultCompany.style.display = "none";
        approve.style.display = "none";
        console.log("employeer");
    }
}

displayNone();