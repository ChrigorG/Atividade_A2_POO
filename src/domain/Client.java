package domain;

public class Client extends BaseDomain {
    
    private String Name;
    private String CPF;
    private String Email;
    private String Phone;

    
    public Client() {
    }

    public Client(int id, String name, String cpf, String email, String phone) {
        Id = id;
        Name = name;
        CPF = cpf;
        Email = email;
        Phone = phone;
    }

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getCPF() {
        return CPF;
    }
    public void setCPF(String cPF) {
        CPF = cPF;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public String getPhone() {
        return Phone;
    }
    public void setPhone(String phone) {
        Phone = phone;
    }
}
