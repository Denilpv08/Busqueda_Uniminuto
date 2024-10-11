import java.util.ArrayList;
import java.util.List;

class ListaEmpleados {

    public ListaEmpleados() {
        this.empleados = new ArrayList<>();  // Se inicializa la lista
    }

    Nodo cabeza = null;
    private List<Empleado> empleados;

    // Método para agregar un empleado a la lista
    public void agregarEmpleado(Empleado emp) {
        Nodo nuevo = new Nodo(emp);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    // Método para imprimir la lista
    public void imprimirLista() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.println(actual.empleado);
            actual = actual.siguiente;
        }
    }

    // Método para ordenar la lista por salario utilizando Bubble Sort
    public void ordenarPorSalario() {
        if (cabeza == null) return;
        Nodo actual;
        Nodo indice;
        Empleado temp;
        for (actual = cabeza; actual.siguiente != null; actual = actual.siguiente) {
            for (indice = actual.siguiente; indice != null; indice = indice.siguiente) {
                if (actual.empleado.salario > indice.empleado.salario) {
                    // Intercambiamos los empleados
                    temp = actual.empleado;
                    actual.empleado = indice.empleado;
                    indice.empleado = temp;
                }
            }
        }
    }

    // Búsqueda lineal por salario
    public Empleado busquedaLineal(double salario) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.empleado.salario == salario) {
                return actual.empleado;
            }
            actual = actual.siguiente;
        }
        return null; // Si no se encuentra
    }

    // Método para convertir la lista en un arreglo para búsqueda binaria
    public Empleado[] convertirEnArray() {
        int size = obtenerTamano();
        Empleado[] empleados = new Empleado[size];
        Nodo actual = cabeza;
        int i = 0;
        while (actual != null) {
            empleados[i++] = actual.empleado;
            actual = actual.siguiente;
        }
        return empleados;
    }

    // Búsqueda binaria por salario
    public Empleado busquedaBinaria(double salario) {
        Empleado[] empleados = convertirEnArray();
        int izquierda = 0, derecha = empleados.length - 1;

        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            if (empleados[medio].salario == salario) {
                return empleados[medio];
            } else if (empleados[medio].salario < salario) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }
        return null; // Si no se encuentra
    }

    // Obtener el tamaño de la lista
    public int obtenerTamano() {
        int tamano = 0;
        Nodo actual = cabeza;
        while (actual != null) {
            tamano++;
            actual = actual.siguiente;
        }
        return tamano;
    }
}
