document.querySelector('#btnIngresar').addEventListener('click', iniciarSesion);

function iniciarSesion(){
    var sCorreo ='';
    var sContrasenna = '';
    var bAcceso = false;

    sCorreo = document.querySelector('#correo').Value;
    sContrasenna= document.querySelector('#password').value;

    bAcceso = validarCredenciales(sCorreo,sContrasenna);
    
    if(bAcceso == treu){
        ingresar ();
    }
}

function ingresar(){
    var rol = sessionStorage.getItem('rolUsuarioActivo');
    switch(rol){
        case '1':
            window.location.href = '/index-askn.html';
            break;
        
        case '2':
            window.location.href = 'https://www.animeid.tv/';
            break;

        case '3':
            window.location.href = 'https://www.animeid.tv/';
            break;
        case '4':
            window.location.href = 'https://www.animeid.tv/';
            break;
        default:
            window.location.href = '../Formularios login/login.html';
    }
}