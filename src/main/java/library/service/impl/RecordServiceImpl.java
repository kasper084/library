package library.service.impl;

import library.dao.RecordDAO;
import library.entity.Book;
import library.entity.Record;
import library.service.RecordService;
import library.session.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    RecordDAO recordDAO;

    @Autowired
    BookServiceImpl bookService;

    @Override
    public void addRecord(Book book) {
        Record record = new Record();
        record.setUserId(UserSession.getInstance().getUser().getId());
        record.setBookId(book.getId());
        recordDAO.save(record);
    }
}
