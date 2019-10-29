package alexanders.springframework.spring5webapp.repositories;

import alexanders.springframework.spring5webapp.model.Author;
import alexanders.springframework.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
