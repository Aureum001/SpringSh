package com.example.productos.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.productos.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
