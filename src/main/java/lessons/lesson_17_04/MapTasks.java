package lessons.lesson_17_04;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTasks {
    public static void main(String[] args) {
        List<Figure> figures = FigureGenerator.generateFigures();

        for (Figure figure : figures) {
            System.out.println(figure);
        }

        System.out.println(countCirclesOfColor(figures));
        System.out.println(sumOfRadiiForColor(figures));
        System.out.println(findRectangleWithLargestDiagonalToPerimeterRatio(figures));
        System.out.println(hasRectangleAndTriangleOfSameColor(figures));
        System.out.println(findCirclesWithRadiusEqualToTriangleSide(figures));
    }

    //Count circles of a given color:
    public static Map<Color, Integer> countCirclesOfColor(List<Figure> figures) {
        Map<Color, Integer> colorCount = new HashMap<>();

        for (Figure figure: figures) {
            if(figure instanceof Circle circle) {
                Color color = circle.getColor();

                colorCount.put(circle.getColor(), colorCount.getOrDefault(color, 0) + 1);
            }
        }
        return colorCount;
    }

    //Sum of radius for circles of a certain color:
    public static Map<Color, Integer> sumOfRadiiForColor(List<Figure> figures) {
        Map<Color, Integer> radiusSum = new HashMap<>();
        for (Figure figure: figures) {
            if(figure instanceof Circle circle) {
                Color color = circle.getColor();

                radiusSum.put(circle.getColor(), radiusSum.getOrDefault(color, 0) + 1);
            }
        }

        return radiusSum;
    }

    //Find the rectangle with the largest diagonal to perimeter ratio:
    public static Map<Rectangle, Double> findRectangleWithLargestDiagonalToPerimeterRatio(List<Figure> figures) {
        Map<Rectangle, Double> rectangleRatios = new HashMap<>();
        Rectangle rectangleMax = null;
        double maxRatio = 0;
        for (Figure figure: figures) {
            if(figure instanceof Rectangle rectangle) {
                int perimeter = (rectangle.getHight() * 2) + (rectangle.getWidth() * 2);
                int diagonal = (rectangle.getHight() * rectangle.getHight()) + (rectangle.getWidth() * rectangle.getWidth());

                double ratio =(double) diagonal / perimeter;

                if(rectangleMax == null) {
                    rectangleMax = rectangle;
                    maxRatio = ratio;
                } else if(maxRatio < ratio) {
                    rectangleMax = rectangle;
                    maxRatio = ratio;
                }
            }
        }

        rectangleRatios.put(rectangleMax,  maxRatio);

        return rectangleRatios;
    }

    //Find circles with radius equal to any triangle side:
    public static Map<Circle, Boolean> findCirclesWithRadiusEqualToTriangleSide(List<Figure> figures) {
        Map<Circle, Boolean> circles = new HashMap<>();

        for (Figure figure : figures) {
            if (figure instanceof Circle circle) {
                for (Figure figure1 : figures) {
                    if (figure1 instanceof Triangle triangle) {
                        int radius = circle.getRadius();

                        if (radius == triangle.getSide1() ||
                            radius == triangle.getSide2() ||
                            radius == triangle.getSide3()) {
                            circles.put(circle, true);
                        } else {
                            circles.put(circle, false);
                        }
                    }
                }
            }
        }


        return circles;
    }

    //Determine if there's a rectangle and triangle of the same color:
    public static Map<Color, Boolean> hasRectangleAndTriangleOfSameColor(List<Figure> figures) {
        Map<Color, Boolean> matches = new HashMap<>();
        for (Figure figure: figures) {
            if (figure instanceof Rectangle currentRectangle) {
                for (Figure figure1 : figures) {
                    if (figure1 instanceof Triangle currentTriangle) {
                        if (currentTriangle.getColor().equals(currentRectangle.getColor())) {
                            matches.put(currentTriangle.getColor(), true);
                        }
                    }
                }
            }
        }
        return matches;
    }
}
