package library.dao.impl;

import library.dao.LibRecordDAO;
import library.entity.LibRecord;

import java.util.List;
import java.util.Optional;

public class LibRecordDAOImpl implements LibRecordDAO {

    @Override
    public void saveRecord(LibRecord record) {

    }

    @Override
    public List<LibRecord> findAll() {
        return null;
    }

    @Override
    public Optional<LibRecord> findRecord(String id) {
        return Optional.empty();
    }
}
