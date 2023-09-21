package object Circuitos {
  type Chip = List[Int] => List[Int]

  def crearChipUnario(funcion: Int => Int): Chip = {
    def chip(lista: List[Int]) = List(funcion(lista.head))
    chip
  }

}
