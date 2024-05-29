document.getElementById('registroForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const nombre = document.getElementById('nombre').value;
    const correo = document.getElementById('correo').value;
    const contraseña = document.getElementById('contraseña').value;

    const data = {
        nombre: nombre,
        correo: correo,
        contraseña: contraseña
    };

    fetch('http://localhost:8081/api/v1/admin/create', {
        method: 'POST', 
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(data => {
        alert(data.msj);
    })
    .catch((error) => {
        console.error('Error:', error);
        alert('Error registrando al administrador');
    });
   
});

