// Este código carga una lista de odontólogos de una API y los muestra en una tabla.

window.addEventListener('load', function () {

    // Obtiene la lista de odontólogos de la API.
    (function(){

        const url = '/odontologos';
        const settings = {
            method: 'GET'
        };

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {

                // Crea una fila de tabla para cada odontólogo.
                for (odontologo of data) {

                     // Crea un botón de modificar para cada odontólogo.
                    let updateButton = '<button id="btn_id_' + odontologo.id + '" type="button" onclick="updateBy(' + odontologo.id + ')" class="btn btn-info btn_id">' + odontologo.id + '</button>';
                    // Crea la fila de tabla.
                    var table = document.getElementById("odontologosTable");
                    var odontologoRow = table.insertRow();
                    table.innerHTML = odontologos.map(odontologo => `
                    <tr id="tr_${odontologo.id}">
                        <td>${odontologo.id}</td>
                        <td>${odontologo.nombre}</td>
                        <td>${odontologo.apellido}</td>
                        <td>${odontologo.matricula}</td>
                         <td><button class="btn btn-info" onclick="updateBy(${odontologo.id})">Actualizar</button></td>
                        <td><button class="btn btn-danger" onclick="deleteBy(${odontologo.id})">Eliminar</button></td>
                    </tr>
                    `).join("");
                }

            });

    })();

    // Marca la navegación como activa.
    (function(){
        let pathname = window.location.pathname;
        if (pathname == "/get_all_odontologos.html") {
            document.querySelector(".nav .nav-item a:last").addClass("active");
        }
    })();

});

// Actualiza la tabla con los nuevos datos despues de eliminar
fetch('/odontologos')
    .then(response => response.json())
    .then(odontologos => {
        // Actualiza la tabla con los nuevos odontólogos.
        var table = document.getElementById("odontologosTable");
        table.innerHTML = odontologos.map(odontologo => `
            <tr id="tr_${odontologo.id}">
                <td>${odontologo.id}</td>
                <td>${odontologo.nombre}</td>
                <td>${odontologo.apellido}</td>
                <td>${odontologo.matricula}</td>
                <td><button class="btn btn-info" onclick="updateButton(${odontologo.id})">Actualizar</button></td>
                <td><button class="btn btn-danger" onclick="deleteBy(${odontologo.id})">Eliminar</button></td>
            </tr>
        `).join("");
    });

/// Función para actualizar los datos de un odontólogo.
 function updateBy(id) {

     // Obtiene los datos del odontólogo a actualizar.
     const odontologo = document.querySelector(`#tr_${id}`).querySelectorAll("td")[1].textContent;

     // Crea un objeto con los datos del odontólogo actualizado.
     const odontologoActualizado = {
         id: id,
         nombre: document.querySelector(`#tr_${id}`).querySelectorAll("td")[2].textContent,
         apellido: document.querySelector(`#tr_${id}`).querySelectorAll("td")[3].textContent,
         matricula: document.querySelector(`#tr_${id}`).querySelectorAll("td")[4].textContent
     };

     // Actualiza el odontólogo en la API.
     (async () => {
         const url = '/odontologos/' + id;
         const settings = {
             method: 'PUT',
             body: JSON.stringify(odontologoActualizado)
         };

         await fetch(url, settings);
     })();

     // Actualiza la tabla con los datos del odontólogo actualizado.
     document.querySelector(`#tr_${id}`).querySelectorAll("td")[2].textContent = odontologoActualizado.nombre;
     document.querySelector(`#tr_${id}`).querySelectorAll("td")[3].textContent = odontologoActualizado.apellido;
     document.querySelector(`#tr_${id}`).querySelectorAll("td")[4].textContent = odontologoActualizado.matricula;
 }

