package models;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "category")
@NamedQueries({
    @NamedQuery(
            name = "AllCategory",
            query = "select c from Category as c order by c.id desc"
            ),
    @NamedQuery(
            name = "getCategoryCount",
            query = "select count(c) from Category as c "
            )


})
@Entity
public class Category {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "name", length=50, nullable = false)
    private String name;

    @Lob
    @Column(name = "content", length = 100, nullable = false)
    private String content;

    @Column(name = "created_at", nullable = false)
    private Timestamp created_at;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updated_at;


    public Integer getId(){
        return this.id;
    }
    public void setId(Integer id){
        this.id = id;
    }


    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getContent(){
        return this.content;
    }
    public void  setContent(String content){
        this.content = content;
    }
    public Timestamp getCreated_at(){
        return this.created_at;
    }
    public void setCreated_at(Timestamp created_at){
        this.created_at = created_at;
    }
    public Timestamp getUpdated_at(){
        return this.updated_at;
    }
    public void setUpdated_at(Timestamp updated_at){
        this.updated_at = updated_at;
    }
}
