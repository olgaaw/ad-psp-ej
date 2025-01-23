package com.salesianostriana.__bicicleta.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "uso")
public class Uso {

    @Id @GeneratedValue
    private Long id;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    private double coste;

    @ManyToOne
    @JoinColumn(name = "usuario_id",
                foreignKey = @ForeignKey(name = "fk_usuario_uso"))
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "bicicleta_id",
                foreignKey = @ForeignKey(name = "fk_bicicleta_uso"))
    private Bicicleta bicicleta;

    @ManyToOne
    @JoinColumn(name = "estacion_id",
            foreignKey = @ForeignKey(name = "fk_estacion_uso"))
    private Estacion estacion;


    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Uso uso = (Uso) o;
        return getId() != null && Objects.equals(getId(), uso.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
