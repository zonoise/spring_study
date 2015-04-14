package demo.blog.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Post {
	private String title;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private String text;

    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    public Set<Comment> comments ;

    public long getId() { return id; }
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
