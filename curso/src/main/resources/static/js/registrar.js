
async function registrarUsuarios(){
    let datos = {};
    datos.nombre = document.getElementById('txtNombre').value;
    datos.apellido = document.getElementById('txtApellido').value;
    datos.email = document.getElementById('txtCorreo').value;
    datos.password = document.getElementById('txtContraseña').value;

    let repetirContraseña = document.getElementById('txtConfirmarC').value;

    if (repetirContraseña !=datos.password){
        alert('La contraseña no coincide');
        return;
    }

    const request = await fetch('api/usuarios', {
    method: 'POST',
    headers: {
        'Accept' : 'application/json',
        'Content-Type' : 'application/json'
    },
    body: JSON.stringify(datos)
    });

    alert("La cuenta fue creada")
    windows.location.href = 'login.html'

}
