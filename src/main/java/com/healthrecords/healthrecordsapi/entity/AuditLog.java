package com.healthrecords.healthrecordsapi.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "audit_logs")
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userEmail;
    private String action;
    private String endpoint;
    private LocalDateTime timestamp;

    public AuditLog() {}

    public AuditLog(String userEmail, String action, String endpoint) {
        this.userEmail = userEmail;
        this.action = action;
        this.endpoint = endpoint;
        this.timestamp = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getUserEmail() { return userEmail; }
    public String getAction() { return action; }
    public String getEndpoint() { return endpoint; }
    public LocalDateTime getTimestamp() { return timestamp; }
}