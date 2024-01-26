$(document).ready(function() {
    //alert(65654654);
    cargarUsuarios();
  $('#usuarios').outerHTML;
  //actualizarEmailDelUsuario();
})

function getHeaders(){
    return {
                   'Accept' : 'application/json',
                   'Content-Type' : 'application/json',
                   'Authorization': localStorage.token
               };
    }



async function cargarUsuarios(){
    const request = await fetch('/api/usuarios', {
    method: 'GET',
    headers: getHeaders()
    });
    const usuarios = await request.json();

    console.log(usuarios);

    let listadoHTML = '';

    for (let usuario of usuarios){
        let botonEliminar='<button href="#" onclick="eliminarUsuario('+usuario.id+')" class="btn-neon"><span id="span1"></span><span id="span2"></span><span id="span3"></span><span id="span4"></span><i class="bi bi-trash-fill"></i></button>';

        let telefonotexto=usuario.telefono == null ? '-' : usuario.telefono;
        let usuarioHTML = '<tr><td>'+usuario.id+'</td><td>'+usuario.nombre+' '+usuario.apellido+'</td><td>'+usuario.email+'</td><td>'+telefonotexto+'</td><td>'+botonEliminar+'</td></tr>';
        listadoHTML +=usuarioHTML;
    }

   document.querySelector('#usuarios tbody').outerHTML = listadoHTML;

}

async function eliminarUsuario(id) {

 if (!confirm('¿Desea eliminar el usuario?')){
    return;
 }
 const request = await fetch('api/usuarios/'+id, {
    method: 'DELETE',
    headers: getHeaders()
    });
    location.reload();
}