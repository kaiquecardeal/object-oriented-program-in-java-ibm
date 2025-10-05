import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LeaveRequest {
    private int requestId;
    private Employee employee;
    private String startDate;
    private String endDate;
    private String status; // "Pentede", "Aprovado" ou "Negado"
    private String reason;

    //Constructor sobrecarregado
    public LeaveRequest(int requestId, Employee employee, String startDate, String endDate, String status, String reason) {
        this.requestId = requestId;
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.reason = reason;
    }

    //Constructor com parâmetros
    public LeaveRequest(int requestId, Employee employee, String startDate, String endDate, String reason) {
        this.requestId = requestId;
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = "Pendente"; // Status padrão
        this.reason = reason;
    }

    // Getters

    public int getRequestId() {
        return requestId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getStatus() {
        return status;
    }

    public String getReason() {
        return reason;
    }

    // Setters
    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    //Métodos serão adicionados aqui

    // Métodos para calcular dias de licença solicitados
    public int calculateRequestedDays() {
        // Implementação básica usando LocalDate
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return (int) ChronoUnit.DAYS.between(start, end) + 1; // +1 para incluir o dia final
    }


}
