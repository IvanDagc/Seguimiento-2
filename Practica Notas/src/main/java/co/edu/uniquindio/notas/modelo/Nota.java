package co.edu.uniquindio.notas.modelo;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor

public class Nota {
    private String titulo;
    private String descripcion;
    private LocalDateTime fechaCreacion;
    private String categoria;
    private LocalDate recordatorio;

}