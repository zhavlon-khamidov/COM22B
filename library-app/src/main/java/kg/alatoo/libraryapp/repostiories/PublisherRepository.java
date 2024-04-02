package kg.alatoo.libraryapp.repostiories;

import kg.alatoo.libraryapp.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long>,
        JpaRepository<Publisher, Long> {

}
