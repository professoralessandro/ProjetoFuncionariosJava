public class Funcionario
{
    //ATRIBUTOS
    private int id;
    private String nome;
    private Double salario;
    private String cargo; 

    //CONSTRUTORES
    public Funcionario(int id, String nome, Double salario, String cargo) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
        this.cargo = cargo;
    }
    
    public Funcionario(String nome, Double salario, String cargo) {
        this.nome = nome;
        this.salario = salario;
        this.cargo = cargo;
    }
    
    public Funcionario()
    {
        this.id = 0;
        this.nome = "";
        this.salario = 0.00;
        this.cargo = "";
    }
    //CONSTRUTORES
    
    //PROPRIEDADES
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    //PROPRIEDADES
    
    //METODOS
    /*
    public String dados()
    {
        return "Nome: " this.nome + "Salário: "+ this.salario.toString(); + "Cargo: " + this.cargo;
    }*/
}//CLASS