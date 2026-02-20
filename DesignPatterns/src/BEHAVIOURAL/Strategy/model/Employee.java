package BEHAVIOURAL.Strategy.model;

public class Employee {
    private int id;
    private String name;
    private Role role;

    public Employee(int id, String name, Role role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void printResponsibilities(){
        for(Responsibility responsibility:this.role.getResponsibilities()){
            System.out.println(responsibility.getResponsibility());
        }
    }
}
