import java.util.*;

class Points implements Comparable<Points>{
    int x,y;
    Points(){
        this.x = 0 ;
        this.y = 0;
    }
    Points(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Points p) {
        return this.x - p.x ;
    }
}

public class SortItems {
    public static void main(String[] args) {
        List<Points> pointsList = new ArrayList<>();
        pointsList.add(new Points(1,2));
        pointsList.add(new Points(13,10));
        pointsList.add(new Points(7,21));
        pointsList.add(new Points(10,22));
        pointsList.add(new Points(2,50));
        for(Points p : pointsList){
            System.out.println("X: "+p.x +" Y: "+p.y);
        }
        Collections.sort(pointsList);
        for(Points p : pointsList){
            System.out.println("X: "+p.x +" Y: "+p.y);
        }
        String [] names = new String[]{"James", "Alpha", "Delta", "Sierra", "Siva", "Plastic", "Dave", "Ignatius", "Phoenix", "Bear", "Gamma    "};
        List<String> namesList = Arrays.asList(names);
        Collections.sort(namesList , Comparator.comparing((String p) -> p.length()).thenComparing(Comparator.naturalOrder()));
        namesList.stream().forEach(e -> System.out.println(e));
    }
}
