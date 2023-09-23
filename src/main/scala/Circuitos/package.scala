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

  def half_adder: Chip = {
    val chip_not = crearChipUnario((x: Int) => (1 - x))
    val chip_and = crearChipBinario((x: Int, y: Int) => (x * y))
    val chip_or = crearChipBinario((x: Int, y: Int) => x + y - (x * y))

    (lista: List[Int]) => chip_and(lista)++chip_and(chip_or(lista)++chip_not(chip_and(lista)))
  }

  def full_adder: Chip = {
    val chip_or = crearChipBinario((x: Int, y: Int) => x + y - (x * y))
    val ha1 = half_adder
    val ha2 = half_adder

    def chip(lista: List[Int]):List[Int] = {
      val cout = chip_or(ha1(lista.tail).head::ha2(lista.head::ha1(lista.tail).tail).head::Nil)
      val sum = ha2(lista.head::ha1(lista.tail).tail).tail
      cout++sum
    }

    chip
  }

  def adder(n:Int): Chip = {
    def chip(lista: List[Int]): List[Int] = {
      val fa = full_adder
      val lista1 = lista.take(n)
      val lista2 = lista.drop(n)

      def add(k:Int, l1:List[Int], l2:List[Int], c:Int):List[Int] = {
        if (k < n) {
          add(k+1,l1.init,l2.init,fa(l1.last::l2.last::c::Nil).head)++fa(l1.last::l2.last::c::Nil).tail
        }
        else
          c::Nil
      }
      add(0,lista1,lista2,0)
    }
    chip
  }
}

