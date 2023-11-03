import getClient from "../timeApontament/getClients.js";
import getRCs from "../resultCenter/getRCs.js";
import addRelation from "./addRelation.js";

const selectClient = document.getElementById("clients");
const selectRC = document.getElementById("resultCenters");

selectClient.addEventListener("click", eventClient => getClient(eventClient), {once: true});
selectRC.addEventListener("click", eventRC => getRCs(eventRC), {once: true});



const form = document.getElementById("form");
const url = "http://localhost:8080/addRelation/client-resultcenter";
form.addEventListener("submit", eventAddRelation => {
    console.log(selectClient.value);
    console.log(selectRC.value);
    addRelation(eventAddRelation, url, selectClient.value, selectRC.value);

});