class Square (color: String, var a: Double): Figure(color), IDrawable
{
    override val area: Double
        get() = a * a
    override val perimeter: Double
        get() = 4 * a

    override fun draw()
    {
        println("square")
    }
}