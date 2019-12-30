import kotlin.math.sqrt

class Triangle(color: String, var a: Double, var b: Double, var c: Double) : Figure(color), IDrawable
{
    var p = (a + b + c)/2
    override val area: Double
        get() = sqrt(p * (p - a) * (p - b) * (p - c))
    override val perimeter: Double
        get() = a + b + c

    override fun draw()
    {
        println("triangle")
    }
}