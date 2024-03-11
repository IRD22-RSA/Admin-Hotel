class Controlador {
    private val admin = Admin()
    fun showMenu() {
        while (true) {
            println(
                """
            Selecciona una opción:
            1. Menu huéspedes
            2. Menú habitaciones
            3. Crear reserva
            4. Ver reservas
            5. Salir
        """
            )
            when (readlnOrNull()?.toInt()) {
                1 -> {
                    println(
                        """
                    1. Agregar huésped
                    2. Eliminar huésped
                    3. Modificar huésped
                    4. Ver lista de huéspedes
                """
                    )
                    when (readlnOrNull()?.toInt()) {
                        1 -> {
                            println("Ingrese el nombre del huésped:")
                            val nombre = readln()
                            println("Ingrese el ID del huésped:")
                            val id = readln().toInt()
                            admin.agregarHuesped(Huesped(nombre, id))
                        }

                        2 -> {
                            println("Ingrese el ID del huésped a eliminar:")
                            val id = readln().toInt()
                            admin.eliminarHuesped(id)
                        }

                        3 -> {
                            println("Ingrese el ID del huésped a modificar:")
                            val id = readln().toInt()
                            println("Ingrese el nuevo nombre del huésped:")
                            val nuevoNombre = readln()
                            admin.modificarHuesped(id, nuevoNombre)
                        }

                        4 -> {
                            println("Lista de huéspedes:")
                            admin.huespedes.forEach { println("ID: ${it.id}, Nombre: ${it.nombre}") }
                        }
                    }
                }

                2 -> {
                    println(
                        """
                    1. Agregar habitación
                    2. Eliminar habitación
                    3. Modificar habitación
                    4. Ver lista de habitaciones
                """
                    )
                    when (readlnOrNull()?.toInt()) {
                        1 -> {
                            println("Ingrese el número de la habitación:")
                            val numero = readln().toInt()
                            println("Ingrese el tipo de la habitación:")
                            val tipo = readln()
                            println("Ingrese el precio por noche de la habitación:")
                            val precioPorNoche = readln().toDouble()
                            admin.agregarHabitacion(Habitacion(numero, tipo, precioPorNoche))
                        }

                        2 -> {
                            println("Ingrese el número de la habitación a eliminar:")
                            val numero = readln().toInt()
                            admin.eliminarHabitacion(numero)
                        }

                        3 -> {
                            println("Ingrese el número de la habitación a modificar:")
                            val numero = readln().toInt()
                            println("Ingrese el nuevo tipo de la habitación:")
                            val nuevoTipo = readln()
                            println("Ingrese el nuevo precio por noche de la habitación:")
                            val nuevoPrecio = readln().toDouble()
                            admin.modificarHabitacion(numero, nuevoTipo, nuevoPrecio)
                        }

                        4 -> {
                            println("Lista de habitaciones:")
                            admin.habitaciones.forEach { println("Número: ${it.numero}, Tipo: ${it.tipo}, Precio por noche: ${it.precioPorNoche}") }
                        }
                    }
                }

                3 -> {
                    println("Ingrese el ID del huésped para la reserva:")
                    val idHuesped = readln().toInt()
                    println("Ingrese el número de la habitación para la reserva:")
                    val numeroHabitacion = readln().toInt()
                    println("Ingrese el total de noches para la reserva:")
                    val totalNoches = readln().toInt()
                    admin.crearReserva(idHuesped, numeroHabitacion, totalNoches)
                }

                4 -> {
                    println("Lista de reservas:")

                    admin.reservas.forEach { reserva ->
                        println("Huésped: ${reserva.huesped.nombre}, Habitación: ${reserva.habitacion.numero}, Total de noches: ${reserva.totalNoches}, Total a pagar: ${reserva.totalAPagar}")
                    }
                }

                5 -> return
                else -> println("Opción no válida. Por favor, intente de nuevo.")
            }
        }
    }
}
