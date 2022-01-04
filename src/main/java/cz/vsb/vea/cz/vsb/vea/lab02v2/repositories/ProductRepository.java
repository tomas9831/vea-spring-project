package cz.vsb.vea.cz.vsb.vea.lab02v2.repositories;

import cz.vsb.vea.cz.vsb.vea.lab02v2.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
