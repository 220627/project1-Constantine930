document.getElementById("GetReimb").onclick=GetReimb;
const url ="http://localhost:3000"
document.getElementById("GOReq").onclick=GoReq;
document.getElementById("LogOut").onclick=LogOut;
async function GetReimb(){
    let resp = await fetch(url+"/View")
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
            cell.innerHTML = Bob.amount
            cell2.innerHTML = Bob.time
            cell3.innerHTML = Bob.desc
            cell4.innerHTML = Bob.auth
            cell5.innerHTML = Bob.res
            cell6.innerHTML = Bob.stat
            cell7.innerHTML = Bob.types
            row.appendChild(cell)
            row.appendChild(cell2)
            row.appendChild(cell3)
            row.appendChild(cell4)
            row.appendChild(cell5)
            row.appendChild(cell6)
            row.appendChild(cell7)

            document.getElementById("requestBody").appendChild(row)

        }
    }else{
        alert("something went wrong is java running?")
    }
}
async function GoReq(){
    location.href="P1Html3.html"
}
async function LogOut(){
    let Gem = await fetch(url+"/logout")
    if (Gem.status==200){
    location.href="LoginPage.html"}
    else{
        document.getElementById("Head").innerText="Something is wrong with Log out"
    }
}