const url ="http://localhost:3000"

document.getElementById("loginButton").onclick=Loginfun;
document.getElementById("GetReimb").onclick=GetReimb;
async function Loginfun(){
    let name = document.getElementById("username").value
    let pass = document.getElementById("password").value
    let creds = {name: name, pass: pass}
    console.log(creds)
    let Gem = await fetch(url+"/login",{
        method:"Post",
        body: JSON.stringify(creds),
        credentials:"include"})
    console.log(Gem.status)
    if(Gem.status===202){
        let data = await Gem.json();
        document.getElementById("welcomehead").innerText="Welcome "+data.fname
        if (data.perm===1){
        location.href="P1Html.html"}
        else if (data.perm===2){
            location.href="P1Html2.html"
        }

    }else{
        document.getElementById("welcomehead").innerText="login failed messed up you did"
        document.getElementById("welcomehead").style.color ="red"
     }

}
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