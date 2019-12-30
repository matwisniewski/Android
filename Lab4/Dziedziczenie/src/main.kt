fun main()
{
    var square = Square("black", 4.0)
    var rectangle = Rectangle("black", 6.0, 7.0)
    var triangle = Triangle("black", 4.0,6.0,6.0)
    var circle = Circle("black", 3.0)

    var List_Figures = listOf<Figure>(square, rectangle, triangle, circle)

    List_Figures.forEach {
        if(it is IDrawable)
        {
            print("Is drawable: ")
            it.draw()
        }
        print("Area is: ${it.area} \nPerimeter is: ${it.perimeter}\n")
    }
}