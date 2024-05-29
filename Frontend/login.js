document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const correo = document.getElementById('correo').value;
    const contraseña = document.getElementById('contraseña').value;

    const data = {
        correo: correo,
        contraseña: contraseña
    };

    fetch('http://localhost:8081/api/v1/admin/login', {
        method: 'POST', 
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(data => {
        if(data.msj === "OK"){
            window.location.href = 'index.html';
        }else {
            alert(data.msj);
        }
    })
    .catch((error) => {
        console.error('Error:', error);
        alert('Error registrando al administrador');
    });
});