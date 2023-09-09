function deleteBy(id) {
    // Elimina el paciente de la API.
    fetch(`/pacientes/${id}`, {
        method: 'DELETE'
    });

    // Elimina la fila de la tabla.
    const table = document.getElementById("pacientesTable");
    const row = table.querySelector(`#tr_${id}`);
    row.remove();
}
