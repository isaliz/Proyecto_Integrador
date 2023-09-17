// Este código carga una lista de odontólogos de una API y los muestra en una tabla.

window.addEventListener('load', function () {

    // Obtiene la lista de odontólogos de la API.
    (async function () {

        const url = '/odontologos';
        const settings = {
            method: 'GET'
        };

        const data = await fetch(url, settings);
        const odontologos = await data.json();

        // Crea una fila de tabla para cada odontólogo.
        for (const odontologo of odontologos) {

            // Crea un botón de modificar para cada odontólogo.
            const updateButton = `<button id="btn_id_${odontologo.id}" type="button" onclick="updateBy(${odontologo.id})" class="btn btn-info btn_id">Actualizar</button>`;

            // Crea un botón de eliminar para cada odontólogo.
            const deleteButton = `<button id="btn_delete_${odontologo.id}" type="button" onclick="deleteBy(${odontologo.id})" class="btn btn-danger btn_delete">Eliminar</button>`;

            // Crea la fila de tabla.
            const table = document.getElementById("odontologosTable");
            const odontologoRow = table.insertRow();
            table.innerHTML += `
                <tr id="tr_${odontologo.id}">
                    <td>${odontologo.id}</td>
                    <td>${odontologo.nombre}</td>
                    <td>${odontologo.apellido}</td>
                    <td>${odontologo.matricula}</td>
                    <td>${updateButton} </td> <td> ${deleteButton}</td>
                </tr>
            `;
        }

    })();

    // Marca la navegación como activa.
    (function () {
        const pathname = window.location.pathname;
        if (pathname == "./odontologoList.html") {
            document.querySelector(".nav .nav-item a:last").classList.add("active");
        }
    })();

});



