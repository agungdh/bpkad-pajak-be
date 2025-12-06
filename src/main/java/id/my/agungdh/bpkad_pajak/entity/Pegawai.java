package id.my.agungdh.bpkad_pajak.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Pegawai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, updatable = false)
    private UUID uuid;

    @Column(nullable = false)
    private String nama;
    @Column(nullable = false, unique = true)
    private String nip;

    @Column(nullable = false, updatable = false)
    private long createdAt;

    @PrePersist
    public void prePersist() {
        if (uuid == null) {
            uuid = UUID.randomUUID();
        }
        this.createdAt = System.currentTimeMillis();
    }
}
