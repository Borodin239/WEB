package ru.itmo.wp.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(
        indexes = {@Index(columnList = "creationTime")}
)
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @NotEmpty
    @Size(min = 5, max=100)
    @Column(name="content", length=256)
    private String content;

    @CreationTimestamp
    private Date creationTime;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
