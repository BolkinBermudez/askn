function validar(form){
    event.preventDefault();
    var correo = form.correo;
    

    if(correo.value == ""){
        alert("Debe Ingresar un correo electronico.");
        correo.focus();
        correo.select();
        return false;
    } else{
       // validarCorreo();
    }

    var password=form.password;

    if(password.value.length == "" ){
        alert("Debe Ingresar la contraseña")
        password.focus();
        password.select();
        return false;
    } else{ 
        if(password.value.length <6 ){
            alert("La contraseña es muy corta.")
            password.focus();
            password.select();
            return false;
        }

    
    }
}

function validarCorreo(correo){
    var expReg = /^[a-z0-9!#$%&'+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'+/=?^_`{|}~-]+)@(?:[a-z0-9](?:[a-z0-9-][a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$/;
    var esValido = expReg.test(correo);
    if(esValido==false){
        alert("El correo electronico No es válido.");
    }
}
