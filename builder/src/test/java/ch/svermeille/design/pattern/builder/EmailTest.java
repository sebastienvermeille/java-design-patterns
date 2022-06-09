package ch.svermeille.design.pattern.builder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * @author Sebastien Vermeille
 */
class EmailTest {

  @Test
  void anInstantiatedEmailObjectShouldProvideTheGivenPropertiesBackGracefully(){

    // GIVEN
    final var from = "no-reply@great-company.com";
    final var to = "john.doe@gmail.com";
    final var title = "Newsletter 42";
    final var content = "Hi John, ...";

    // WHEN
    final var email = Email.builder()
        .withFrom(from)
        .withTo(to)
        .withTitle(title)
        .withContent(content)
        .build();

    // THEN
    assertThat(email.getFrom()).isEqualTo(from);
    assertThat(email.getTo()).isEqualTo(to);
    assertThat(email.getTitle()).isEqualTo(title);
    assertThat(email.getContent()).isEqualTo(content);
  }

  @Test
  void instantiateAnEmailWithoutAllValuesGivesNoCompilationIssueGivenFromAndToAreNotProvided(){

    // GIVEN
    final var title = "Newsletter 42";
    final var content = "Hi John, ...";

    // WHEN
    final var email = Email.builder()
        .withTitle(title)
        .withContent(content)
        .build();

    // THEN
    assertThat(email.getFrom()).isNull();
    assertThat(email.getTo()).isNull();
    assertThat(email.getTitle()).isEqualTo(title);
    assertThat(email.getContent()).isEqualTo(content);
  }
}
