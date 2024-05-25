import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Person.java
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Employee.java
class Employee extends Person {
    private String employeeId;
    private String department;

    public Employee(String name, int age, String employeeId, String department) {
        super(name, age);
        this.employeeId = employeeId;
        this.department = department;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void displayEmployeeInfo() {
        displayInfo();
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Department: " + department);
    }
}

// Manager.java
class Manager extends Employee {
    private int teamSize;

    public Manager(String name, int age, String employeeId, String department, int teamSize) {
        super(name, age, employeeId, department);
        this.teamSize = teamSize;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public void displayManagerInfo() {
        displayEmployeeInfo();
        System.out.println("Team Size: " + teamSize);
    }
}

// Developer.java
class Developer extends Employee {
    private String programmingLanguage;

    public Developer(String name, int age, String employeeId, String department, String programmingLanguage) {
        super(name, age, employeeId, department);
        this.programmingLanguage = programmingLanguage;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public void displayDeveloperInfo() {
        displayEmployeeInfo();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}

// HRManager.java
class HRManager extends Manager {
    private int numberOfRecruitments;

    public HRManager(String name, int age, String employeeId, String department, int teamSize, int numberOfRecruitments) {
        super(name, age, employeeId, department, teamSize);
        this.numberOfRecruitments = numberOfRecruitments;
    }

    public int getNumberOfRecruitments() {
        return numberOfRecruitments;
    }

    public void setNumberOfRecruitments(int numberOfRecruitments) {
        this.numberOfRecruitments = numberOfRecruitments;
    }

    public void displayHRManagerInfo() {
        displayManagerInfo();
        System.out.println("Number of Recruitments: " + numberOfRecruitments);
    }
}

// TechnicalLead.java
class TechnicalLead extends Developer {
    private int numOfProjects;

    public TechnicalLead(String name, int age, String employeeId, String department, String programmingLanguage, int numOfProjects) {
        super(name, age, employeeId, department, programmingLanguage);
        this.numOfProjects = numOfProjects;
    }

    public int getNumOfProjects() {
        return numOfProjects;
    }

    public void setNumOfProjects(int numOfProjects) {
        this.numOfProjects = numOfProjects;
    }

    public void displayTechnicalLeadInfo() {
        displayDeveloperInfo();
        System.out.println("Number of Projects: " + numOfProjects);
    }
}

// Intern.java
class Intern extends Employee {
    private int internshipDuration; // in months
    private String mentor;

    public Intern(String name, int age, String employeeId, String department, int internshipDuration, String mentor) {
        super(name, age, employeeId, department);
        this.internshipDuration = internshipDuration;
        this.mentor = mentor;
    }

    public int getInternshipDuration() {
        return internshipDuration;
    }

    public void setInternshipDuration(int internshipDuration) {
        this.internshipDuration = internshipDuration;
    }

    public String getMentor() {
        return mentor;
    }

    public void setMentor(String mentor) {
        this.mentor = mentor;
    }

    public void displayInternInfo() {
        displayEmployeeInfo();
        System.out.println("Internship Duration: " + internshipDuration + " months");
        System.out.println("Mentor: " + mentor);
    }
}

// ProjectManager.java
class ProjectManager extends Manager {
    private String projectName;

    public ProjectManager(String name, int age, String employeeId, String department, int teamSize, String projectName) {
        super(name, age, employeeId, department, teamSize);
        this.projectName = projectName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void displayProjectManagerInfo() {
        displayManagerInfo();
        System.out.println("Project Name: " + projectName);
    }
}

// SeniorHRManager.java
class SeniorHRManager extends HRManager {
    private int numberOfHRTeams;

    public SeniorHRManager(String name, int age, String employeeId, String department, int teamSize, int numberOfRecruitments, int numberOfHRTeams) {
        super(name, age, employeeId, department, teamSize, numberOfRecruitments);
        this.numberOfHRTeams = numberOfHRTeams;
    }

    public int getNumberOfHRTeams() {
        return numberOfHRTeams;
    }

    public void setNumberOfHRTeams(int numberOfHRTeams) {
        this.numberOfHRTeams = numberOfHRTeams;
    }

    public void displaySeniorHRManagerInfo() {
        displayHRManagerInfo();
        System.out.println("Number of HR Teams: " + numberOfHRTeams);
    }
}

// WorkerThread.java
class WorkerThread implements Runnable {
    private String taskName;

    public WorkerThread(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(taskName + " is starting.");
        try {
            Thread.sleep((int)(Math.random() * 5000)); // Simulate complex task
        } catch (InterruptedException e) {
            System.out.println(taskName + " was interrupted.");
        }
        System.out.println(taskName + " is completed.");
    }
}

// EmployeeManager.java
class EmployeeManager {
    private List<Employee> employees;

    public EmployeeManager() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added: " + employee.getName());
    }

    public void displayAllEmployees() {
        System.out.println("All Employees:");
        for (Employee employee : employees) {
            if (employee instanceof SeniorHRManager) {
                ((SeniorHRManager) employee).displaySeniorHRManagerInfo();
            } else if (employee instanceof HRManager) {
                ((HRManager) employee).displayHRManagerInfo();
            } else if (employee instanceof ProjectManager) {
                ((ProjectManager) employee).displayProjectManagerInfo();
            } else if (employee instanceof Manager) {
                ((Manager) employee).displayManagerInfo();
            } else if (employee instanceof TechnicalLead) {
                ((TechnicalLead) employee).displayTechnicalLeadInfo();
            } else if (employee instanceof Developer) {
                ((Developer) employee).displayDeveloperInfo();
            } else if (employee instanceof Intern) {
                ((Intern) employee).displayInternInfo();
            } else {
                employee.displayEmployeeInfo();
            }
            System.out.println();
        }
    }

    public Employee findEmployeeById(String employeeId) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId().equals(employeeId)) {
                return employee;
            }
        }
        return null;
    }

