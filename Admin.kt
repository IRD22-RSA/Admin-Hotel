class Admin {
    var huespedes = mutableListOf<Huesped>()
    var habitaciones = mutableListOf<Habitacion>()
    var reservas = mutableListOf<Reserva>()

    fun agregarHuesped(huesped: Huesped) {
        huespedes.add(huesped)
    }

    fun eliminarHuesped(id: Int) {
        huespedes.removeIf { it.id == id }
    }

    fun modificarHuesped(id: Int, nuevoNombre: String) {
        huespedes.find { it.id == id }?.nombre = nuevoNombre
    }

    fun agregarHabitacion(habitacion: Habitacion) {
        habitaciones.add(habitacion)
    }

    fun eliminarHabitacion(numero: Int) {
        habitaciones.removeIf { it.numero == numero }
    }

    fun modificarHabitacion(numero: Int, nuevoTipo: String, nuevoPrecio: Double) {
        habitaciones.find { it.numero == numero }?.apply {
            tipo = nuevoTipo
            precioPorNoche = nuevoPrecio
        }
    }

    fun crearReserva(idHuesped: Int, numeroHabitacion: Int, totalNoches: Int): Reserva? {
        val huesped = huespedes.find { it.id == idHuesped }
        val habitacion = habitaciones.find { it.numero == numeroHabitacion }
        return if (huesped != null && habitacion != null) {
            val reserva = Reserva(huesped, habitacion, totalNoches)
            reservas.add(reserva)
            reserva
        } else {
            null

        }
    }

}