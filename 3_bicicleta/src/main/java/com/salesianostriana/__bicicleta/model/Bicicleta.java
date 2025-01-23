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
@Table(name = "bicicleta")
public class Bicicleta {
    @Id @GeneratedValue
    private Long id;
    private String marca;
    private String modelo;
    private String estado;

    @OneToMany(mappedBy = "bicicleta", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    @ToString.Exclude
    private List<Uso> usos = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "estacion_id",
            foreignKey = @ForeignKey(name = "fk_estacion_bicicleta"))
    private Estacion estacion;

    //helpers
    public void addUso(Uso u) {
        u.setBicicleta(this);
        this.getUsos().add(u);
    }

    public void removeUso(Uso u) {
        this.getUsos().remove(u);
        u.setBicicleta(null);
    }



    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Bicicleta bicicleta = (Bicicleta) o;
        return getId() != null && Objects.equals(getId(), bicicleta.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