    public void updateEmployee(String employeeId, String name, int age, String department) {
        Employee employee = findEmployeeById(employeeId);
        if (employee != null) {
            employee.setName(name);
            employee.setAge(age);
            employee.setDepartment(department);
            System.out.println("Employee updated: " + employee.getName());
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void removeEmployee(String employeeId) {
        Employee employee = findEmployeeById(employeeId);
        if (employee != null) {
            employees.remove(employee);
            System.out.println("Employee removed: " + employee.getName());
        } else {
            System.out.println("Employee not found.");
        }
    }
}

// Main.java
public class Board {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager();

        while (true) {
            System.out.println("\nEmployee Management System:");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Remove Employee");
            System.out.println("5. Simulate Concurrency");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter employee ID: ");
                    String employeeId = scanner.nextLine();
                    System.out.print("Enter department: ");
                    String department = scanner.nextLine();
                    System.out.print("Is this employee a manager? (yes/no): ");
                    String isManager = scanner.nextLine();
                    if (isManager.equalsIgnoreCase("yes")) {
                        System.out.print("Enter team size: ");
                        int teamSize = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Is this manager an HR manager? (yes/no): ");
                        String isHRManager = scanner.nextLine();
                        if (isHRManager.equalsIgnoreCase("yes")) {
                            System.out.print("Enter number of recruitments: ");
                            int numberOfRecruitments = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            System.out.print("Is this HR manager a senior HR manager? (yes/no): ");
                            String isSeniorHRManager = scanner.nextLine();
                            if (isSeniorHRManager.equalsIgnoreCase("yes")) {
                                System.out.print("Enter number of HR teams: ");
                                int numberOfHRTeams = scanner.nextInt();
                                scanner.nextLine(); // Consume newline
                                SeniorHRManager seniorHRManager = new SeniorHRManager(name, age, employeeId, department, teamSize, numberOfRecruitments, numberOfHRTeams);
                                manager.addEmployee(seniorHRManager);
                            } else {
                                HRManager hrManager = new HRManager(name, age, employeeId, department, teamSize, numberOfRecruitments);
                                manager.addEmployee(hrManager);
                            }
                        } else {
                            System.out.print("Is this manager a project manager? (yes/no): ");
                            String isProjectManager = scanner.nextLine();
                            if (isProjectManager.equalsIgnoreCase("yes")) {
                                System.out.print("Enter project name: ");
                                String projectName = scanner.nextLine();
                                ProjectManager projectManager = new ProjectManager(name, age, employeeId, department, teamSize, projectName);
                                manager.addEmployee(projectManager);
                            } else {
                                Manager mgr = new Manager(name, age, employeeId, department, teamSize);
                                manager.addEmployee(mgr);
                            }
                        }
                    } else {
                        System.out.print("Is this employee a developer? (yes/no): ");
                        String isDeveloper = scanner.nextLine();
                        if (isDeveloper.equalsIgnoreCase("yes")) {
                            System.out.print("Enter programming language: ");
                            String programmingLanguage = scanner.nextLine();
                            System.out.print("Is this developer a technical lead? (yes/no): ");
                            String isTechnicalLead = scanner.nextLine();
                            if (isTechnicalLead.equalsIgnoreCase("yes")) {
                                System.out.print("Enter number of projects: ");
                                int numOfProjects = scanner.nextInt();
                                scanner.nextLine(); // Consume newline
                                TechnicalLead techLead = new TechnicalLead(name, age, employeeId, department, programmingLanguage, numOfProjects);
                                manager.addEmployee(techLead);
                            } else {
                                Developer dev = new Developer(name, age, employeeId, department, programmingLanguage);
                                manager.addEmployee(dev);
                            }
                        } else {
                            System.out.print("Is this employee an intern? (yes/no): ");
                            String isIntern = scanner.nextLine();
                            if (isIntern.equalsIgnoreCase("yes")) {
                                System.out.print("Enter internship duration (in months): ");
                                int internshipDuration = scanner.nextInt();
                                scanner.nextLine(); // Consume newline
                                System.out.print("Enter mentor name: ");
                                String mentor = scanner.nextLine();
                                Intern intern = new Intern(name, age, employeeId, department, internshipDuration, mentor);
                                manager.addEmployee(intern);
                            } else {
                                Employee emp = new Employee(name, age, employeeId, department);
                                manager.addEmployee(emp);
                            }
                        }
                    }
                    break;
                case 2:
                    manager.displayAllEmployees();
                    break;
                case 3:
                    System.out.print("Enter employee ID to update: ");
                    employeeId = scanner.nextLine();
                    System.out.print("Enter new name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter new age: ");
                    age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new department: ");
                    department = scanner.nextLine();
                    manager.updateEmployee(employeeId, name, age, department);
                    break;
                case 4:
                    System.out.print("Enter employee ID to remove: ");
                    employeeId = scanner.nextLine();
                    manager.removeEmployee(employeeId);
                    break;
                case 5:
                    Thread thread1 = new Thread(new WorkerThread("Task 1"));
                    Thread thread2 = new Thread(new WorkerThread("Task 2"));
                    Thread thread3 = new Thread(new WorkerThread("Task 3"));

                    thread1.start();
                    thread2.start();
                    thread3.start();

                    try {
                        thread1.join();
                        thread2.join();
                        thread3.join();
                    } catch (InterruptedException e) {
                        System.out.println("Main thread was interrupted.");
                    }

                    System.out.println("All tasks are completed.");
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
