package edu.austral.ingsis.math.composite

interface Function {
    fun eval(variables: Map<String, Double>): Double
    fun print(): String
    fun list(): List<String>
}
