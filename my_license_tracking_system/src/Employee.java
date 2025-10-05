public class Employee {
    //Propriedades (atributos)
    private int employeeId;
    private String name;
    private String department;
    private String email;

    //Constructor padrão
    public Employee(){
        this.employeeId = 0;
        this.name = "";
        this.department = "";
        this.email = "";
    }
    //Constructor com parâmetros
    public Employee(int employeeId, String name, String department, String email) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.email = email;
    }

    // Métodos vão ser adicionados aqui.
    private int leaveBalance = 20; // Saldo de férias

    // Getter
    public int getLeaveBalance() {
        return leaveBalance;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    //Setter
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Setter com validação
    public void setLeaveBalance(int leaveBalance) {
        if (leaveBalance >= 0) {
            this.leaveBalance = leaveBalance;
        } else {
            System.out.println("Saldo de férias não pode ser negativo.");
        }
    }

    //Calcula o saldo restante da licença após uma solicitação
    public int requestLeave(int daysRequested) {
        if (daysRequested <= leaveBalance && daysRequested > 0) {
            leaveBalance -= daysRequested;
            System.out.println("Licença aprovada. Saldo restante: " + leaveBalance + " dias.");
            return leaveBalance;
        } else {
            System.out.println("Solicitação de licença negada. Saldo insuficiente ou dias inválidos.");
            return leaveBalance;
        }
    }
}
