package library.dao;

import library.entity.Record;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordDAO extends CrudRepository<Record, Integer> {
}
