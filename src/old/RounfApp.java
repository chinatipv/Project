package old;

public class RounfApp {
public static void main(String[] args){
	Round r = new Round(new Theater(new int[]{3,5,4},8, 3, new double[]{1,200,3},new String[]{"regular","premium","honeymoon"}),new Time(20, 30, 0),new Time(23,00,00),new Movie());
	System.out.println(r.getSeatInString(2, 0 ,1));
	System.out.println(r.convert(10, 0));
}
}
