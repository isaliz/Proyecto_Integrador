/*function deleteBy(id)
{
          //con fetch invocamos a la API de peliculas con el método DELETE
          //pasandole el id en la URL
          const url = '/odontologos/'+ id;
          const settings = {
              method: 'DELETE'
          }
          fetch(url,settings)
          .then(response => response.json())

          //borrar la fila de la pelicula eliminada
          let row_id = "#tr_" + id;
          document.querySelector(row_id).remove();

}
*/
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
