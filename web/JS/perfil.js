e.preventDefault();
var swal1 = ()=> Swal.fire({
    title: 'Desea cerrar Sesión?',
    icon: 'question',
    showCancelButton: true,
    confirmButtonColor: '#3fcdc4',
    cancelButtonColor: '#f25366',
    confirmButtonText: 'Cerrar Sesión'
  }).then((result) => {
    if (result.value) {
      window.location.href='Formularios login/login.html'
    }
  })