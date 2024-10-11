class Empleado {
    int id;
    String nombre;
    String apellido;
    String genero;
    double salario;

    public Empleado(int id, String nombre, String apellido, String genero, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.salario = salario;
    }

    // Getter para el salario
    public double getSalario() {
        return salario;
    }


    // Otros getters para los demás atributos (si son necesarios)
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getGenero() {
        return genero;
    }

    public String toString() {
        return id + " " + nombre + " " + apellido + " " + genero + " " + salario;
    }
}
