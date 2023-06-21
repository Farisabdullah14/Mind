package astratech.mindcare.Service;

import astratech.mindcare.Model.Psikolog;
import astratech.mindcare.Model.Reminder;
import astratech.mindcare.Repository.PsikologRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PsikologService {
    @Autowired
    PsikologRepository psikologRepository;

    public List<Reminder> getAllData(){
        List<Reminder> reminderList = (List<Reminder>) psikologRepository.findPsikologByid("Aktif");
        return reminderList;
    }

    

}
