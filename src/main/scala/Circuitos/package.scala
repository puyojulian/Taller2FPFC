/*
Autores:  Julian Ernesto Puyo Mora <julian.puyo@correounivalle.edu.co> <202226905>
          Sebastian Orrego Marin <orrego.sebastian@correounivalle.edu.co> <201941144>
N° Taller: 02
Fecha de realización: 28/09/2023
*/

package object Circuitos {
  type Chip = List[Int] => List[Int]

  def crearChipUnario(funcion: Int => Int): Chip = {
    def chip(lista: List[Int]) = List(funcion(lista.head))
    chip
  }

  def crearChipBinario (funcion:(Int,Int) => Int): Chip = {
    def Chip(lista: List[Int]): List[Int] = List(funcion(lista.head, lista.tail.head))
    Chip
  }

}
