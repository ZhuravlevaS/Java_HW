package lessons.lesson_17_04;

import java.util.ArrayList;
import java.util.List;


public class FigureTasks {
    public static void main(String[] args) {
        List<Figure> figures = FigureGenerator.generateFigures();

        for (Figure figure : figures) {
            System.out.println(figure);
        }

        System.out.println("******************");

        //System.out.println(countCirclesOfColor(figures, Color.BLUE));
        //System.out.println(findRectangleWithMaxArea(figures));

        //printEquilateralTriangles(figures);
        //System.out.println(sumOfRadiiForColor(figures, Color.BLUE));
        //System.out.println(hasRectangleAndTriangleOfSameColor(figures));
        //System.out.println(countTrianglesWithSideGreaterThan(figures, 70));

        System.out.println(findCirclesWithRadiusEqualToTriangleSide(figures));
    }

    // ****************** Basic Tasks ******************

    /**
     * 1. Напишите метод для подсчета всех кругов заданного цвета в списке фигур.
     */
    public static int countCirclesOfColor(List<Figure> figures, Color color) {
        int count = 0;

        for (Figure figure : figures) {
            if (figure instanceof Circle && ((Circle) figure).getColor() == color) {
                count++;
            }
        }
        return count;
    }

    /**
     * 2. Напишите метод для нахождения прямоугольника с максимальной площадью.
     */
    public static Rectangle findRectangleWithMaxArea(List<Figure> figures) {
        Rectangle rectangle = null;

        for (Figure figure : figures) {
            if (figure instanceof Rectangle current) {
                if (rectangle == null) {
                    rectangle = current;
                } else {
                    int currentSquare = current.getHight() * current.getWidth();
                    int square = rectangle.getHight() * rectangle.getWidth();
                    if (currentSquare > square) {
                        rectangle = current;
                    }
                }
            }
        }
        return rectangle;
    }

    /**
     * 3. Напишите метод для вывода всех треугольников, у которых все стороны равны.
     */
    public static void printEquilateralTriangles(List<Figure> figures) {
        for (Figure figure : figures) {
            if (figure instanceof Triangle &&
                    ((Triangle) figure).getSide1() == ((Triangle) figure).getSide2() &&
                    ((Triangle) figure).getSide2() == ((Triangle) figure).getSide3()) {
                System.out.println(figure);
            }
        }
    }

    /**
     * 4. Напишите метод для нахождения суммы радиусов всех кругов определенного цвета.
     */
    public static int sumOfRadiiForColor(List<Figure> figures, Color color) {
        int count = 0;

        for (Figure figure : figures) {
            if (figure instanceof Circle && ((Circle) figure).getColor() == color) {
                count += ((Circle) figure).getRadius();
            }
        }
        return count;
    }

