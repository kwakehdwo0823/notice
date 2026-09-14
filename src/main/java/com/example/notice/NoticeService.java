package com.example.notice;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {
    private final NoticeRepository noticeRepository;

    public NoticeService(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    public void write(NoticeEntity noticeEntity) {
        noticeRepository.save(noticeEntity);
    }
    public List<NoticeEntity> findAll(){
        return noticeRepository.findAll();
    }

    public void delete(Long id) {
        noticeRepository.deleteById(id);
    }

    public NoticeEntity findById(Long id) {
        return noticeRepository.findById(id).orElse(null);
    }

    public void update(Long id, NoticeEntity updatedNotice) {
        NoticeEntity notice = noticeRepository.findById(id).orElse(null);

        if (notice != null) {
            // 2. 찾아온 글의 제목이랑 내용을 새로운 내용으로 바꿔칩니다!
            notice.setTitle(updatedNotice.getTitle());
            notice.setContent(updatedNotice.getContent());

            // 3. 다시 save를 해주면 JPA가 알아서 업데이트(수정)를 칩니다.
            noticeRepository.save(notice);
        }
    }

    public void save(NoticeEntity notice) {
        noticeRepository.save(notice); // 이 코드가 빠져있거나 비어있으면 저장이 안 됩니다!
    }
}
