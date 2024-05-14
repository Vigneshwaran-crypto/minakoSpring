package com.example.minakospring.minako.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String userName;

    @Column
    private String email;

    @Column
    private String password;

    @Column 
    private String profileImage;

    @Column
    private String coverImage;
    
    
    public Users() {
    	
    }

    public Users(Long id, String userName, String email, String password, String profileImage, String coverImage) {

		this.id = id;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.profileImage = profileImage;
		this.coverImage = coverImage;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

	@Override
	public String toString() {
		return "Users [id=" + id + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ ", profileImage=" + profileImage + ", coverImage=" + coverImage + "]";
	}
    
    
    
    

}
