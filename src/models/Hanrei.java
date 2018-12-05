package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Table(name = "hanrei")
@NamedQueries({
    @NamedQuery(
            name = "getAllHanrei",
            query = "select h from Hanrei as h "
            ),
    @NamedQuery(
            name = "getHanreiCount",
            query = "select count(h) from Hanrei as h"
            ),
})
@Entity
public class Hanrei {
    @Id
    @Column(name = "id" , nullable=false)
    private Integer id;

    @Column(name = "name", length=40, nullable=false)
    private String name;

    @Lob
    @Column(name = "content", length=200, nullable=false)
    private String content;

    @Column(name = "year", nullable=false)
    private String year;

    @Column(name = "created_at", nullable=false)
    private Timestamp created_at;

    @Column(name = "updated_at", nullable=false)
    private Timestamp updated_at;

    @Column(name = "url", nullable=false)
    private String url;





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
    public void setContent(String content){
        this.content = content;
    }
    public String getYear(){
        return this.year;
    }
    public void setYear(String year){
        this.year = year;
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

    public String getUrl(){
        return this.url;
    }
    public void setUrl(String url){
        this.url = url;
    }
}
