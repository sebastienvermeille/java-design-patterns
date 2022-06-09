package ch.svermeille.design.pattern.builder;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Sebastien Vermeille
 */
@Builder(setterPrefix = "with")
@Getter
@ToString
public class Email {
  private final String from;
  private final String to;
  private final String title;
  private final String content;
}
