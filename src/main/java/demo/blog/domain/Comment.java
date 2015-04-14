package demo.blog.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by zonoise on 15/04/01.
 */
@Entity
public class Comment {
    private String title;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;


    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "title='" + title + '\'' +
                ", id=" + id +
                '}';
    }
}