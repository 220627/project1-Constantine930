const url ="http://localhost:3000"
document.getElementById("loginButton").onclick=Loginfun;

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
