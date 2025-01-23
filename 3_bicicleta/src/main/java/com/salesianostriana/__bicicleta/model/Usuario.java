package com.salesianostriana.__bicicleta.model;

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
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private int numTarjeta;

    private int pin;

    private double saldo;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
    @Builder.Default
    @ToString.Exclude
    private List<Uso> usos = new ArrayList<>();

    //helpers
    public void addUso(Uso u) {
        u.setUsuario(this);
        this.getUsos().add(u);
    }

    public void removeUso(Uso u) {
        this.getUsos().remove(u);
        u.setUsuario(null);
    }



    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Usuario usuario = (Usuario) o;
        return getId() != null && Objects.equals(getId(), usuario.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
