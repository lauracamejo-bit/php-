<?php
// Datos de la conexión
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "datosFormulario";

// Crear conexión
$conn = new mysqli($servername, $username, $password, $dbname);

// Verificar conexión
if ($conn->connect_error) {
    die("Conexión fallida: " . $conn->connect_error);
}

// Verificar que se recibieron datos por POST
if ($_SERVER["REQUEST_METHOD"] == "POST") {

    // Verificar que los campos requeridos no estén vacíos
    if (isset($_POST['nombreCompleto']) && isset($_POST['correoElectronico']) && isset($_POST['telefono']) && isset($_POST['fecha']) && isset($_POST['hora']) && isset($_POST['servicio'])) {

        // Recibir datos del formulario
        $nombre = $_POST['nombreCompleto'];
        $correoElectronico = $_POST['correoElectronico'];
        $telefono = $_POST['telefono'];
        $fecha = $_POST['fecha'];
        $hora = $_POST['hora'];

        // unir varios servicios seleccionados
        $servicio = implode(", ", $_POST['servicio']);

        // Preparar la consulta para evitar inyección SQL
        $stmt = $conn->prepare("INSERT INTO formulario (nombreCompleto, correoElectronico, telefono, fecha, hora, servicio) VALUES (?, ?, ?, ?, ?, ?)");
        $stmt->bind_param("ssssss", $nombre, $correoElectronico, $telefono, $fecha, $hora, $servicio);

        // Ejecutar la consulta y verificar si se insertó correctamente
        if ($stmt->execute()) {
            echo "Datos insertados correctamente";
        } else {
            echo "Error: " . $stmt->error;
        }

        $stmt->close();

    } else {
        echo "Error: Todos los campos son requeridos.";
    }

} else {
    echo "Error: Método de solicitud no válido.";
}

// Cerrar conexión
$conn->close();
?>