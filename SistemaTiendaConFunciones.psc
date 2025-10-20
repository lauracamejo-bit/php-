Algoritmo SistemaTiendaSinArreglos

    // === 1. Definiciones de Variables Simples ===
    // No se usan arreglos. El sistema manejará un solo registro a la vez.
    Definir nombreCliente, celularCliente, correoCliente Como Cadena
    Definir nombreAdministrador, celularAdministrador, correoAdministrador Como Cadena
    Definir productoReferencia, productoNombre Como Cadena
    Definir productoPrecio, cantidadProducto, VentaProducto, venta Como Real
    Definir opcionMenu Como Entero
    Definir totalDia Como Real

    // === 2. Inicialización de Variables ===
    nombreCliente <- ""
    celularCliente <- ""
    correoCliente <- ""
    nombreAdministrador <- ""
    celularAdministrador <- ""
    correoAdministrador <- ""
    productoReferencia <- ""
    productoNombre <- ""
    productoPrecio <- 0
    cantidadProducto <- 0
    totalDia <- 0

    // === 3. Menú Principal ===
    Repetir
        Escribir "======= Menu de Opciones"
        Escribir "1. Cliente"
        Escribir "2. Administrador"
        Escribir "3. Producto"
        Escribir "4. Venta"
        Escribir "5. Salir"
        Leer opcionMenu
        Limpiar Pantalla

        Segun opcionMenu Hacer
            1:
                crearCliente(nombreCliente, celularCliente, correoCliente)
            2:
                crearAdministrador(nombreAdministrador, celularAdministrador, correoAdministrador)
            3:
                crearProducto(productoReferencia, productoNombre, cantidadProducto, productoPrecio)
            4:
                Escribir "=====Generar  Ventas======"
                si productoNombre = ""
                    Escribir "No hay productos para generar ventas"
                SiNo
                    Escribir "El producto disponible es: ", productoNombre
                    Escribir "La cantidad disponible es: ", cantidadProducto

                    si cantidadProducto = 0
                        Escribir "No hay inventario"
                    sino
                        Escribir "Digite la cantidad que necesita comprar"
                        Leer VentaProducto
                        si VentaProducto <= cantidadProducto Y VentaProducto > 0
                            venta <- productoPrecio * VentaProducto
                            Escribir "Se ha realizado la venta al cliente ", nombreCliente
                            Escribir "Con el producto ", productoNombre
                            Escribir "La venta es igual a ", venta
                            Escribir "Se enviará la factura al correo ", correoCliente
                            cantidadProducto <- cantidadProducto - VentaProducto
                            totalDia <- totalDia + venta
                        sino
                            Escribir "Cantidad no válida o insuficiente stock."
                        FinSi
                    FinSi
                FinSi
            5:
                Escribir "==== INFORME FINAL DEL DÍA ===="
                Escribir "Total en ventas del día: $", totalDia
                Escribir " "
                Escribir "--- Inventario Final ---"
                si productoNombre <> ""
                    Escribir "Producto: ", productoNombre, " | Stock: ", cantidadProducto
                sino
                    Escribir "No quedó producto en el inventario."
                FinSi
                Escribir "=============================="
                Escribir "Saliendo del sistema..."
            De Otro Modo:
                Escribir "La opción no es válida!!!!"
        Fin Segun

        Esperar Tecla
        Limpiar Pantalla

    Hasta Que opcionMenu = 5
FinAlgoritmo

// =================================================================
// ============== S U B P R O C E S O S  (Funciones) ===============
// =================================================================

SubProceso crearProducto(productoReferencia Por Referencia, productoNombre Por Referencia, cantidadProducto Por Referencia, productoPrecio Por Referencia)
    Escribir "===== Registrar un Producto ===="
    Escribir "Digite la referencia del producto"
    Leer productoReferencia
    Escribir "Nombre del Producto "
    Leer productoNombre
    Escribir "Cantidad de producto"
    Leer cantidadProducto
    Escribir "Precio del producto "
    Leer productoPrecio
    Escribir "¡Producto registrado con éxito!"
FinSubProceso

SubProceso crearCliente(nombreCliente Por Referencia, celularCliente Por Referencia, correoCliente Por Referencia)
    Escribir "===== Registrar un Cliente ====="
    Escribir "Digite el nombre del Cliente"
    Leer nombreCliente
    Escribir "Digite el celular del Cliente"
    Leer celularCliente
    Escribir "Digite el email del Cliente"
    Leer correoCliente
    Escribir "¡Cliente registrado con éxito!"
FinSubProceso

SubProceso crearAdministrador(nombreAdministrador Por Referencia, celularAdministrador Por Referencia, correoAdministrador Por Referencia)
    Escribir "===== Registrar un Administrador ====="
    Escribir "Digite el nombre del Administrador"
    Leer nombreAdministrador
    Escribir "Digite el celular del Administrador"
    Leer celularAdministrador
    Escribir "Digite el email del Administrador"
    Leer correoAdministrador
    Escribir "¡Administrador registrado con éxito!"
FinSubProceso
