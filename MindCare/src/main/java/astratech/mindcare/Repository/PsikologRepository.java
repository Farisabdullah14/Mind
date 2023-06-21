package astratech.mindcare.Repository;
import astratech.mindcare.Model.Psikolog;
import astratech.mindcare.Model.Reminder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PsikologRepository  extends CrudRepository<Psikolog, Integer> {

    @Query("SELECT l from Psikolog l where l.id_psikolog =:id_psikolog")
    public Iterable<Reminder> findPsikologByid(@Param("n") String id_psikolog);
}
