function deleteBy(id) {
    // Elimina el odontólogo de la API.
    fetch(`/odontologos/${id}`, {
        method: 'DELETE'
    });

    // Elimina la fila de la tabla.
    const table = document.getElementById("odontologosTable");
    const row = table.querySelector(`#tr_${id}`);
    row.remove();
}
