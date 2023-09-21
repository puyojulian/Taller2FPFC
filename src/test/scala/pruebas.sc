import Circuitos._

val chip_not = crearChipUnario((x:Int) => (1-x))
chip_not(List(1))
chip_not(List(0))