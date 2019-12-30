import kotlin.math.PI

class Circle(color: String, var r: Double): Figure(color)
{
    override val area: Double
        get() = r * r * PI
    override val perimeter: Double
        get() = 2 * PI * r

}