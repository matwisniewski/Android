class Rectangle (color: String, var a: Double, var b: Double): Figure(color), IDrawable
{
    override val area: Double
        get() = a * b
    override val perimeter: Double
        get() = (2 * a) + (2 * b)

    override fun draw()
    {
        println("rectangle")
    }
}