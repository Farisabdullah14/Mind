package astratech.mindcare.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "jurnal")
public class Jurnal {
    //untuk primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_jurnal;

    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne
    private Pengguna id_user;

    private Date tanggal_jurnal;

    private String konten;


}
