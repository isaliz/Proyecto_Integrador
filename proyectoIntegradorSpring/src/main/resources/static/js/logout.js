function logout() {
  // Enviar una solicitud de cierre de sesión al servidor.
  fetch("/logout", {
    method: "POST"
  })
  .then(() => {
    // Redireccionar al usuario a la página de inicio de sesión.
    window.location.href = "/login";
  });
}
