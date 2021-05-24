package com.navdeventerprise.nevdev.data.entity;

import com.navdeventerprise.nevdev.data.strategy.DirtyStateIdentifiable;
import com.navdeventerprise.nevdev.model.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account", schema = "accounts_jsonb")
public class AccountEntity implements Serializable, DirtyStateIdentifiable {

    @Id
    @Column(name = "id")
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @Type(type = "pg-uuid")
    private UUID id;

    @Column(name = "accountdata", nullable = false)
    @Type(type = "com.navdeventerprise.nevdev.data.usertype.JsonbUserType",
            parameters = {@Parameter(name = "className",
                    value = "com.navdeventerprise.nevdev.model.Account")})
    private Account account;

    @Transient
    private boolean dirty;
}
