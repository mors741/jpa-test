package com.mors741.jpa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "T_TELLER_POS_KEYS")
@NoArgsConstructor
public class TellerPosKeys {

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TELLER_ID")
    private
    @Getter
    @Setter
    Teller teller;

    @Column(name = "MASTER_KEY")
    private
    @Getter
    @Setter
    String masterKey;

    @Column(name = "PRIVATE_KEY")
    private
    @Getter
    @Setter
    String privateKey;

    public TellerPosKeys(final TellerPosKeys entity) {
        setTeller(entity.getTeller());
        setMasterKey(entity.getMasterKey());
        setPrivateKey(entity.getPrivateKey());
    }

    public String toString() {
        return "TellerPosKeys(masterKey=" + this.masterKey + ", privateKey=" + this.privateKey + ")";
    }
}

