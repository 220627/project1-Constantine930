document.getElementById("GetReimb").onclick=GetReimb;
const url ="http://localhost:3000"
document.getElementById("GOReq").onclick=GoReq;
document.getElementById("LogOut").onclick=LogOut;
document.getElementById("Accept").onclick=UpdateStatusA;
document.getElementById("Deny").onclick=UpdateStatusD;
async function GetReimb(){
    while(document.getElementById("requestBody").rows.length > 0) {
        document.getElementById("requestBody").deleteRow(0);
      }
    let stat = document.getElementById("stat").value;
    let resp = await fetch(url+"/View/"+stat)
    console.log(resp)
    if(resp.status === 200){

        let data = await resp.json();
        for(let Bob of data){
            let row =document.createElement("tr")
            let cell = document.createElement("td")
            let cell2 = document.createElement("td")
            let cell3 = document.createElement("td")
            let cell4 = document.createElement("td")
            let cell5 = document.createElement("td")
            let cell6 = document.createElement("td")
            let cell7 = document.createElement("td")
            let cell8 = document.createElement("td")
            let cell9 = document.createElement("td")
            let cell10 = document.createElement("td")
            let cell11 = document.createElement("td")
            let cell12 = document.createElement("td")
            cell12.innerHTML=Bob.reim_ID
            cell.innerHTML = Bob.amount
            cell2.innerHTML = Bob.time
            cell3.innerHTML = Bob.desc
            cell4.innerHTML = Bob.auth
            cell5.innerHTML = Bob.aut.fname
            cell6.innerHTML = Bob.aut.lname
            cell7.innerHTML = Bob.res
            cell8.innerHTML = Bob.respondant.fname
            cell9.innerHTML = Bob.respondant.lname
            cell10.innerHTML = Bob.stat
            cell11.innerHTML = Bob.types
            row.appendChild(cell12)
            row.appendChild(cell)
            row.appendChild(cell2)
            row.appendChild(cell3)
            row.appendChild(cell4)
            row.appendChild(cell5)
            row.appendChild(cell6)
            row.appendChild(cell7)
            row.appendChild(cell8)
            row.appendChild(cell9)
            row.appendChild(cell10)
            row.appendChild(cell11)

            document.getElementById("requestBody").appendChild(row)

        }
    }else{
        alert("something went wrong is java running?")
    }
}
async function UpdateStatusA(){
    let id = document.getElementById("ID").value;
    let resp = await fetch(url+"/Reim/"+id, {
        method:"Put", //checking case sensitivity
        body: 1
    })
if (resp.status===202){
    document.getElementById("Checkspace").innerText = "You updated reimbersment with id "+ id +  " to Accepted"
    while(document.getElementById("requestBody").rows.length > 0) {
        document.getElementById("requestBody").deleteRow(0);
      }
      //small change is here
    let respo = await fetch(url+"/View/"+1)
    console.log(respo)
    if(respo.status === 200){

        let data = await respo.json();
        for(let Bob of data){
            let row =document.createElement("tr")
            let cell = document.createElement("td")
            let cell2 = document.createElement("td")
            let cell3 = document.createElement("td")
            let cell4 = document.createElement("td")
            let cell5 = document.createElement("td")
            let cell6 = document.createElement("td")
            let cell7 = document.createElement("td")
            let cell8 = document.createElement("td")
            let cell9 = document.createElement("td")
            let cell10 = document.createElement("td")
            let cell11 = document.createElement("td")
            let cell12 = document.createElement("td")
            cell12.innerHTML=Bob.reim_ID
            cell.innerHTML = Bob.amount
            cell2.innerHTML = Bob.time
            cell3.innerHTML = Bob.desc
            cell4.innerHTML = Bob.auth
            cell5.innerHTML = Bob.aut.fname
            cell6.innerHTML = Bob.aut.lname
            cell7.innerHTML = Bob.res
            cell8.innerHTML = Bob.respondant.fname
            cell9.innerHTML = Bob.respondant.lname
            cell10.innerHTML = Bob.stat
            cell11.innerHTML = Bob.types
            row.appendChild(cell12)
            row.appendChild(cell)
            row.appendChild(cell2)
            row.appendChild(cell3)
            row.appendChild(cell4)
            row.appendChild(cell5)
            row.appendChild(cell6)
            row.appendChild(cell7)
            row.appendChild(cell8)
            row.appendChild(cell9)
            row.appendChild(cell10)
            row.appendChild(cell11)

            document.getElementById("requestBody").appendChild(row)

        }
    }else{
        alert("something went wrong is java running?")
    }
}else{
    document.getElementById("Checkspace").innerText= "Something is off"
}
}

async function UpdateStatusD(){
    let id = document.getElementById("ID").value;
    let resp = await fetch(url+"/Reim/"+id, {
        method:"Put", //checking case sensitivity
        body: 2
    })
if (resp.status===202){
    // i wanna show the knew thing in so i will copy paste the code from GetReimb(); with one small change
    while(document.getElementById("requestBody").rows.length > 0) {
        document.getElementById("requestBody").deleteRow(0);
      }
      //small change is here
    let respo = await fetch(url+"/View/"+2)
    console.log(respo)
    if(respo.status === 200){
        document.getElementById("Checkspace").innerText = "You updated reimbersment with id "+ id +  " to Denied"
        let data = await respo.json();
        for(let Bob of data){
            let row =document.createElement("tr")
            let cell = document.createElement("td")
            let cell2 = document.createElement("td")
            let cell3 = document.createElement("td")
            let cell4 = document.createElement("td")
            let cell5 = document.createElement("td")
            let cell6 = document.createElement("td")
            let cell7 = document.createElement("td")
            let cell8 = document.createElement("td")
            let cell9 = document.createElement("td")
            let cell10 = document.createElement("td")
            let cell11 = document.createElement("td")
            let cell12 = document.createElement("td")
            cell12.innerHTML=Bob.reim_ID
            cell.innerHTML = Bob.amount
            cell2.innerHTML = Bob.time
            cell3.innerHTML = Bob.desc
            cell4.innerHTML = Bob.auth
            cell5.innerHTML = Bob.aut.fname
            cell6.innerHTML = Bob.aut.lname
            cell7.innerHTML = Bob.res
            cell8.innerHTML = Bob.respondant.fname
            cell9.innerHTML = Bob.respondant.lname
            cell10.innerHTML = Bob.stat
            cell11.innerHTML = Bob.types
            row.appendChild(cell12)
            row.appendChild(cell)
            row.appendChild(cell2)
            row.appendChild(cell3)
            row.appendChild(cell4)
            row.appendChild(cell5)
            row.appendChild(cell6)
            row.appendChild(cell7)
            row.appendChild(cell8)
            row.appendChild(cell9)
            row.appendChild(cell10)
            row.appendChild(cell11)

            document.getElementById("requestBody").appendChild(row)

        }
    }else{
        alert("something went wrong is java running?")
    }
}else{
    document.getElementById("Checkspace").innerText= "Something is off"
}
}
async function GoReq(){
    location.href="P1makerequestMan.html"
}
async function LogOut(){
    let Gem = await fetch(url+"/logout")
    if (Gem.status==200){
    location.href="LoginPage.html"}
    else{
        document.getElementById("Head").innerText="Something is wrong with Log out"
    }
}