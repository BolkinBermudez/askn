function obtenerListaUsuarios(){
    var listaUsuarios = JSON.parse(localStorage.getItem('listaUsuariosLs'));

    if(listaUsuarios == null){
        listaUsuarios =
        [
            //rol,       correo,        contraseña      nombre      Apellido
            ['1',  'admin@gmail.com',    '123456',  'Julio Cesar',  'Bernal'],
            ['2', 'vendedor@gmail.com',  '654321',  'Bolkin Alberto','Bermudez'],
            ['3', 'tecnico@gmail.com',   '615243',  'Carlos Andres', 'Alvarez'],
            ['4','coordinador@gmail.com','111111',  'Mirella',  'Parra Pinto']
        ]
    }
    return listaUsuarios;
}
function validarCredenciales(pCorreo,pContrasenna){
    var listaUsuarios = obtenerListaUsuarios();
    var bAcceso = false;

    for(var i = 0; i< listaUsuarios.length;i++){
        if(pCorreo == listaUsuarios[i][2] && pContrasenna == listaUsuarios[i][3]){
            bAcceso = true;
            sessionStorage.setItem('usuarioActivo', listaUsuarios[i][4]+' '+ listaUsuarios[i][5]);
            sessionStorage.setItem('rolUsuarioActivo', listaUsuarios[i][1]);
        }
    }
    return bAcceso;
}