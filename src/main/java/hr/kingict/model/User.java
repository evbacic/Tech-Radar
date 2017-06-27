package hr.kingict.model;

/**
 * Created by emil-vid.bacic on 27.6.2017..
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="user")
public class User  implements Serializable{

    @Id
    private Integer id;
    @Column(name="username")
    private String username;
    private String fName;
    private String lName;

    @SuppressWarnings("unused")
    private User(){}

    public User (Integer id, String username, String fName, String lName){
        super();
        this.id = id;
        this.username = username;
        this.fName = fName;
        this.lName = lName;
    }

    public String getFullName(){
        return this.fName + " " + this.lName;
    }

    public String getUsername(){
        return this.username;
    }

    public Integer getId(){
        return this.id;
    }

    public void setFullName(String fName, String lName){
        this.fName = fName;
        this.lName = lName;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void setUsername(){
        this.username = username;
    }



}
