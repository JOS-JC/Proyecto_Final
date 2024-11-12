// Obtener la lista de vehículos al cargar la página
window.onload = function() {
    obtenerVehiculos();
};

// Obtener vehículos registrados
function obtenerVehiculos() {
    fetch('http://localhost:8080/api/vehiculos')
        .then(response => response.json())
        .then(data => {
            const tableBody = document.querySelector('#vehiculos-table tbody');
            tableBody.innerHTML = ''; // Limpiar la tabla antes de llenarla
            data.forEach(vehiculo => {
                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>${vehiculo.id}</td>
                    <td>${vehiculo.marca}</td>
                    <td>${vehiculo.modelo}</td>
                    <td>${vehiculo.anio}</td>
                    <td>${vehiculo.placa}</td>
                `;
                tableBody.appendChild(row);
            });
        })
        .catch(error => console.error('Error al obtener los vehículos:', error));
}

// Registrar un nuevo vehículo
document.getElementById('vehiculo-form').addEventListener('submit', function(event) {
    event.preventDefault();

    const vehiculo = {
        marca: document.getElementById('marca').value,
        modelo: document.getElementById('modelo').value,
        anio: document.getElementById('anio').value,
        placa: document.getElementById('placa').value
    };

    fetch('http://localhost:8080/api/vehiculos', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(vehiculo)
    })
        .then(response => response.json())
        .then(data => {
            alert('Vehículo registrado con éxito');
            obtenerVehiculos(); // Actualizar la lista de vehículos
            document.getElementById('vehiculo-form').reset(); // Limpiar el formulario
        })
        .catch(error => {
            alert('Error al registrar el vehículo');
            console.error('Error:', error);
        });
});
