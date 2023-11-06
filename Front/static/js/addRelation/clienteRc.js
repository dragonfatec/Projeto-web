import getClient from "../timeApontament/getClients.js";
import getRCs from "../resultCenter/getRCs.js";
import addRelation from "./addRelation.js";

const selectClient = document.getElementById("clients");
selectClient.addEventListener("click", eventClient => getClient(eventClient), {once: true});

const selectRC = document.getElementById("resultCenters");
selectRC.addEventListener("click", eventRC => getRCs(eventRC, "resultCenters"), {once: true});

const form = document.getElementById("form");
const url = "http://localhost:8080/addRelation/client-resultcenter";
form.addEventListener("submit", eventAddRelation => {
    addRelation(eventAddRelation, url, selectClient.value, selectRC.value);
});