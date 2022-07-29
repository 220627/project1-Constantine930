const url ="http://localhost:3000"
document.getElementById("Sub").onclick = MakeRequest;
document.getElementById("View").onclick = GoBack;
document.getElementById("LogOut").onclick=LogOut;
async function MakeRequest(){
    let a = document.getElementById("Amount").value;
    if(!a){
        a=0;
    }
    let d =document.getElementById("desc").value;
    let t = document.getElementById("Type").value;
    let details ={amount:a, Date:7-26-2022, desc:d, auth:1, res:1, status:3 , type:t};
    
    let Gem = await fetch(url+"/Reimreq",{method:"PUT",
   body: JSON.stringify(details),
    credentials:"include"})

   if(Gem.status==201){
       document.getElementById("Head").innerText="Request successful"
   }else{
       document.getElementById("Head").innerText="Something went wrong"
  }

}

async  function GoBack(){
    location.href="P1Html.html"
}
async   function LogOut(){
    //still pseudo logout
    let Gem = await fetch(url+"/logout")
    if (Gem.status==200){
    location.href="LoginPage.html"}
    else{
        document.getElementById("Head").innerText="Something is wrong with Log out"
    }
}