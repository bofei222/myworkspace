package corejava.jiekou.staticInnerClass;

/**
 * 
 * @author bofei
 *
 */
public class StaticInnerClassTest {
	public static void main(String[] args) {
		double[] d = new double[20];
		for(int i=0;i<d.length;i++)
			d[i]=100*Math.random();
		ArrayAlg.Pair p =ArrayAlg.minmax(d);
		System.out.println("min= "+p.getFirst());
		System.out.println("max= "+p.getSecond());
	}
}

class ArrayAlg{
	/**
	 * A pair of floating-point numbers
	 */
	public static class Pair{
		private double first;
		private double second;
		
		public Pair(double f,double s){
			first=f;
			second=s;
		}
		
		public double getFirst(){
			return first;
		}
		
		public double getSecond(){
			return second;
		}
	}
	/**
	 * 
	 */
	public static Pair minmax(double[] values){
		double min =Double.MAX_VALUE;
		double max =Double.MIN_VALUE;
		for(double v : values){
			if(min>v) min=v;
			if(max<v) max=v;
		}
		return new Pair(min,max);
	}
}