package edu.austral.ingsis.math.composite

import edu.austral.ingsis.math.composite.impl.Multiplication
import edu.austral.ingsis.math.composite.impl.Number
import edu.austral.ingsis.math.composite.impl.Sum

fun main(args : Array<String>){
    val myMap: MutableMap<String, Double> = mutableMapOf()
    myMap["x"] = 2.0
    myMap["y"] = 5.0

    print(Multiplication(
        Sum(
            Number(1.0),
            Number(6.0)),
        Number(2.0)).
    print())

}
