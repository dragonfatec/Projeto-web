import getRCs from "../resultCenter/getRCs.js";
import getUsers from "../user/getUsers.js";
import addRelation from "./addRelation.js";

const url = "http://localhost:8080/addRelation/user-resultcenter";

const selectUser = document.getElementById("users");
selectUser.addEventListener("click", eventUser => getUsers(eventUser,"users"), {once: true});

const selectRC = document.getElementById("resultCenters");
selectRC.addEventListener("click", eventRC => getRCs(eventRC, "resultCenters"), {once: true});

const form = document.getElementById("form");
form.addEventListener("submit", eventAdd => addRelation(eventAdd, url, selectUser.value, selectRC.value))