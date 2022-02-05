package guestbook.service.serviceImpl;

import guestbook.dao.GuestBookDao;
import guestbook.dao.LogDao;
import guestbook.dto.GuestBook;
import guestbook.dto.Log;
import guestbook.service.GuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class GuestBookServiceImpl implements GuestBookService {
    @Autowired
    GuestBookDao dao;
    @Autowired
    LogDao logDao;

    @Override
    @Transactional
    public List<GuestBook> getGuestbooks(Integer start) {
        return dao.selectAll(start, LIMIT);
    }

    @Override
    @Transactional(readOnly = false)
    public int deleteGuestbook(Long id, String ip) {
        int deleteCount = dao.deleteById(id);
        Log log = new Log();
        log.setIp(ip);
        log.setMethod("DELETE");
        log.setRegdate(new Date());
        logDao.insert(log);
        return deleteCount;
    }

    @Override
    @Transactional(readOnly = false)
    public GuestBook addGuestbook(GuestBook guestbook, String ip) {
        guestbook.setRegdate(new Date());
        Long id = dao.insert(guestbook);
        guestbook.setId(id);

        Log log = new Log();
        log.setIp(ip);
        log.setMethod("INSERT");
        log.setRegdate(new Date());
        logDao.insert(log);

        return guestbook;
    }

    @Override
    public int getCount() {
        return dao.selectCount();
    }
}
