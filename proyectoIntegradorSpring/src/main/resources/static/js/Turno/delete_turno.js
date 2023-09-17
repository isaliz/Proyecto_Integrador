 function deleteBy(id) {
     // Elimina el paciente de la API.
     fetch(`/turno/${id}`, {
         method: 'DELETE'
     });

     // Elimina la fila de la tabla.
     const table = document.getElementById("turnoTable");
     const row = table.querySelector(`#tr_${id}`);
     row.remove();
 }

