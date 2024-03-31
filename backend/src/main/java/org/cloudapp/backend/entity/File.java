package org.cloudapp.backend.entity;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Folder folder;

    @Column(nullable = false)
    private Date dateCreated;

    @JoinColumn(nullable = false)
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private FileData fileData;

    @JoinColumn(nullable = false)
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private ContentType contentType;
}