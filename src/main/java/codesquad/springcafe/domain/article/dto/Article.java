package codesquad.springcafe.domain.article.dto;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Article {

    private UUID identifier;
    private String writer;
    private String title;
    private String contents;
    private Timestamp createTime;
    private int viewCount;

    public Article(String identifier, String writer, String title, String contents, Timestamp createTime, Integer viewCount) {
        if (writer != null) this.writer = URLDecoder.decode(writer, StandardCharsets.UTF_8);

        this.title = title;
        this.contents = contents;

        if (createTime != null) this.createTime = createTime;
        else this.createTime = Timestamp.valueOf(LocalDateTime.now());

        if (identifier != null) this.identifier = UUID.fromString(identifier);
        else this.identifier = UUID.randomUUID();

        if (viewCount != null) this.viewCount = viewCount;
        else this.viewCount = 0;
    }

    public void addViewCount() {
        this.viewCount++;
    }

    public void setIdentifierFromString(String identifier) {
        this.identifier = UUID.fromString(identifier);
    }

    public String getIdentifier() {
        return this.identifier.toString();
    }

    public String getWriter() {
        return writer;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public String getRoughCrateTime() {
        return createTime.toString();
    }

    public int getViewCount() {
        return viewCount;
    }

    public String getCreateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return createTime.toLocalDateTime().format(formatter);
    }
}