class Reserva(var huesped: Huesped, var habitacion: Habitacion, var totalNoches: Int) {
    val totalAPagar: Double
        get() = habitacion.precioPorNoche * totalNoches
}