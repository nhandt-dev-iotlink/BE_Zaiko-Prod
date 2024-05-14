package org.api.dto;


public class RepositoryDto {
    private Integer repositoryId;
    private String repositoryCode;
    private String repositoryName;

    public Integer getRepositoryId() {
        return repositoryId;
    }

    public void setRepositoryId(Integer repositoryId) {
        this.repositoryId = repositoryId;
    }

    public String getRepositoryCode() {
        return repositoryCode;
    }

    public void setRepositoryCode(String repositoryCode) {
        this.repositoryCode = repositoryCode;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    public RepositoryDto(Integer repositoryId, String repositoryCode, String repositoryName) {
        this.repositoryId = repositoryId;
        this.repositoryCode = repositoryCode;
        this.repositoryName = repositoryName;
    }

    public RepositoryDto() {
    }
}
