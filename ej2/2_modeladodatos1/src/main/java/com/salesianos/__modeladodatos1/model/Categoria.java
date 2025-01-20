package com.salesianos.__modeladodatos1.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nombre;


    @OneToMany(mappedBy = "categoria", fetch = FetchType.EAGER)
    @Builder.Default
    @ToString.Exclude
    private List<Producto> productos = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "categoria_rel_id",
            foreignKey = @ForeignKey(name = "fk_categoria_padre_categoria")
    )
    private Categoria categoriaPadre;

    @OneToMany(mappedBy = "categoriaPadre", fetch = FetchType.EAGER)
    @Builder.Default
    @ToString.Exclude
    private List<Categoria> listaCategoriasHijas = new ArrayList<>();


    public void addProducto(Producto p) {
        p.setCategoria(this);
        this.getProductos().add(p);
    }


    public void removeProducto(Producto p) {
        this.getProductos().remove(p);
        p.setCategoria(null);
    }

    public void addCategoria(Categoria c) {
        c.setCategoriaPadre(this);
        this.getListaCategoriasHijas().add(c);
    }


    public void removeCategoria(Categoria c) {
        this.getListaCategoriasHijas().remove(c);
        c.setCategoriaPadre(null);
    }


    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Categoria categoria = (Categoria) o;
        return getId() != null && Objects.equals(getId(), categoria.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
