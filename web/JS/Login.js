const Correo = document.getElementById("Correo")
const password = document.getElementById("password")
const form =document.getElementById("form-login")

form.addEventListener("submit" , e=>{
    e.preventDefault()
    if(Correo.value.length <6){
        alert("correo invalido")
    }
})

  