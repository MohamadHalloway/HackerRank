import java.util.*;

class Student implements Comparable<Student>{
	private int id;
	private String fname;
	private double cgpa;
    private final double epsilon = 0.000001d;
	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}
    
    @Override
    public int compareTo(Student o) {
        if (Math.abs(cgpa - o.getCgpa()) < epsilon) {
            if (fname.equals(o.getFname())) return o.getId() - id;
            return fname.compareTo(o.getFname());
        }
        return cgpa < o.getCgpa() ? 1 : -1;
    }
}

//Complete the code
public class Solution
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		
		List<Student> studentList = new ArrayList<Student>();
		while(testCases>0){
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();
			
			Student st = new Student(id, fname, cgpa);
			studentList.add(st);
			
			testCases--;
		}
        
        Collections.sort(studentList);
      
      	for(Student st: studentList){
			System.out.println(st.getFname());
		}
	}
}

