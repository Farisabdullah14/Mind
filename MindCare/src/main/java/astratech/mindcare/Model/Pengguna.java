package astratech.mindcare.Model;

import javax.persistence.*;

@Entity
@Table(name = "mahasiswa", uniqueConstraints = @UniqueConstraint(columnNames = "Username"))
public class Pengguna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", nullable = false)
    private Integer id_user;
    private Integer NIM;
    private String nama;
    private String jenis_kelamin;
    private String alamat;
    private String username;
    private String password;

}
