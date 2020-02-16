package library.dao;

import library.entity.LibRecord;

import java.util.List;
import java.util.Optional;

public interface LibRecordDAO {

    void saveRecord(LibRecord record);

    List<LibRecord> findAll();

    default Optional<LibRecord> findRecord(String id) {
        return Optional.empty();
    }
}
