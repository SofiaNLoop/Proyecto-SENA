document.getElementById('actualizarForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const id = localStorage.getItem("idUser");

    const nombre = document.getElementById('nombre').value;
    const correo = document.getElementById('correo').value;
    const contraseña = document.getElementById('contraseña').value;

    const data = {
        nombre: nombre,
        correo: correo,
        contraseña: contraseña
    };

    fetch(`http://localhost:8080/api/v1/admin/update/${id}`,  {
        method: 'PUT', 
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(data => {
        alert(data.msj);
        window.location.href = 'index.html'
    })
    .catch(error => console.error('Error:', error));
})

