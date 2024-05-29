const getAdmins = () => {
    fetch('http://localhost:8081/api/v1/admin/', {
        method: 'GET', 
        headers: {
            'Content-Type': 'application/json',
        },

    })
    .then(response => response.json())
    .then(data => {
        const tableBody = document.getElementById('tableBody');
            tableBody.innerHTML = '';

            data.forEach(admin => {
                const tr = document.createElement('tr');  
                tr.innerHTML = `<td>${admin.id}</td>
                                <td>${admin.nombre}</td>
                                <td>${admin.correo}</td>
                                <td><button onclick="actualizarUsuarioForm(${admin.id})">Actualizar</button></td>`;
                tableBody.appendChild(tr);  
            });
    })
    .catch((error) => {
        console.error('Error:', error);
    });
}

const actualizarUsuarioForm = (id) => {
    localStorage.setItem("idUser", id);
    window.location.href = 'actualizarUsuario.html';
}

getAdmins();