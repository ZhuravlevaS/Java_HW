package lessons.lesson_17_04;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class FigureTasks {
    public static void main(String[] args) {
        List<Figure> figures = FigureGenerator.generateFigures();

//        for (Figure figure : figures) {
//            System.out.println(figure);
//        }

        System.out.println("******************");

 //       System.out.println(countCirclesOfColor(figures, Color.BLUE));
//        System.out.println(findRectangleWithMaxArea(figures));
//
        printEquilateralTriangles(figures);
        findCircleWithMinRadiusOfColor(figures, Color.BLUE);
//        System.out.println(sumOfRadiiForColor(figures, Color.BLUE));
//        System.out.println(hasRectangleAndTriangleOfSameColor(figures));
//        System.out.println(countTrianglesWithSideGreaterThan(figures, 70));
//
//        System.out.println(findCirclesWithRadiusEqualToTriangleSide(figures));
//        printFiguresWithAtLeastOneMatchingParameter(figures);
//        System.out.println(findCirclesWithRadiusGreaterThanSumOfAnyTriangleSides(figures));
//
//        System.out.println(findCircleThatFitsMostTriangles(figures));
//        System.out.println(findSmallestAngleTriangleInCircle(new Circle(Color.BLUE, 30),figures ));
//        System.out.println(findCircleWithSmallestAreaToRadiusRatio(figures));
    }

    // ****************** Basic Tasks(DONE) ******************

    /**
     * 1. Напишите метод для подсчета всех кругов заданного цвета в списке фигур.
     */
    public static long countCirclesOfColor(List<Figure> figures, Color color) {
//        int count = 0;
//
//        for (Figure figure : figures) {
//            if (figure instanceof Circle && ((Circle) figure).getColor() == color) {
//                count++;
//            }
//        }
//        return count;

        return figures.stream()
                .filter(figure -> figure instanceof Circle && figure.getColor().equals(color))
                .peek(figure -> System.out.println(figure))
                .count();
    }

    /**
     * 2. Напишите метод для нахождения прямоугольника с максимальной площадью.
     */
    public static Rectangle findRectangleWithMaxArea(List<Figure> figures) {
//        Rectangle rectangle = null;
//
//        for (Figure figure : figures) {
//            if (figure instanceof Rectangle current) {
//                if (rectangle == null) {
//                    rectangle = current;
//                } else {
//                    int currentSquare = current.getHight() * current.getWidth();
//                    int square = rectangle.getHight() * rectangle.getWidth();
//                    if (currentSquare > square) {
//                        rectangle = current;
//                    }
//                }
//            }
//        }
//        return rectangle;

        return (Rectangle) figures.stream()
                .filter(figure -> figure instanceof Rectangle)
                .max((figure1, figure2) ->
                        (int) (((Rectangle) figure1).getSquare() - ((Rectangle) figure2).getSquare()))
                .get();


    }

    /**
     * 3. Напишите метод для вывода всех треугольников, у которых все стороны равны.
     */
    public static void printEquilateralTriangles(List<Figure> figures) {
//        for (Figure figure : figures) {
//            if (figure instanceof Triangle &&
//                    ((Triangle) figure).getSide1() == ((Triangle) figure).getSide2() &&
//                    ((Triangle) figure).getSide2() == ((Triangle) figure).getSide3()) {
//                System.out.println(figure);
//            }
//        }

        figures
                .forEach((figure) -> {
                    if (figure instanceof Triangle &&
                            ((Triangle) figure).getSide1() == ((Triangle) figure).getSide2() &&
                            ((Triangle) figure).getSide2() == ((Triangle) figure).getSide3()) {
                        System.out.println(figure);
                    }
                });
    }

    /**
     * 4. Напишите метод для нахождения суммы радиусов всех кругов определенного цвета.
     */
    public static int sumOfRadiiForColor(List<Figure> figures, Color color) {
//        int count = 0;
//
//        for (Figure figure : figures) {
//            if (figure instanceof Circle && ((Circle) figure).getColor() == color) {
//                count += ((Circle) figure).getRadius();
//            }
//        }
//        return count;

        return figures.stream()
                .filter(figure -> figure instanceof Circle && figure.getColor().equals(color))
                .mapToInt(figure -> ((Circle) figure).getRadius())
                .sum();
    }

    /**
     * 5. Напишите метод для определения, есть ли в списке фигур прямоугольник и треугольник одинакового цвета.
     */
    public static boolean hasRectangleAndTriangleOfSameColor(List<Figure> figures) {
//        for (Figure figure : figures) {
//            if (figure instanceof Rectangle currentRectangle) {
//                for (Figure figure1 : figures) {
//                    if (figure1 instanceof Triangle currentTriangle) {
//                        if (currentTriangle.getColor().equals(currentRectangle.getColor())) {
//                            return true;
//                        }
//                    }
//                }
//            }
//        }
//        return false;

        Set<Color> colors = figures.stream()
                .filter((el) -> el instanceof Rectangle)
                .map(el -> el.getColor())
                .collect(Collectors.toSet());

        return figures.stream()
                .anyMatch(el -> el instanceof Triangle && colors.contains(el.getColor()));
    }

    // ****************** Intermediate Tasks (DONE)  ******************

    /**
     * 6. Напишите метод для нахождения круга с минимальным радиусом среди кругов заданного цвета.
     */
    public static Circle findCircleWithMinRadiusOfColor(List<Figure> figures, Color color) {
        Circle minRadiusCircle = null;
        for (Figure figure : figures) {
            if (figure instanceof Circle circle && circle.getColor() == color) {
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
            if (figure instanceof Triangle triangle) {
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

    // ****************** Upper Intermediate Tasks (DONE)  ******************

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
                    if (difference > currentDiff) {
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

        for (int i = 0; i < figures.size(); i++) {
            for (int j = 0; j < figures.size(); j++) {
                if (i != j) {
                    if (figuresMatch(figures.get(i), figures.get(j))) {
                        System.out.println("фигуры совпали: ");
                        System.out.println(figures.get(i));
                        System.out.println(figures.get(j));
                    }
                }
            }
        }
    }

    // Helper method to determine if two figures have at least one matching parameter
    private static boolean figuresMatch(Figure figure1, Figure figure2) {
        if (figure1.getColor() == figure2.getColor()) {
            return true;
        }
        if (figure1 instanceof Circle) {
            int radius = ((Circle) figure1).getRadius();

            return figureParamMatch(radius, figure2);
        }
        if (figure1 instanceof Rectangle) {
            int hight = ((Rectangle) figure1).getHight();
            int width = ((Rectangle) figure1).getWidth();

            return figureParamMatch(hight, figure2) || figureParamMatch(width, figure2);
        }
        if (figure1 instanceof Triangle) {
            int side1 = ((Triangle) figure1).getSide1();
            int side2 = ((Triangle) figure1).getSide2();
            int side3 = ((Triangle) figure1).getSide3();

            return figureParamMatch(side1, figure2) ||
                    figureParamMatch(side2, figure2) ||
                    figureParamMatch(side3, figure2);

        }
        return false;
    }

    private static boolean figureParamMatch(int param, Figure figure) {
        if (figure instanceof Triangle) {
            return triangleMatch(param, (Triangle) figure);
        }
        if (figure instanceof Circle) {
            return circleMatch(param, (Circle) figure);
        }
        if (figure instanceof Rectangle) {
            return rectangleMatch(param, (Rectangle) figure);
        }
        return false;
    }


    private static boolean rectangleMatch(int param, Rectangle rectangle) {
        return param == rectangle.getHight() || param == rectangle.getWidth();
    }

    private static boolean triangleMatch(int param, Triangle triangle) {
        return param == triangle.getSide1() || param == triangle.getSide2() || param == triangle.getSide3();
    }

    private static boolean circleMatch(int param, Circle circle) {
        return param == circle.getRadius();
    }


    /**
     * 11. Напишите метод для нахождения кругов, у которых радиус больше суммы сторон любого треугольника в списке.
     */
    public static List<Circle> findCirclesWithRadiusGreaterThanSumOfAnyTriangleSides(List<Figure> figures) {
        List<Circle> circleList = new ArrayList<>();

        for (Figure figure : figures) {
            if (figure instanceof Circle) {
                boolean isRadiusBigger = true;
                int radius = ((Circle) figure).getRadius();

                for (Figure figure1 : figures) {
                    if (figure1 instanceof Triangle) {
                        int sidesSum = ((Triangle) figure1).getSide1() + ((Triangle) figure1).getSide2() + ((Triangle) figure1).getSide3();
                        if (radius < sidesSum) {
                            isRadiusBigger = false;
                            break;
                        }
                    }
                }

                if (isRadiusBigger) {
                    circleList.add((Circle) figure);
                }
            }
        }
        return circleList;
    }

    // ****************** Advanced Tasks ******************

    /**
     * 12. Напишите метод для нахождения круга, который можно вписать в
     * наибольшее количество треугольников, учитывая их углы и стороны.
     */
    public static Circle findCircleThatFitsMostTriangles(List<Figure> figures) {
        Circle circle = null;
        int countTriangles = 0;

        for (Figure figure : figures) {

            if (figure instanceof Circle) {
                Circle circleCurrent = (Circle) figure;
                int count = 0;
                Circle circleFit = null;

                for (Figure figure1 : figures) {
                    if (figure1 instanceof Triangle) {
                        Triangle triangle = (Triangle) figure1;
                        double radius = getCircleRInTriangle(triangle.getSide1(), triangle.getSide2(), triangle.getSide3());
                        System.out.println(radius);
                        if (Double.valueOf((double) circleCurrent.getRadius()).equals(radius)) {
                            circleFit = circleCurrent;
                            count++;
                        }
                    }
                }

                if (circle != null && circleFit != null && count > countTriangles) {
                    circle = circleCurrent;
                    countTriangles = count;
                } else if (circle == null && count != 0) {
                    circle = circleCurrent;
                    countTriangles = count;
                }
                count = 0;
            }

        }
        return circle;
    }

    private static double getCircleRInTriangle(int side1, int side2, int side3) {
        double p = (double) (side1 + side2 + side3) / 2;
        return Math.sqrt(((p - side1) * (p - side2) * (p - side3)) / p);

    }

    /**
     * 13. Напишите метод для определения треугольника с наименьшим углом, вписывающимся в заданный круг.
     */
    public static Triangle findSmallestAngleTriangleInCircle(Circle circle, List<Figure> figures) {
        List<Triangle> triangles = new ArrayList<>();

        Triangle minAngleTriangle = null;
        double min = 0;

        for (Figure figure : figures) {
            if (figure instanceof Triangle triangle) {

                double radius = (triangle.getSide1() * triangle.getSide2() * triangle.getSide3()) / (4 * triangle.getSquare());
                if (Double.valueOf(circle.getRadius()).equals(radius)) {
                    triangles.add(triangle);
                }
            }
        }

        if (triangles.size() == 1) {
            return triangles.get(0);
        }

        if (triangles.size() > 1) {
            for (Triangle triangle : triangles) {
                double cosA = getCos(triangle.getSide1(), triangle.getSide2(), triangle.getSide3());
                double cosB = getCos(triangle.getSide1(), triangle.getSide3(), triangle.getSide2());
                double cosC = getCos(triangle.getSide2(), triangle.getSide3(), triangle.getSide1());

                double minAngle = 0;

                if (cosA < cosB && cosA < cosC) {
                    minAngle = cosA;
                } else if (cosB < cosC) {
                    minAngle = cosB;
                } else {
                    minAngle = cosC;
                }

                if (minAngleTriangle == null) {
                    minAngleTriangle = triangle;
                    min = minAngle;
                } else if (min > minAngle) {
                    minAngleTriangle = triangle;
                    min = minAngle;
                }
            }
        }
        return minAngleTriangle;
    }

    private static double getCos(int a, int b, int c) {
        return (Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b);
    }


    // ****************** Expert Tasks ******************

    /**
     * 14. Напишите метод для определения круга,
     * у которого соотношение площади к радиусу является наименьшим среди всех кругов.
     */
    public static Circle findCircleWithSmallestAreaToRadiusRatio(List<Figure> figures) {
        Circle min = null;
        for (Figure figure : figures) {
            if (figure instanceof Circle circle) {
                if (min == null) {
                    min = circle;
                } else if (min.getSquare() / min.getRadius() > circle.getSquare() / circle.getRadius()) {
                    min = circle;
                }
            }
        }
        return min;
    }

    /**
     * 15. Напишите метод для определения, можно ли составить
     * из 2х треугольников прямоугольник или квадрат без промежутков и наружных выступов.
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