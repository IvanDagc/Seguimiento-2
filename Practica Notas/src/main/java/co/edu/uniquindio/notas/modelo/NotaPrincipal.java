package co.edu.uniquindio.notas.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class NotaPrincipal {

    private final ArrayList<Nota> notas;
    public NotaPrincipal() {
        this.notas = new ArrayList<>();
    }

    public void agregarNota(String titulo, String descripcion, String categoria, LocalDate value) throws IllegalArgumentException {
        if (titulo.isEmpty() || descripcion.isEmpty() || categoria.isEmpty()) {
            throw new IllegalArgumentException("Todos los campos son obligatorios");
        }
        Nota nota = Nota.builder()
                .titulo(titulo)
                .descripcion(descripcion)
                .fechaCreacion(LocalDateTime.now())
                .categoria(categoria)
                .build();
        notas.add(nota);
    }

    public void actualizarNota(String titulo, String descripcion, String categoria) throws IllegalArgumentException {

    }
    public void eliminarNota(String titulo) throws IllegalArgumentException {

    }


    public ArrayList<String> listarCategorias () {
        ArrayList<String> categorias = new ArrayList<>();
        categorias.add("Trabajo");
        categorias.add("Estudio");
        categorias.add("Personal");

        return categorias;
    }

    public ArrayList<Nota> listarNotas() throws Exception{
        return notas;

    }
}