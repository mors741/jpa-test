package com.mors741.jpa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;



@Entity
@Table(name = "T_TELLER")
@NoArgsConstructor
public class Teller {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private
    @Getter
    @Setter
    Long id;

    @Column(name = "NAME")
    private
    @Getter
    @Setter
    String name;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn(name = "ID")
    private @Getter @Setter TellerPosKeys posKeys;

    public Teller(final Teller entity) {
        setName(entity.getName());
        setPosKeys(entity.getPosKeys());
    }

    public String toString() {
        return "Teller(id=" + this.id + ", name=" + this.name + ", posKeys=" + this.posKeys + ")";
    }
}

