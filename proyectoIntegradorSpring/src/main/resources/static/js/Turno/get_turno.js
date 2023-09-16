// Este código carga una lista de odontólogos de una API y los muestra en una tabla.

// Configuración para las solicitudes fetch
const settings = {
  method: 'GET',
  headers: {
    'Content-Type': 'application/json',
  },
};

// Obtiene la lista de turnos de la API.
async function getTurnos() {
  const data = await fetch('http://localhost:8080/turno/getAll', settings);
  const turnos = await data.json();
  return turnos;
}

// Crea una fila de tabla para cada turno.
function createTurnoRow(turno, odontologos) {
  const table = document.getElementById('turnoTable');
  const turnoRow = table.insertRow();

    // Crea un botón de modificar para cada pacientes.
            const updateButton = `<button id="btn_id_${turno.id}" type="button" onclick="findBy(${turno.id})" class="btn btn-info btn_id">Actualizar</button>`;

            // Crea un botón de eliminar para cada odontólogo.
            const deleteButton = `<button id="btn_delete_${turno.id}" type="button" onclick="deleteBy(${turno.id})" class="btn btn-danger btn_delete">Eliminar</button>`;


  turnoRow.innerHTML = `
    <tr id="tr_${turno.id}">
      <td>${turno.id}</td>
      <td>${turno.paciente.nombre+'   '+turno.paciente.apellido}</td>
      <td>${turno.odontologo.nombre+'   '+turno.odontologo.apellido}</td>
       <td>${turno.date}</td>
       <td>${turno.time}</td>
        <td>${updateButton} </td> <td> ${deleteButton}</td>
    </tr>
  `;
}

window.addEventListener('load', async function () {
  const turnos = await getTurnos();
  for (const turno of turnos) {
    createTurnoRow(turno);
  }
});
