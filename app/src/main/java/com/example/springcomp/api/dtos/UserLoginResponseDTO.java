package com.example.springcomp.api.dtos;

public class UserLoginResponseDTO {
    private String hash;
    private Boolean validCredentials;

    public String getHash() {
        return hash;
    }

    public UserLoginResponseDTO setHash(String hash) {
        this.hash = hash;
        return this;
    }

    public Boolean getValidCredentials() {
        return validCredentials;
    }

    public UserLoginResponseDTO setValidCredentials(Boolean validCredentials) {
        this.validCredentials = validCredentials;
        return this;
    }

    @Override
    public String toString() {
        return "UserLoginResponseDTO{" +
                "hash='" + hash + '\'' +
                ", validCredentials=" + validCredentials +
                '}';
    }
}
