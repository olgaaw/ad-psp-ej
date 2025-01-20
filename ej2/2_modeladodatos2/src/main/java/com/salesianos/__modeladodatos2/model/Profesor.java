package com.salesianos.__modeladodatos2.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "profesor")
public class Profesor {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nombre;

    @Column
    private String email;

    @Column
    private double puntuacion;

    @OneToMany (mappedBy = "profesor", fetch = FetchType.EAGER)
    @Builder.Default
    @ToString.Exclude
    private List<CursoOnline> cursos = new ArrayList<>();



    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Profesor profesor = (Profesor) o;
        return getId() != null && Objects.equals(getId(), profesor.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
