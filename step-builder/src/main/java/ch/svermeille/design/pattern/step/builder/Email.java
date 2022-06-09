package ch.svermeille.design.pattern.step.builder;

import lombok.Getter;
import lombok.ToString;

/**
 * @author Sebastien Vermeille
 */
@Getter
@ToString
public class Email {
  private final String from;
  private final String to;
  private final String title;
  private final String content;

  private Email(final Builder builder) {
    from = builder.from;
    to = builder.to;
    title = builder.title;
    content = builder.content;
  }

  public static IFrom builder() {
    return new Builder();
  }


  public interface IBuild {
    Email build();
  }

  public interface IContent {
    IBuild withContent(String val);
  }

  public interface ITitle {
    IContent withTitle(String val);
  }

  public interface ITo {
    ITitle withTo(String val);
  }

  public interface IFrom {
    ITo withFrom(String val);
  }

  public static final class Builder implements IContent, ITitle, ITo, IFrom, IBuild {
    private String content;
    private String title;
    private String to;
    private String from;

    private Builder() {
    }

    @Override
    public IBuild withContent(final String val) {
      content = val;
      return this;
    }

    @Override
    public IContent withTitle(final String val) {
      title = val;
      return this;
    }

    @Override
    public ITitle withTo(final String val) {
      to = val;
      return this;
    }

    @Override
    public ITo withFrom(final String val) {
      from = val;
      return this;
    }

    public Email build() {
      return new Email(this);
    }
  }
}
