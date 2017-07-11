package hr.kingict.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * A model class which represents User entity from the database
 */
@Entity
@Table(name="user")
public class User implements Serializable{

    private static final long serialVersionUID = 6156169646033708585L;
    /**
     * User id used as primary key
     */
    @Id
    private Integer id;
    /**
     * User's username
     */
    @Column(name="username")
    private String username;
    /**
     * User's first name
     */
    private String fName;
    /**
     * User's last name
     */
    private String lName;

    /**
     * A default constructor for User model
     */
    private User(){}

    /**
     * A constructor with parameters for User model
     * @param id       User's id
     * @param username User's username
     * @param fName    User's first name
     * @param lName    User's last name
     */
    public User (Integer id, String username, String fName, String lName){
        super();
        this.id = id;
        this.username = username;
        this.fName = fName;
        this.lName = lName;
    }

    /**
     * Getter for User's full name
     * @return User's full name
     */
    public String getFullName(){
        return this.fName + " " + this.lName;
    }

    /**
     * Getter for User's username
     * @return username
     */
    public String getUsername(){
        return this.username;
    }

    /**
     * Getter for User's id
     * @return User's id
     */
    public Integer getId(){
        return this.id;
    }

    /**
     * Setter for User's id
     * @param id User's id
     */
    public void setId(Integer id){
        this.id = id;
    }

    /**
     * Setter for User's full name
     * @param fName first name
     * @param lName last name
     */
    public void setFullName(String fName, String lName){
        this.fName = fName;
        this.lName = lName;
    }

    /**
     * Setter for User's username
     * @param username User's username
     */
    public void setUsername(String username){
        this.username = username;
    }



}
