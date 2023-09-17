function deleteBy(id) {
  const url = '/turno/' + id;
  const settings = {
    method: 'DELETE',
  };

  fetch(url, settings)
    .then(response => response.json())
    .then(() => {
      // Actualizar la tabla HTML

      // Obtener la fila a eliminar
      const row = document.querySelector('#tr_' + id);

      // Eliminar la fila de la tabla
      row.parentNode.removeChild(row);

      // Mostrar un mensaje de éxito
      alert('Se borró el turno con id ' + id);
    });
}
