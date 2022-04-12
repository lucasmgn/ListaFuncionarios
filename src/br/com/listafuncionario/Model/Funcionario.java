package br.com.listafuncionario.Model;

public class Funcionario {
    private String nome;
    private int listagem;
    private String dataNascimento;
    private String cargo;

    public Funcionario(String nome, int matricula, String cargo, String dataNascimento) {
        this.nome = nome;
        this.listagem = matricula;
        this.dataNascimento = dataNascimento ;
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return listagem;
    }

    public void setMatricula(int matricula) {
        this.listagem = matricula;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Funcionario: " +
                "\nNome= " + nome +
                "\nListagem = " + listagem +
                "\nCargo = " + cargo +
                "\nData de nascimento = " + dataNascimento + "\n";
    }
}

