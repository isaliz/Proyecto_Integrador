// Este código carga una lista de pacientes de una API y los muestra en una tabla.

window.addEventListener('load', function () {

    // Obtiene la lista de pacientes de la API.
    (async function () {

        const url = '/pacientes';
        const settings = {
            method: 'GET'
        };

        const data = await fetch(url, settings);
        const pacientes = await data.json();

        // Crea una fila de tabla para cada pacientes.
        for (const paciente of pacientes) {

            // Crea un botón de modificar para cada pacientes.
            const updateButton = `<button id="btn_id_${paciente.id}" type="button" onclick="updateBy(${paciente.id})" class="btn btn-info btn_id">Actualizar</button>`;

            // Crea un botón de eliminar para cada odontólogo.
            const deleteButton = `<button id="btn_delete_${paciente.id}" type="button" onclick="deleteBy(${paciente.id})" class="btn btn-danger btn_delete">Eliminar</button>`;

            // Crea la fila de tabla.
            const table = document.getElementById("pacientesTable");
            const pacienteRow = table.insertRow();
            table.innerHTML += `
                <tr id="tr_${paciente.id}">
                    <td>${paciente.id}</td>
                    <td>${paciente.nombre}</td>
                    <td>${paciente.apellido}</td>
                    <td>${paciente.dni}</td>
                    <td>${paciente.domicilio}</td>
                    <td>${paciente.fecha}</td>
                    <td>${updateButton} </td> <td> ${deleteButton}</td>
                </tr>
            `;
        }

    })();

    // Marca la navegación como activa.
    (function () {
        const pathname = window.location.pathname;
        if (pathname == "./pacienteList.html") {
            document.querySelector(".nav .nav-item a:last").classList.add("active");
        }
    })();

});



