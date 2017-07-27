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
    @Column(name = "TELLER_ID")
    private
    @Getter
    @Setter
    Long tellerId;

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
        setTellerId(entity.getTellerId());
        setMasterKey(entity.getMasterKey());
        setPrivateKey(entity.getPrivateKey());
    }

    public String toString() {
        return "TellerPosKeys(masterKey=" + this.masterKey + ", privateKey=" + this.privateKey + ")";
    }
}

