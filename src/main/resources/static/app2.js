// Función para registrar una nueva cita
document.getElementById('cita-form').addEventListener('submit', function(event) {
    event.preventDefault();

    const cita = {
        vehiculo: document.getElementById('vehiculo').value,
        fechaHora: document.getElementById('fechaHora').value,
        descripcion: document.getElementById('descripcion').value
    };

    fetch('http://localhost:8080/api/citas', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(cita)
    })
        .then(response => response.json())
        .then(data => {
            alert('Cita registrada con éxito');
            obtenerCitas(); // Actualizar la lista de citas
            document.getElementById('cita-form').reset(); // Limpiar formulario
        })
        .catch(error => console.error('Error al registrar cita:', error));
});

// Obtener todas las citas registradas
function obtenerCitas() {
    fetch('http://localhost:8080/api/citas')
        .then(response => response.json())
        .then(data => {
            const tableBody = document.querySelector('#citas-table tbody');
            tableBody.innerHTML = ''; // Limpiar la tabla antes de llenarla
            data.forEach(cita => {
                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>${cita.id}</td>
                    <td>${cita.vehiculo}</td>
                    <td>${cita.fechaHora}</td>
                    <td>${cita.descripcion}</td>
                `;
                tableBody.appendChild(row);
            });
        })
        .catch(error => console.error('Error al obtener las citas:', error));
}

// Función para registrar una reparación
document.getElementById('reparacion-form').addEventListener('submit', function(event) {
    event.preventDefault();

    const reparacion = {
        citaId: document.getElementById('citaId').value,
        descripcion: document.getElementById('descripcion').value
    };

    fetch('http://localhost:8080/api/reparaciones', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(reparacion)
    })
        .then(response => response.json())
        .then(data => {
            alert('Reparación registrada con éxito');
            document.getElementById('reparacion-form').reset(); // Limpiar formulario
        })
        .catch(error => console.error('Error al registrar reparación:', error));
});
