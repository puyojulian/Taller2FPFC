/*
Autores:  Julian Ernesto Puyo Mora <julian.puyo@correounivalle.edu.co> <202226905>
          Sebastian Orrego Marin <orrego.sebastian@correounivalle.edu.co> <201941144>
N° Taller: 02
Fecha de realización: 28/09/2023
*/

import Circuitos._

val chip_not = crearChipUnario((x: Int) => (1 - x))
chip_not(List(1))
chip_not(List(0))

val chip_and = crearChipBinario((x:Int, y:Int) => (x * y))
chip_and(List(1, 1))
chip_and(List(1, 0))
chip_and(List(0, 0))
chip_and(List(0, 1))

val chip_or = crearChipBinario((x:Int, y:Int) => x + y - (x * y))
chip_or(List(1, 1))
chip_or(List(1, 0))
chip_or(List(0, 0))
chip_or(List(0, 1))

val ha = half_adder
ha(List(0,0))
ha(List(0,1))
ha(List(1,0))
ha(List(1,1))

val fa = full_adder
fa(List(0,0,0))
fa(List(0,0,1))
fa(List(0,1,0))
fa(List(0,1,1))
fa(List(1,0,0))
fa(List(1,0,1))
fa(List(1,1,0))
fa(List(1,1,1))
/*
fa(List(1,1,0))
fa(List(1,1,1))
fa(List(0,1,0))
fa(List(0,1,1))
fa(List(1,0,0))
*/

val add_1 = adder(1)
add_1(List(1)++List(1))
add_1(List(0)++List(0))
add_1(List(1)++List(0))
add_1(List(0)++List(1))

val add_2 = adder(2)
add_2(List(1,0)++List(0,1))
add_2(List(1,1)++List(0,1))
add_2(List(1,1)++List(0,0))
add_2(List(0,1)++List(0,0))
add_2(List(0,0)++List(0,0))
add_2(List(1,1)++List(1,1))

val add_3 = adder (3)
add_3(List(1,0,1)++List(0,0,0))
add_3(List(1,0,1)++List(1,0,1))
add_3(List(1,0,0)++List(0,1,0))
add_3(List(0,0,1)++List(1,1,0))
add_3(List(1,1,1)++List(1,1,1))
add_3(List(0,0,0)++List(0,0,0))

val add_4= adder(4)
add_4(List(1,0,1,1)++List(1,0,1,0))
add_4(List(1,0,0,0)++List(0,1,0,0))
add_4(List(1,0,1,0)++List(1,0,1,0))
add_4(List(1,1,1,1)++List(1,0,1,0))
add_4(List(1,1,1,1)++List(1,1,1,1))