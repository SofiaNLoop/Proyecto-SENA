const getAdmins = () => {
    fetch('http://localhost:8080/api/v1/admin/', {
        method: 'GET', 
        headers: {
            'Content-Type': 'application/json',
        },

    })
    .then(response => response.json())
    .then(data => {
        const tableBody = document.getElementById('tableBody');
            tableBody.innerHTML = ''; // Limpia el contenido actual del tbody

            data.forEach(admin => {
                const tr = document.createElement('tr');  // Crea una nueva fila
                tr.innerHTML = `<td>${admin.id}</td>
                                <td>${admin.nombre}</td>
                                <td>${admin.correo}</td>`;
                tableBody.appendChild(tr);  // Añade la fila al cuerpo de la tabla
            });
    })
    .catch((error) => {
        console.error('Error:', error);
    });
}

getAdmins();