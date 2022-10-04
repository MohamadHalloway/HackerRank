import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private int ID;
    private String name;
    private double cgpa;

    public Student(int ID, String name, double cgpa) {
        this.ID = ID;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }
}

class Priorities {

    private final double epsilon = 0.000001d;
    private List<Student> lStudents = new ArrayList<>();

    public List<Student> getStudents(List<String> events) {
        events.forEach(e -> {
            String[] arrLine = e.split(" ");
            switch (arrLine[0]) {
                case "SERVED":
                    if (!lStudents.isEmpty()) lStudents.remove(0);
                    break;
                case "ENTER":
                    lStudents.add(new Student(Integer.parseInt(arrLine[3]), arrLine[1], Double.parseDouble(arrLine[2])));
                    lStudents.sort((o1, o2) -> {
                        if (Math.abs(o1.getCgpa() - o2.getCgpa()) < epsilon) {
                            if (o1.getName().equals(o2.getName())) return o2.getID() - o1.getID();
                            return o1.getName().compareTo(o2.getName());
                        }
                        return o1.getCgpa() < o2.getCgpa() ? 1 : -1;
                    });
            }
        });
        return lStudents;
    }
}