    /**
     * 5. Напишите метод для определения, есть ли в списке фигур прямоугольник и треугольник одинакового цвета.
     */
    public static boolean hasRectangleAndTriangleOfSameColor(List<Figure> figures) {

        for (Figure figure : figures) {
            if (figure instanceof Rectangle) {
                for (Figure figure1 : figures) {
                    if (figure1 instanceof Triangle currentTriangle) {
                        Rectangle currentRectangle = (Rectangle) figure;

                        if (currentTriangle.getColor() == currentRectangle.getColor()) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    // ****************** Intermediate Tasks ******************

    /**
     * 6. Напишите метод для нахождения круга с минимальным радиусом среди кругов заданного цвета.
     */
    public static Circle findCircleWithMinRadiusOfColor(List<Figure> figures, Color color) {
        Circle minRadiusCircle = null;
        for (Figure figure : figures) {
            if (figure instanceof Circle && ((Circle) figure).getColor() == color) {
                Circle circle = (Circle) figure;
                if (minRadiusCircle == null) {
                    minRadiusCircle = circle;
                } else if (minRadiusCircle.getRadius() > circle.getRadius()) {
                    minRadiusCircle = circle;
                }
            }
        }
        return minRadiusCircle;
    }

    /**
     * 7. Напишите метод для подсчета треугольников, у которых хотя бы одна сторона больше заданного значения.
     */
    public static int countTrianglesWithSideGreaterThan(List<Figure> figures, int length) {
        int count = 0;

        for (Figure figure : figures) {
            if (figure instanceof Triangle) {
                Triangle triangle = (Triangle) figure;

                if (triangle.getSide1() > length || triangle.getSide2() > length || triangle.getSide3() > length) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 8. Напишите метод для нахождения всех кругов,
     * у которых радиус равен любой из сторон любого треугольника.
     */
    public static List<Circle> findCirclesWithRadiusEqualToTriangleSide(List<Figure> figures) {
        List<Circle> circleList = new ArrayList<>();

        for (Figure figure : figures) {
            if (figure instanceof Circle) {
                for (Figure figure1 : figures) {
                    if (figure1 instanceof Triangle) {
                        Circle circle = (Circle) figure;
                        Triangle triangle = (Triangle) figure1;

                        int radius = circle.getRadius();

                        if (radius == triangle.getSide1() ||
                            radius == triangle.getSide2() ||
                            radius == triangle.getSide3()) {
                            circleList.add(circle);
                        }
                    }
                }
            }
        }

        return circleList;
    }

    // ****************** Upper Intermediate Tasks ******************

    /**
     * 9. Напишите метод для нахождения треугольника, у которого разница между
     * максимальной и минимальной сторонами минимальна среди всех треугольников.
     */
    public static Triangle findTriangleWithSmallestSideDifference(List<Figure> figures) {
        Triangle minDifftriangle = null;
        int difference = 0;

        for (Figure figure : figures) {
            if (figure instanceof Triangle) {
                Triangle current = (Triangle) figure;
                if (minDifftriangle == null) {
                    minDifftriangle = current;
                    difference = getDiffMaxMinSidesTriangle(current);
                } else {
                    int currentDiff = getDiffMaxMinSidesTriangle(current);
                    if(difference > currentDiff) {
                        minDifftriangle = current;
                        difference = currentDiff;
                    }
                }
            }
        }

        return minDifftriangle;
    }

    private static int getDiffMaxMinSidesTriangle(Triangle triangle) {
        int min = Math.min(Math.min(triangle.getSide1(), triangle.getSide2()), triangle.getSide3());
        int max = Math.max(Math.max(triangle.getSide1(), triangle.getSide2()), triangle.getSide3());
        return max - min;
    }

    /**
     * 10. Напишите метод для вывода всех фигур, у которых хотя бы один параметр
     * (цвет, радиус, сторона) совпадает с аналогичным параметром другой фигуры.
     */
    public static void printFiguresWithAtLeastOneMatchingParameter(List<Figure> figures) {
    }

    // Helper method to determine if two figures have at least one matching parameter
    private static boolean figuresMatch(Figure a, Figure b) {
        return false;
    }

    /**
     * 11. Напишите метод для нахождения кругов, у которых радиус больше суммы сторон любого треугольника в списке.
     */
    public static List<Circle> findCirclesWithRadiusGreaterThanSumOfAnyTriangleSides(List<Figure> figures) {

        return null;
    }

    // ****************** Advanced Tasks ******************

    /**
     * 12. Напишите метод для нахождения круга, который можно вписать в
     * наибольшее количество треугольников, учитывая их углы и стороны.
     */
    public static Circle findCircleThatFitsMostTriangles(List<Figure> figures) {
        return null;
    }


    /**
     * 13. Напишите метод для определения треугольника с наименьшим углом, вписывающимся в заданный круг.
     */
    public static Triangle findSmallestAngleTriangleInCircle(Circle circle, List<Figure> figures) {
        return null;
    }

    // ****************** Expert Tasks ******************

    /**
     * 14. Напишите метод для определения круга,
     * у которого соотношение площади к радиусу является наименьшим среди всех кругов.
     */
    public static Circle findCircleWithSmallestAreaToRadiusRatio(List<Figure> figures) {
        return null;
    }

    /**
     * 15. Напишите метод для определения, можно ли составить
     * из треугольников полигон без промежутков и наружных выступов.
     */
    public static boolean canFormClosedPolygonFromTriangles(List<Figure> figures) {
        return true;
    }

    /**
     * 16. Напишите метод для определения прямоугольника с наибольшим отношением диагонали к периметру.
     */
    public static Rectangle findRectangleWithLargestDiagonalToPerimeterRatio(List<Figure> figures) {
        return null;
    }

    /**
     * 17. Напишите метод для нахождения всех комбинаций фигур,
     * которые могут быть соединены таким образом, чтобы их общая площадь была равна заданному значению.
     */
    public static List<List<Figure>> findFigureCombinationsMatchingArea(List<Figure> figures, int targetArea) {
        return null;
    }
}