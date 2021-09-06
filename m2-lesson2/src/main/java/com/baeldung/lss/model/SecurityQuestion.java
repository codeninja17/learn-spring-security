package com.baeldung.lss.model;

import javax.persistence.*;

@Entity
public class SecurityQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(targetEntity = User.class,fetch = FetchType.EAGER)
    @JoinColumn(nullable = false,name = "user_id",unique = true)
    private User user;

    @OneToOne(targetEntity = SecurityQuestionDefinition.class,fetch = FetchType.EAGER)
    @JoinColumn(nullable = false,name = "securityQuestionDefinition_id")
    private  SecurityQuestionDefinition securityQuestionDefinition;

    @Column
    private String answer;

    public SecurityQuestion() {}

    public SecurityQuestion(User user, SecurityQuestionDefinition questionDefinition, String answer) {
        this.user = user;
        this.securityQuestionDefinition = questionDefinition;
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SecurityQuestionDefinition getSecurityQuestionDefinition() {
        return securityQuestionDefinition;
    }

    public void setSecurityQuestionDefinition(SecurityQuestionDefinition securityQuestionDefinition) {
        this.securityQuestionDefinition = securityQuestionDefinition;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
